package app.future.server.biz;

import app.future.commons.bean.NewsChannels;
import app.future.commons.bean.UserChannelRelation;
import app.future.commons.biz.INewsChannelsBizService;
import app.future.commons.constants.CommonConstant;
import app.future.server.services.NewsChannelsService;
import app.future.server.services.UserChannelRelationService;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsChannelsBizService implements INewsChannelsBizService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserChannelRelationService userChannelRelationService;
	@Autowired
	private NewsChannelsService newsChannelsService;
	
	/**
	 * 根据用户查询频道列表
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<NewsChannels> queryNewsChannelsByUser(Long userId)throws Exception{
		List<NewsChannels> list = null;
		if (userId==null) {//访客
			userId = CommonConstant.USER_VISITOR;
		}
		UserChannelRelation query = new UserChannelRelation();
		query.setUserId(userId);
		List<UserChannelRelation> relationList = userChannelRelationService.find(query);
		if (CollectionUtils.isNotEmpty(relationList)) {
			list = new ArrayList<NewsChannels>();
			for (UserChannelRelation userChannelRelation : relationList) {
				Long channelId = userChannelRelation.getChannelId();
				NewsChannels channel = newsChannelsService.findById(channelId);
				list.add(channel);
			}
		}
		logger.info("查询频道列表数据返回："+ (list==null?0:list.size()));
		return list;
	}

}
