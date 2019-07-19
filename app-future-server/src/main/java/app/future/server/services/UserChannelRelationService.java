package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UserChannelRelation;
import app.future.commons.services.IUserChannelRelationService;
import app.future.server.dao.UserChannelRelationMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserChannelRelationService implements IUserChannelRelationService {

	@Autowired
	private UserChannelRelationMapper userChannelRelationMapper;
	
	
	@Override
    public int insert(UserChannelRelation bean) throws Exception {
		return userChannelRelationMapper.insert(bean);
	}
	
	
	@Override
    public int update(UserChannelRelation bean) throws Exception {
		return userChannelRelationMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
    public List<UserChannelRelation> find(UserChannelRelation bean) throws Exception {
		return userChannelRelationMapper.find(bean);
	}

	
	@Override
    public long findTotal(UserChannelRelation bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = userChannelRelationMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
    public PageData<UserChannelRelation> findByPage(UserChannelRelation bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
    public UserChannelRelation findById(Long id) throws Exception {
        return userChannelRelationMapper.selectByPrimaryKey(id);
    }

	
	@Override
    public UserChannelRelation findObject(UserChannelRelation bean) throws Exception {
		UserChannelRelation result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<UserChannelRelation> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
