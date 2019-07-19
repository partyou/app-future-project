package app.future.commons.services;

import app.future.commons.base.PageModel;
import app.future.commons.bean.Card;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:33.
 * @Modified By:
 */
public interface ICardService {
    List<Card> find(Card bean) throws Exception;

    Map<String, Object> findByPage(Card bean, PageModel model)
            throws Exception;

    Card findById(Serializable id) throws Exception;

    int delete(Serializable id) throws Exception;

    int insert(Card bean) throws Exception;

    int update(Card bean) throws Exception;

    Long findTotal(Card bean) throws Exception;
}
