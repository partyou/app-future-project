package app.future.server.biz;

import app.future.commons.base.PageModel;
import app.future.commons.bean.ChannelNewsTypeRelation;
import app.future.commons.bean.NewsInfo;
import app.future.commons.bean.UserNewTypeRelation;
import app.future.commons.biz.INewsInfoBizService;
import app.future.server.services.ChannelNewsTypeRelationService;
import app.future.server.services.NewsInfoService;
import app.future.server.services.UserNewTypeRelationService;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/** 
 * @description: 新闻业务服务类
 * @version: 1.0
 * @modify: 
 */
@Service
public class NewsInfoBizService implements INewsInfoBizService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserNewTypeRelationService userNewTypeRelationService;
	@Autowired
	private ChannelNewsTypeRelationService channelNewsTypeRelationService;
	@Autowired
	private NewsInfoService newsInfoService;
	
	/**
	 * 根据用户、频道查询新闻列表数据 
	 * @param bean
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<NewsInfo> findByPage(NewsInfo bean, PageModel model) throws Exception {
		List<NewsInfo> list = null;
		Long userId = bean.getUserId();
		Long channelsId = bean.getChannelsId();
		//查询频道对应的所有新闻类型（可缓存）
		ChannelNewsTypeRelation queryTmp = new ChannelNewsTypeRelation();
		queryTmp.setChannelId(channelsId);
		List<ChannelNewsTypeRelation> channelNewsTypeRelations = channelNewsTypeRelationService.find(queryTmp);
		//如果渠道对应的新闻类型没有，则直接返回
		if (CollectionUtils.isNotEmpty(channelNewsTypeRelations)) {
			List<Long> newsTypeList = new ArrayList<Long>();
			for (ChannelNewsTypeRelation channelNewsTypeRelation : channelNewsTypeRelations) {
				newsTypeList.add(channelNewsTypeRelation.getNewsTypeId());
			}
			newsTypeList = this.removeNotLikeData(userId, newsTypeList);
			//根据新闻类型查询前N条新闻
			bean.setModel(model);
			bean.setNewsTypeList(newsTypeList);
			list = newsInfoService.find(bean);
		}
		logger.info("查询新闻列表数据返回："+ (list==null?0:list.size()));
		return null;
	}
	
	/**
	 * 排除掉用户不喜欢的新闻类型
	 * @param userId
	 * @param newsTypeList
	 * @return
	 * @throws Exception
	 */
	private List<Long> removeNotLikeData(Long userId, 
			List<Long> newsTypeList) throws Exception{
		//查询用户新闻类型关联表，查出用户不喜欢的类型
		UserNewTypeRelation tmp = new UserNewTypeRelation();
		tmp.setUserId(userId);
		List<UserNewTypeRelation> userNewTypeRelations = userNewTypeRelationService.find(tmp);
		if (CollectionUtils.isNotEmpty(userNewTypeRelations)) {
			for (Long newsTypeId : newsTypeList) {
				for (UserNewTypeRelation userNewTypeRelation : userNewTypeRelations) {
					Long userNewsTypeId = userNewTypeRelation.getNewsTypeId();
					if (newsTypeId == userNewsTypeId) {
						//TODO
					}
				}
			}
		}
		return newsTypeList;
	}	
}
