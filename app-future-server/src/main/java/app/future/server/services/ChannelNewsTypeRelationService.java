package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.ChannelNewsTypeRelation;
import app.future.commons.services.IChannelNewsTypeRelationService;
import app.future.server.dao.ChannelNewsTypeRelationMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChannelNewsTypeRelationService implements IChannelNewsTypeRelationService {

	@Autowired
	private ChannelNewsTypeRelationMapper channelNewsTypeRelationMapper;
	
	
	@Override
	public int insert(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.insert(bean);
	}
	
	
	@Override
	public int update(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.updateByPrimaryKeySelective(bean);
	}

	
	@Override
	public List<ChannelNewsTypeRelation> find(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.find(bean);
	}

	
	@Override
	public long findTotal(ChannelNewsTypeRelation bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = channelNewsTypeRelationMapper.findTotal(bean);
		}
		return result;
	}
	
	
	@Override
	public PageData<ChannelNewsTypeRelation> findByPage(ChannelNewsTypeRelation bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    @Override
	public ChannelNewsTypeRelation findById(Long id) throws Exception {
        return channelNewsTypeRelationMapper.selectByPrimaryKey(id);
    }

	
	@Override
	public ChannelNewsTypeRelation findObject(ChannelNewsTypeRelation bean) throws Exception {
		ChannelNewsTypeRelation result = null;
		if (bean!=null) {
			PageModel model = new PageModel(1, 1);
			bean.setModel(model);
		}
		List<ChannelNewsTypeRelation> list = find(bean);
		if (CollectionUtils.isNotEmpty(list)) {
			result = list.get(0);
		}
		return result;
	}
}
