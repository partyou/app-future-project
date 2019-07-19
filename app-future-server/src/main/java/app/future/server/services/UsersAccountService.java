package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UsersAccount;
import app.future.commons.services.IUsersAccountService;
import app.future.server.dao.UsersAccountMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersAccountService implements IUsersAccountService {

	@Autowired
	private UsersAccountMapper usersAccountMapper;
	
	
	@Override
	public int insert(UsersAccount bean) throws Exception {
		return usersAccountMapper.insert(bean);
	}
	
	
	@Override
	public int update(UsersAccount bean) throws Exception {
		return usersAccountMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
	public List<UsersAccount> find(UsersAccount bean) throws Exception {
		return usersAccountMapper.find(bean);
	}

	
	@Override
	public long findTotal(UsersAccount bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = usersAccountMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
	public PageData<UsersAccount> findByPage(UsersAccount bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
	public UsersAccount findById(Long id) throws Exception {
        return usersAccountMapper.selectByPrimaryKey(id);
    }

	
	@Override
	public UsersAccount findObject(UsersAccount bean) throws Exception {
		UsersAccount result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<UsersAccount> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
