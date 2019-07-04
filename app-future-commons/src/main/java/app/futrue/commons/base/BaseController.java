package app.futrue.commons.base;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来对controller后台返回到前台及前台请求后台的公共部分统一处理 1：异步请求方式时，返回的Map数据处理
 * 
 * @author zhaoyong
 * 
 */
public class BaseController {

	public Logger logger = Logger.getLogger(BaseController.class);

	public Map<String, Object> resultMap = new HashMap<String, Object>();

	/**
	 * true:成功,false：失败
	 */
	private static final String SUCCESS = "success";

	private static final String RESULT = "result";

	public BaseController() {
		if (resultMap == null) {
			resultMap = new HashMap<String, Object>();
		}
		resultMap.put(SUCCESS, false);
	}

	/**
	 * 异步方式成功时返回的数据
	 * 
	 * @param obj
	 *            返回的数据
	 * @return
	 */
	public Map<String, Object> putSuccessData(Object obj) {
		resultMap.put(SUCCESS, true);
		if (obj == null) {
			obj = new ArrayList<Object>();
		}
		resultMap.put(RESULT, obj);
		return resultMap;
	}

	/**
	 * 异步方式失败时返回的数据
	 * 
	 * @param e
	 * @param obj
	 *            返回的数据（错误消息）
	 * @return
	 */
	public Map<String, Object> putFailedData(String message, Exception e) {
		if (e != null) {
			if ("BusinessException".equals(e.getClass().getSimpleName())) {
				message = e.getLocalizedMessage();
			}else{
				logger.warn(message, e);
			}
		}
		resultMap.put(SUCCESS, false);
		resultMap.put(RESULT, message);
		return resultMap;
	}
}
