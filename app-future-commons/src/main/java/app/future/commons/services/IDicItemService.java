package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.DicItem;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:23.
 * @Modified By:
 */
public interface IDicItemService {
    int insert(DicItem bean) throws Exception;

    int update(DicItem bean) throws Exception;

    List<DicItem> find(DicItem bean) throws Exception;

    long findTotal(DicItem bean) throws Exception;

    PageData<DicItem> findByPage(DicItem bean, PageModel model)
            throws Exception;

    DicItem findById(Long id) throws Exception;

    DicItem findObject(DicItem bean) throws Exception;
}
