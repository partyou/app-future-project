package app.futrue.commons.services;

import app.futrue.commons.base.PageModel;
import app.futrue.commons.bean.Brand;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBrandService {

    List<Brand> find(Brand bean) throws Exception;

    Map<String, Object> findByPage(Brand bean,
                                   PageModel model) throws Exception;

    int delete(Serializable id) throws Exception;

    int insert(Brand bean) throws Exception;

    int update(Brand bean) throws Exception;

    Long findTotal(Brand bean) throws Exception;

}
