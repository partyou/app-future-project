package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.ChannelNewsTypeRelation;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:24.
 * @Modified By:
 */
public interface IChannelNewsTypeRelationService {
    int insert(ChannelNewsTypeRelation bean) throws Exception;

    int update(ChannelNewsTypeRelation bean) throws Exception;

    List<ChannelNewsTypeRelation> find(ChannelNewsTypeRelation bean) throws Exception;

    long findTotal(ChannelNewsTypeRelation bean) throws Exception;

    PageData<ChannelNewsTypeRelation> findByPage(ChannelNewsTypeRelation bean, PageModel model)
            throws Exception;

    ChannelNewsTypeRelation findById(Long id) throws Exception;

    ChannelNewsTypeRelation findObject(ChannelNewsTypeRelation bean) throws Exception;
}
