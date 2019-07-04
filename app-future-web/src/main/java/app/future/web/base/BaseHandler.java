package app.future.web.base;

import java.util.HashMap;
import java.util.Map;

/** 
 * @description: Handler层对应返回页面的公共处理类
 * @version: 1.0
 * @modify: 
 */
public class BaseHandler {

	/**
	 * 公共日志打印工具类
	 */
	private Logger logger = LoggerFactory.getLogger(BaseHandler.class);
	/**
	 * 状态码
	 */
	private static final String CODE = "code" ;
	/**
	 * 返回失败时，错误代码，用来区分是否需要跳转 1：需要
	 */
	public static final int CODE_GOTO = 1 ;
	/**
	 * true:成功,false：失败
	 */
	private static final String SUCCESS = "success" ;
	/**
	 * 返回数据结果 key
	 */
	private static final String RESULT = "result";

	
	
	/**
	 * 返回响应页面 未登录
	 * @param rsp
	 */
	public void respUnlogin(IJsonResponse resp){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(CODE, -1);
		map.put(SUCCESS, false);
		map.put(RESULT, "未登录");
		resp.setData(map);
	}
	
	/**
	 * 返回响应页面 失败
	 * @param rsp
	 */
	public void respFailed(IJsonResponse rsp,Object... result){
		Map<String,Object> map = new HashMap<String,Object>();
		Object data = null;
		Object code = 0;
		if (result!=null&&result.length>0) {
			data = result[0];
			if(result.length>1){
				code = result[1];
			}
			logger.warn("返回响应失败："+data+",code:"+code);
		}
		map.put(CODE, code);
		map.put(SUCCESS, false);
		map.put(RESULT, data);
		rsp.setData(map);
	}
	
	/**
	 * 获取错误信息
	 * @param e
	 * @return
	 */
	private String getErrorMassage(Exception e){
		String message = null;
		if (e != null) {
			if (e instanceof RpcException) {
				message = "网络请求超时！";
				logger.warn(""+e);
			}else if (e instanceof HbecBizException) {
				if(ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ABOSS.code.equals(((HbecBizException) e).getErrCode())){
					message=ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ABOSS.value;
					return message;
				}else if(ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ESB.code.equals(((HbecBizException) e).getErrCode())){
					message=ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ESB.value;
					return message;
				}
				message = ((HbecBizException)e).getErrMsg();
			}else{
				message = "网络请求出错！";
				e.printStackTrace();
			}
		}
		return message;
	}
	/**
	 * 返回响应页面 失败,打印异常
	 * @param rsp
	 */
	public void respFailed(IJsonResponse resp,Exception e){
		Map<String,Object> map = new HashMap<String,Object>();
		String message = getErrorMassage(e);
		logger.warn(message);
		map.put(CODE, 0);
		map.put(SUCCESS, false);
		map.put(RESULT, message);
		resp.setData(map);
	}
	
	/**
	 * 返回响应页面 失败,打印异常
	 * @param rsp
	 */
	public void respFailed(IJsonResponse rsp, Exception e, Object result){
		Map<String,Object> map = new HashMap<String,Object>();
		if (e!=null) {
			logger.error(""+e);
		}
		map.put(CODE, 0);
		map.put(SUCCESS, false);
		map.put(RESULT, result);
		rsp.setData(map);
	}
	
	/**
	 * 同步页面，返回响应页面失败,打印异常
	 * @param resp
	 */
	public void respSyncFailed(IViewResponse resp,Exception e){
		String message = getErrorMassage(e);
		if(ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ABOSS.value.equals(message)||
				ErrorCodeEnum.ERROR_CODE_CLOSE_TIME_ESB.value.equals(message)){
			resp.redirect(switchUrl);
			return;
		}
		logger.warn(message);
		resp.setData(CODE, 0);
		resp.setData(SUCCESS, false);
		resp.setData(RESULT, message);
	}
	
	/**
	 * 同步页面，返回响应页面失败,打印异常
	 * @param rsp
	 */
	public void respSyncFailed(IViewResponse rsp,Object result){
	    logger.warn(""+result);
		rsp.setData(CODE, 0);
		rsp.setData(SUCCESS, false);
		rsp.setData(RESULT, result);
	}
	
	/**
	 * 同步页面，返回响应页面失败,打印异常
	 * @param rsp
	 */
	public void respSyncFailed(IViewResponse rsp, Exception e, Object result){
		if (e!=null) {
			logger.error(""+e);
		}
		rsp.setData(CODE, 0);
		rsp.setData(SUCCESS, false);
		rsp.setData(RESULT, result);
	}
	
	/**
	 * 返回响应页面 成功信息
	 * @param rsp
	 * @param i		返回码
	 * @param result	返回消息
	 */
	public void respSuccess(IJsonResponse rsp, Integer i, Object result){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(CODE, i);
		map.put(SUCCESS, true);
		map.put(RESULT, result);
		rsp.setData(map);
	}
	
	/**
	 * 返回响应页面 成功信息
	 * @param rsp
	 * @param result	返回消息
	 */
	public void respSuccess(IJsonResponse resp, Object result){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(CODE, 1);
		map.put(SUCCESS, true);
		map.put(RESULT, result);
		resp.setData(map);
	}
	
	/**
	 * 页面初始化，生成提交令牌
	 */
	public void generateSubmitToken(ISession ses){
		try {
			ses.setServerSideData("token", String.valueOf(System.currentTimeMillis()));
		} catch (HbecServiceException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 防重复提交
	 */
	public Boolean preventRepetSubmit(ISession ses, IRequest req){
		boolean flag = false;
		ReadOnlyHttpParams param=req.getParams();
		String c_token = param.getValue("token");
		String s_token = ses.getServerSideData("token");
		String new_token = String.valueOf(System.currentTimeMillis());
		if(c_token.equals(s_token)){
			try {
				ses.setServerSideData("token", new_token);
				s_token = ses.getServerSideData("token");
			} catch (HbecServiceException e) {
				e.printStackTrace();
			}
			flag = true; 
		}
		return flag;
	}
	
	/**
	 * 判断用户来源是否是欧冶APP
	 * @param session
	 * @return true:是
	 */
	public static boolean isOuyyelAPP(ISession session){
		boolean result = false;
		Map<String, String> ticketMap = session.getTicketMap();
        if (MapUtils.isNotEmpty(ticketMap)) {
        	String appId = ticketMap.get("appId");
        	if ("OuYeelf".equals(appId)) {
        		result = true;
			}
        }
        return result;
	}
	
	public static void main(String[] args) throws Exception {
		String json = "{'v':{'sourceData':{'v':{'latestTimeWeightedCumulativeNetPresentValueChange':{'v':'0.0001','t':'17'},'latest1monthYield':{'v':'0.21','t':'17'},'latest1weekTypeYieldRank':{'v':624,'t':'6'},'hbecTypeTagstring':{'v':'Monetary','t':'14'},'latest3yearTypeAverageYield':{'v':'10.14','t':'17'},'applicationStatusInt':{'v':2,'t':'6'},'pinyinAbbrName':{'v':'hbxjba','t':'14'},'typeYieldTotalSinceFounding':{'v':16,'t':'6'},'sinceThisYearYield':{'v':'0.67','t':'17'},'hbecRiskLevel':{'v':'低风险','t':'14'},'latest7daysYearsYield':{'v':'2.4050','t':'17'},'yieldSinceTypeAverageYield':{'v':'54.44','t':'17'},'latest10kAccrual':{'v':'0.6645','t':'17'},'applicationStatusVar':{'v':'暂停大额申购','t':'14'},'latest2yearTypeYieldTotal':{'v':660,'t':'6'},'latestHalfYearTypeYieldRank':{'v':459,'t':'6'},'latest35daysYearsYield':{'v':'2.46','t':'17'},'latest2yearTypeYieldRank':{'v':416,'t':'6'},'companyName':{'v':'华宝基金管理有限公司','t':'14'},'latestYearTypeYieldRank':{'v':435,'t':'6'},'latestNetPresentValue':{'v':'1.0000','t':'17'},'latest3yearTypeYieldTotal':{'v':489,'t':'6'},'minimumApplication':{'v':500,'t':'6'},'latestYearTypeAverageYield':{'v':'3.17','t':'17'},'managerIds':{'v':'5400,1466','t':'14'},'latest1weekTypeAverageYield':{'v':'0.05','t':'17'},'typeYieldRankSinceFounding':{'v':13,'t':'6'},'rptNetasset':{'v':'247305435.4500','t':'17'},'investmentRange':{'v':'本基金主要投资于货币市场工具,包括现金,期限在一年以内(含一年)的银行存款,债券回购,中央银行票据,同业存单,剩余期限在三百九十七天以内(含三百九十七天)的非金融企业债务融资工具,债券,资产支持证券,经中国证监会,中国人民银行认可的其他具有良好流动性的货币市场工具.','t':'14'},'redemptionStatusVar':{'v':'开放赎回','t':'14'},'latestHalfYearYieldRank':{'v':6654,'t':'6'},'pinyinName':{'v':'hbxjbhbscjj','t':'14'},'fundTotalSize':{'v':'247305400.00','t':'17'},'investmentCharacter':{'v':'货币型','t':'14'},'latest14daysYearsYield':{'v':'2.42','t':'17'},'latest2yearYield':{'v':'7.32','t':'17'},'latest3monthsYield':{'v':'0.64','t':'17'},'hbecTypeTagCh':{'v':[{'v':'货币型','t':'14'}],'t':'[Ljava.lang.String;'},'ratingInterval':{'v':'1年','t':'14'},'investmentObjective':{'v':'保持本金的安全性和基金财产的流动性,追求高于比较基准的稳定收益。','t':'14'},'latest3yearYieldRank':{'v':2291,'t':'6'},'latest1monthTypeYieldTotal':{'v':765,'t':'6'},'sourceManagerIds':{'v':'7C2261,01186','t':'14'},'lastModifiedDt':{'v':'2019-04-04 03:30:13.0','t':'16'},'latest3monthsTypeAverageYield':{'v':'0.66','t':'17'},'sinceThisYearTypeAverageYield':{'v':'0.71','t':'17'},'latestHalfYearTypeYieldTotal':{'v':764,'t':'6'},'latest1monthYieldRank':{'v':6803,'t':'6'},'netAssetValue':{'v':'16433.4438','t':'17'},'foundingDate':{'v':'2005-03-31 00:00:00.0','t':'16'},'yieldRankSinceFounding':{'v':1202,'t':'6'},'securityCode':{'v':'240006','t':'14'},'starLevel':{'v':'3.0000','t':'17'},'fundTotal':{'v':8421,'t':'6'},'applicationStatus':{'v':'正常开放','t':'14'},'latestYearTypeYieldTotal':{'v':764,'t':'6'},'abbrName':{'v':'华宝现金宝A','t':'14'},'latest28daysYearsYield':{'v':'2.44','t':'17'},'latest3yearYield':{'v':'10.21','t':'17'},'latestYearYieldRank':{'v':4247,'t':'6'},'latestTimeWeightedCumulativeNetPresentValue':{'v':'1.5223','t':'17'},'latest3monthsTypeYieldTotal':{'v':765,'t':'6'},'sinceThisYearTypeYieldRank':{'v':535,'t':'6'},'isAvailable':{'v':1,'t':'6'},'latest2yearTypeAverageYield':{'v':'7.34','t':'17'},'latest1monthTypeAverageYield':{'v':'0.23','t':'17'},'latest1weekYieldRank':{'v':5707,'t':'6'},'hbecTypeTagChstring':{'v':'货币型','t':'14'},'custodianFeeRatio':{'v':'0.1000','t':'17'},'latest2yearYieldRank':{'v':3543,'t':'6'},'sinceThisYearYieldRank':{'v':7247,'t':'6'},'latest3yearTypeYieldRank':{'v':304,'t':'6'},'rptNetassetDate':{'v':'2018-12-31 00:00:00.0','t':'16'},'managerNames':{'v':'高文庆,陈昕','t':'14'},'custodianBank':{'v':'中国建设银行','t':'14'},'ratingAgency':{'v':'Wind资讯','t':'14'},'yieldSinceFounding':{'v':'52.23','t':'17'},'latest3monthsYieldRank':{'v':7229,'t':'6'},'latest3monthsTypeYieldRank':{'v':540,'t':'6'},'latestYield':{'v':'0.01','t':'17'},'sourceCompanyId':{'v':'04M98E5794','t':'14'},'latestHalfYearYield':{'v':'1.42','t':'17'},'latest1weekTypeYieldTotal':{'v':765,'t':'6'},'sinceThisYearTypeYieldTotal':{'v':765,'t':'6'},'shareLatestDate':{'v':'2018-12-31 00:00:00.0','t':'16'},'id':{'v':2519,'t':'8'},'windId':{'v':'240006.OF','t':'14'},'ratingDate':{'v':'2019-01-31 00:00:00.0','t':'16'},'name':{'v':'华宝现金宝货币市场基金','t':'14'},'latest1monthTypeYieldRank':{'v':569,'t':'6'},'investmentStrategy':{'v':'(1)研究宏观经济指标及利率变动趋势,确定投资组合平均久期。 (2)在满足投资组合平均久期的条件下,充分考虑相关品种的收益性、流动性、信用等级,确定组合配置。 (3)利用现代金融分析方法和工具,优化组合配置效果,实现组合增值。 (4)采用均衡分布、滚动投资、优化期限配置等方法,加强流动性管理。 (5)实时监控各品种利率变动,捕捉无风险套利机会。','t':'14'},'hbecTypeTag':{'v':[{'v':'Monetary','t':'14'}],'t':'[Ljava.lang.String;'},'monetaryFundType':{'v':'A类','t':'14'},'companyAbbrName':{'v':'华宝基金','t':'14'},'latest1weekYield':{'v':'0.05','t':'17'},'latestYearYield':{'v':'3.20','t':'17'},'theDate':{'v':'2019-04-03 00:00:00.0','t':'16'},'latestHalfTypeAverageYield':{'v':'1.41','t':'17'},'managementFeeRatio':{'v':'0.3300','t':'17'},'companyId':{'v':602,'t':'6'}},'t':'hbec.commons.transaction.bean.fund.FundInfo'},'version':{'v':'1554321852288','t':'14'}},'t':'hbec.commons.transaction.utils.CacheObject'}";
		JSONObject jsonOject=new JSONObject(json);
		JsonValueObject jsonValueObject=CacheUtils.convertJsonValueObject(jsonOject);
		System.out.println(jsonValueObject);
	}
}
