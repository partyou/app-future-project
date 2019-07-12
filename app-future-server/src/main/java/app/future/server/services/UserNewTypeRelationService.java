package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UserNewTypeRelation;
import app.future.server.dao.UserNewTypeRelationMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserNewTypeRelationService{

	@Autowired
	private UserNewTypeRelationMapper userNewTypeRelationMapper;
	
	
	public int insert(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.insert(bean);
	}
	
	
	public int update(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.updateByPrimaryKeySelective(bean);
	}

	
	public List<UserNewTypeRelation> find(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.find(bean);
	}

	
	public long findTotal(UserNewTypeRelation bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = userNewTypeRelationMapper.findTotal(bean);
		}
		return result;
	}
	
	
	public PageData<UserNewTypeRelation> findByPage(UserNewTypeRelation bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    public UserNewTypeRelation findById(Long id) throws Exception {
        return userNewTypeRelationMapper.selectByPrimaryKey(id);
    }

	
	public UserNewTypeRelation findObject(UserNewTypeRelation bean) throws Exception {
		UserNewTypeRelation result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<UserNewTypeRelation> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
