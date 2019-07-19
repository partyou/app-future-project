package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.DicItem;
import app.future.commons.services.IDicItemService;
import app.future.server.dao.DicItemMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DicItemService implements IDicItemService {

	@Autowired
	private DicItemMapper dicItemMapper;
	
	
	@Override
    public int insert(DicItem bean) throws Exception {
		return dicItemMapper.insert(bean);
	}
	
	
	@Override
    public int update(DicItem bean) throws Exception {
		return dicItemMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
    public List<DicItem> find(DicItem bean) throws Exception {
		return dicItemMapper.find(bean);
	}

	
	@Override
    public long findTotal(DicItem bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = dicItemMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
    public PageData<DicItem> findByPage(DicItem bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
    public DicItem findById(Long id) throws Exception {
        return dicItemMapper.selectByPrimaryKey(id);
    }

	
	@Override
    public DicItem findObject(DicItem bean) throws Exception {
		DicItem result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<DicItem> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
