package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsChannels;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:10.
 * @Modified By:
 */
public interface INewsChannelsService {
    int insert(NewsChannels bean) throws Exception;

    int update(NewsChannels bean) throws Exception;

    List<NewsChannels> find(NewsChannels bean) throws Exception;

    long findTotal(NewsChannels bean) throws Exception;

    PageData<NewsChannels> findByPage(NewsChannels bean, PageModel model)
            throws Exception;

    NewsChannels findById(Long id) throws Exception;

    NewsChannels findObject(NewsChannels bean) throws Exception;
}
