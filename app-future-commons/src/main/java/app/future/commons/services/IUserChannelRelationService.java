package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UserChannelRelation;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:06.
 * @Modified By:
 */
public interface IUserChannelRelationService {
    int insert(UserChannelRelation bean) throws Exception;

    int update(UserChannelRelation bean) throws Exception;

    List<UserChannelRelation> find(UserChannelRelation bean) throws Exception;

    long findTotal(UserChannelRelation bean) throws Exception;

    PageData<UserChannelRelation> findByPage(UserChannelRelation bean, PageModel model)
            throws Exception;

    UserChannelRelation findById(Long id) throws Exception;

    UserChannelRelation findObject(UserChannelRelation bean) throws Exception;
}
