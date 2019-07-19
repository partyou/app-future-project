package app.future.server.dao;

import app.future.commons.base.BaseMapper;
import app.future.commons.bean.Brand;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand>{

    List<Brand> find(Brand bean);

	int deleteByPrimaryKey(Short brandId);

    Brand selectByPrimaryKey(Short brandId);

    int updateByPrimaryKeyWithBLOBs(Brand record);

}