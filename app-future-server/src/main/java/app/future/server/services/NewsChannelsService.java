package app.future.server.services;


import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.NewsChannels;
import app.future.commons.services.INewsChannelsService;
import app.future.server.dao.NewsChannelsMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsChannelsService implements INewsChannelsService {

	@Autowired
	private NewsChannelsMapper newsChannelsMapper;
	
	
	@Override
	public int insert(NewsChannels bean) throws Exception {
		return newsChannelsMapper.insert(bean);
	}
	
	
	@Override
	public int update(NewsChannels bean) throws Exception {
		return newsChannelsMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
	public List<NewsChannels> find(NewsChannels bean) throws Exception {
		return newsChannelsMapper.find(bean);
	}

	
	@Override
	public long findTotal(NewsChannels bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = newsChannelsMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
	public PageData<NewsChannels> findByPage(NewsChannels bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
	public NewsChannels findById(Long id) throws Exception {
        return newsChannelsMapper.selectByPrimaryKey(id);
    }

	
	@Override
	public NewsChannels findObject(NewsChannels bean) throws Exception {
		NewsChannels result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<NewsChannels> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
