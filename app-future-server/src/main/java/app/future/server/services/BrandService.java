package app.future.server.services;

import app.future.commons.base.PageModel;
import app.future.commons.bean.Brand;
import app.future.commons.services.IBrandService;
import app.future.server.dao.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BrandService implements IBrandService{

		@Autowired
		private BrandMapper brandMapper;


		public List<Brand> find(Brand bean)
				throws Exception {
			List<Brand> list = null;
			if (bean!=null) {
				list = brandMapper.find(bean);
			}
			return list;
		}


		public Map<String, Object> findByPage(Brand bean,
											  PageModel model) throws Exception {
			bean.setModel(model);
			Long total = findTotal(bean);
			List<Brand> list = find(bean);
			return PageModel.putGridMap(total, list);
		}


		public Brand findById(Serializable id) throws Exception {
			//
			Brand bean = null;
			if (id!=null) {
				bean = brandMapper.selectByPrimaryKey((Short)id);
			}
			return bean;
		}

		public int delete(Serializable id) throws Exception {
			int result = 0;
			if (id!=null) {
				result = brandMapper.deleteByPrimaryKey((Short)id);
			}
			return result;
		}


		public int insert(Brand bean) throws Exception {
			int result = 0;
			if (bean!=null) {
				result = brandMapper.insertSelective(bean);
			}
			return result;
		}


		public int update(Brand bean) throws Exception {
			int result = 0;
			if (bean != null) {
				result = brandMapper.updateByPrimaryKeySelective(bean);
			}
			return result;
		}


		public Long findTotal(Brand bean) throws Exception {
			Long result = null;
			if (bean != null) {
				result = brandMapper.findTotal(bean);
			}
			return result;
		}

	}
