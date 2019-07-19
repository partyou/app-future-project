package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.DicType;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:22.
 * @Modified By:
 */
public interface IDicTypeService {
    int insert(DicType bean) throws Exception;

    int update(DicType bean) throws Exception;

    List<DicType> find(DicType bean) throws Exception;

    long findTotal(DicType bean) throws Exception;

    PageData<DicType> findByPage(DicType bean, PageModel model)
            throws Exception;

    DicType findById(Long id) throws Exception;

    DicType findObject(DicType bean) throws Exception;
}
