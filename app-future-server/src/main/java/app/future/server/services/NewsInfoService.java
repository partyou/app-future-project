package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsInfo;
import app.future.commons.services.INewsInfoService;
import app.future.server.dao.NewsInfoMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsInfoService implements INewsInfoService {

	@Autowired
	private NewsInfoMapper newsInfoMapper;
	
	
	@Override
	public int insert(NewsInfo bean) throws Exception {
		return newsInfoMapper.insert(bean);
	}
	
	
	@Override
	public int update(NewsInfo bean) throws Exception {
		return newsInfoMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
	public List<NewsInfo> find(NewsInfo bean) throws Exception {
		return newsInfoMapper.find(bean);
	}

	
	@Override
	public long findTotal(NewsInfo bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = newsInfoMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
	public PageData<NewsInfo> findByPage(NewsInfo bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
	public NewsInfo findById(Long id) throws Exception {
        return newsInfoMapper.selectByPrimaryKey(id);
    }

	
	@Override
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
