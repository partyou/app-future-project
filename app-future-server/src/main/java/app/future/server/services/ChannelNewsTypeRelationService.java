package app.future.server.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.ChannelNewsTypeRelation;
import app.future.server.dao.ChannelNewsTypeRelationMapper;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChannelNewsTypeRelationService{

	@Autowired
	private ChannelNewsTypeRelationMapper channelNewsTypeRelationMapper;
	
	
	public int insert(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.insert(bean);
	}
	
	
	public int update(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.updateByPrimaryKeySelective(bean);
	}

	
	public List<ChannelNewsTypeRelation> find(ChannelNewsTypeRelation bean) throws Exception {
		return channelNewsTypeRelationMapper.find(bean);
	}

	
	public long findTotal(ChannelNewsTypeRelation bean) throws Exception {
		Long result = 0L;
		if (bean != null) {
			result = channelNewsTypeRelationMapper.findTotal(bean);
		}
		return result;
	}
	
	
	public PageData<ChannelNewsTypeRelation> findByPage(ChannelNewsTypeRelation bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		return PageData.setData(findTotal(bean), find(bean));
	}
	
	
    public ChannelNewsTypeRelation findById(Long id) throws Exception {
        return channelNewsTypeRelationMapper.selectByPrimaryKey(id);
    }

	
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
