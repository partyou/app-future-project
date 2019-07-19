package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsInfo;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/15 18:25.
 * @Modified By:
 */
public interface INewsInfoService {
    int insert(NewsInfo bean) throws Exception;

    int update(NewsInfo bean) throws Exception;

    List<NewsInfo> find(NewsInfo bean) throws Exception;

    long findTotal(NewsInfo bean) throws Exception;

    PageData<NewsInfo> findByPage(NewsInfo bean, PageModel model)
            throws Exception;

    NewsInfo findById(Long id) throws Exception;

    NewsInfo findObject(NewsInfo bean) throws Exception;
}
