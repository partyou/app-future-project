package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsType;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:07.
 * @Modified By:
 */
public interface INewsTypeService {
    int insert(NewsType bean) throws Exception;

    int update(NewsType bean) throws Exception;

    List<NewsType> find(NewsType bean) throws Exception;

    long findTotal(NewsType bean) throws Exception;

    PageData<NewsType> findByPage(NewsType bean, PageModel model)
            throws Exception;

    NewsType findById(Long id) throws Exception;

    NewsType findObject(NewsType bean) throws Exception;
}
