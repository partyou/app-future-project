package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsInfo;
import app.future.server.dao.NewsInfoMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class NewsInfoService{

	@Autowired
	private NewsInfoMapper newsInfoMapper;
	
	
	public int insert(NewsInfo bean) throws Exception {
		return newsInfoMapper.insert(bean);
	}
	
	
	public int update(NewsInfo bean) throws Exception {
		return newsInfoMapper.updateByPrimaryKeySelective(bean);
	}

	
	public List<NewsInfo> find(NewsInfo bean) throws Exception {
		return newsInfoMapper.find(bean);
	}

	
	public long findTotal(NewsInfo bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = newsInfoMapper.findTotal(bean);
		}
		return result;
	}
	
	
	public PageData<NewsInfo> findByPage(NewsInfo bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    public NewsInfo findById(Long id) throws Exception {
        return newsInfoMapper.selectByPrimaryKey(id);
    }

	
	public NewsInfo findObject(NewsInfo bean) throws Exception {
		NewsInfo result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<NewsInfo> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
