package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UserNewTypeRelation;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:05.
 * @Modified By:
 */
public interface IUserNewTypeRelationService {
    int insert(UserNewTypeRelation bean) throws Exception;

    int update(UserNewTypeRelation bean) throws Exception;

    List<UserNewTypeRelation> find(UserNewTypeRelation bean) throws Exception;

    long findTotal(UserNewTypeRelation bean) throws Exception;

    PageData<UserNewTypeRelation> findByPage(UserNewTypeRelation bean, PageModel model)
            throws Exception;

    UserNewTypeRelation findById(Long id) throws Exception;

    UserNewTypeRelation findObject(UserNewTypeRelation bean) throws Exception;
}
