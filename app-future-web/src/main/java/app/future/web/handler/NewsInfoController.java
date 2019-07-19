package app.future.web.handler;

import app.future.commons.base.BaseController;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsChannels;
import app.future.commons.bean.NewsInfo;
import app.future.commons.biz.INewsChannelsBizService;
import app.future.commons.biz.INewsInfoBizService;
import app.future.commons.constants.CommonConstant;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("news")
public class NewsInfoController extends BaseController {

	@Reference
	private INewsChannelsBizService newsChannelsBizService;
	@Reference
	private INewsInfoBizService newsInfoBizService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("index.html")
	public String index(NewsInfo bean, ModelMap modelMap, HttpServletRequest request){
		try {
			//查询用户频道关系表,拿到自己需要的频道
			List<NewsChannels> newsChannelsList = newsChannelsBizService.queryNewsChannelsByUser(null);
			modelMap.put("newsChannelsList", newsChannelsList);
		} catch (Exception e) {
			putFailedData("查询频道列表出错！", e);
		}
		return "/news/index.ftl";
	}
	
	@RequestMapping("content.html")
	public String content(NewsInfo bean, PageModel model, ModelMap modelMap){
		try {
			Long userId = CommonConstant.USER_VISITOR;
			Long channelsId = 1L;
			NewsInfo query = new NewsInfo();
			query.setUserId(userId);
			query.setChannelsId(channelsId);
			model = new PageModel(1, 10);
			//根据用户、频道查询新闻列表数据 
			List<NewsInfo> newsList = newsInfoBizService.findByPage(query,model);
			modelMap.put("newsList", newsList);
		} catch (Exception e) {
			putFailedData("查询新闻列表出错！", e);
		}
		return "/news/content.ftl";
	}
}
