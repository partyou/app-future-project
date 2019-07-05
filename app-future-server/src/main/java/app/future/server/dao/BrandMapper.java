package app.future.server.dao;

import app.future.commons.base.BaseMapper;
import app.future.commons.bean.Brand;

public interface BrandMapper extends BaseMapper<Brand> {

	int deleteByPrimaryKey(Short brandId);

    Brand selectByPrimaryKey(Short brandId);

    int updateByPrimaryKeyWithBLOBs(Brand record);
}