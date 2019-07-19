package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UserNewTypeRelation;
import app.future.commons.services.IUserNewTypeRelationService;
import app.future.server.dao.UserNewTypeRelationMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserNewTypeRelationService implements IUserNewTypeRelationService {

	@Autowired
	private UserNewTypeRelationMapper userNewTypeRelationMapper;
	
	
	@Override
	public int insert(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.insert(bean);
	}
	
	
	@Override
	public int update(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
	public List<UserNewTypeRelation> find(UserNewTypeRelation bean) throws Exception {
		return userNewTypeRelationMapper.find(bean);
	}

	
	@Override
	public long findTotal(UserNewTypeRelation bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = userNewTypeRelationMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
	public PageData<UserNewTypeRelation> findByPage(UserNewTypeRelation bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
	public UserNewTypeRelation findById(Long id) throws Exception {
        return userNewTypeRelationMapper.selectByPrimaryKey(id);
    }

	
	@Override
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
