package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.DicType;
import app.future.server.dao.DicTypeMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DicTypeService{

	@Autowired
	private DicTypeMapper dicTypeMapper;
	
	
	public int insert(DicType bean) throws Exception {
		return dicTypeMapper.insert(bean);
	}
	
	
	public int update(DicType bean) throws Exception {
		return dicTypeMapper.updateByPrimaryKeySelective(bean);
	}

	
	public List<DicType> find(DicType bean) throws Exception {
		return dicTypeMapper.find(bean);
	}

	
	public long findTotal(DicType bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = dicTypeMapper.findTotal(bean);
		}
		return result;
	}
	
	
	public PageData<DicType> findByPage(DicType bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    public DicType findById(Long id) throws Exception {
        return dicTypeMapper.selectByPrimaryKey(id);
    }

	
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
