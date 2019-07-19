package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.DicType;
import app.future.commons.services.IDicTypeService;
import app.future.server.dao.DicTypeMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DicTypeService implements IDicTypeService {

	@Autowired
	private DicTypeMapper dicTypeMapper;
	
	
	@Override
    public int insert(DicType bean) throws Exception {
		return dicTypeMapper.insert(bean);
	}
	
	
	@Override
    public int update(DicType bean) throws Exception {
		return dicTypeMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
    public List<DicType> find(DicType bean) throws Exception {
		return dicTypeMapper.find(bean);
	}

	
	@Override
    public long findTotal(DicType bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = dicTypeMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
    public PageData<DicType> findByPage(DicType bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
    public DicType findById(Long id) throws Exception {
        return dicTypeMapper.selectByPrimaryKey(id);
    }

	
	@Override
    public DicType findObject(DicType bean) throws Exception {
		DicType result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<DicType> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
