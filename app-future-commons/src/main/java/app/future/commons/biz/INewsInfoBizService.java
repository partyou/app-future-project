package app.future.commons.biz;

import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsInfo;

import java.util.List;

public interface INewsInfoBizService {

    /**
     * 根据用户、频道查询新闻列表数据
     * @param bean
     * @param model
     * @return
     * @throws Exception
     */
    List<NewsInfo> findByPage(NewsInfo bean, PageModel model) throws Exception;
}
