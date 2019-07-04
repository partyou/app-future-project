package app.future.server.services;


import app.futrue.commons.base.PageModel;
import app.futrue.commons.bean.Brand;
import app.futrue.commons.services.IBrandService;
import app.future.server.dao.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Service("brandService")
@Transactional(value = "transactionManager",propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BrandService implements IBrandService{

	@Autowired
		private BrandMapper brandMapper;

		@Override
		public List<Brand> find(Brand bean)
				throws Exception {
			List<Brand> list = null;
			if (bean!=null) {
				list = brandMapper.find(bean);
			}
			return list;
		}

		@Override
		public Map<String, Object> findByPage(Brand bean,
				PageModel model) throws Exception {
			bean.setModel(model);
			Long total = findTotal(bean);
			List<Brand> list = find(bean);
			return PageModel.putGridMap(total, list);
		}

		@Override
		public Brand findById(Serializable id) throws Exception {
			//
			Brand bean = null;
			if (id!=null) {
				bean = brandMapper.selectByPrimaryKey((Short)id);
			}
			return bean;
		}
		@Override
		public int delete(Serializable id) throws Exception {
			int result = 0;
			if (id!=null) {
				result = brandMapper.deleteByPrimaryKey((Short)id);
			}
			return result;
		}

		@Override
		public int insert(Brand bean) throws Exception {
			int result = 0;
			if (bean!=null) {
				result = brandMapper.insertSelective(bean);
			}
			return result;
		}

		@Override
		public int update(Brand bean) throws Exception {
			int result = 0;
			if (bean != null) {
				result = brandMapper.updateByPrimaryKeySelective(bean);
			}
			return result;
		}

		@Override
		public Long findTotal(Brand bean) throws Exception {
			Long result = null;
			if (bean != null) {
				result = brandMapper.findTotal(bean);
			}
			return result;
		}

	}
