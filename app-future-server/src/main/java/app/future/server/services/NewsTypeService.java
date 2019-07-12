package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsType;
import app.future.server.dao.NewsTypeMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsTypeService{

	@Autowired
	private NewsTypeMapper newsTypeMapper;
	
	
	public int insert(NewsType bean) throws Exception {
		return newsTypeMapper.insert(bean);
	}
	
	
	public int update(NewsType bean) throws Exception {
		return newsTypeMapper.updateByPrimaryKeySelective(bean);
	}

	
	public List<NewsType> find(NewsType bean) throws Exception {
		return newsTypeMapper.find(bean);
	}

	
	public long findTotal(NewsType bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = newsTypeMapper.findTotal(bean);
		}
		return result;
	}
	
	
	public PageData<NewsType> findByPage(NewsType bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    public NewsType findById(Long id) throws Exception {
        return newsTypeMapper.selectByPrimaryKey(id);
    }

	
	public NewsType findObject(NewsType bean) throws Exception {
		NewsType result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<NewsType> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
