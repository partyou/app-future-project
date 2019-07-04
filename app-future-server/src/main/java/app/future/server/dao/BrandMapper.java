package app.future.server.dao;

import app.futrue.commons.base.BaseMapper;
import app.futrue.commons.bean.Brand;

public interface BrandMapper extends BaseMapper<Brand> {

	int deleteByPrimaryKey(Short brandId);

    Brand selectByPrimaryKey(Short brandId);

    int updateByPrimaryKeyWithBLOBs(Brand record);
}