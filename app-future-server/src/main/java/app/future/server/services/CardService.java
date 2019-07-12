package app.future.server.services;

import app.future.commons.base.PageModel;
import app.future.commons.bean.Card;
import app.future.server.dao.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CardService {

	public static List<Card> cardList = new ArrayList<Card>();

	static{
		Card card1 = new Card("1", "张XX", "CD1", "1", "1", new Date(),
				new Date(), new BigDecimal(100), "100");
		Card card2 = new Card("1", "张XX", "CD2", "1", "1", new Date(),
				new Date(), new BigDecimal(500), "500");
		cardList.add(card1);
		cardList.add(card2);
	}
	
	@Autowired
	private CardMapper cardMapper;

	public List<Card> find(Card bean) throws Exception {
		List<Card> list = null;
		if (bean != null) {
			list = cardMapper.find(bean);
		}
		list = cardList;
		return list;
	}

	public Map<String, Object> findByPage(Card bean, PageModel model)
			throws Exception {
		bean.setModel(model);
		Long total = findTotal(bean);
		List<Card> list = find(bean);
		return PageModel.putGridMap(total, list);
	}

	public Card findById(Serializable id) throws Exception {
		//
		Card bean = null;
		if (id != null) {
			for (int i = 0; i < cardList.size(); i++) {
				Card tmp = cardList.get(i);
				if (tmp.getCardNum().equals(id)) {
					bean = tmp;
					break;
				}
			}
//			bean = cardMapper.selectByPrimaryKey((Short) id);
		}
		return bean;
	}

	public int delete(Serializable id) throws Exception {
		int result = 0;
		if (id != null) {
			result = cardMapper.deleteByPrimaryKey((Short) id);
		}
		return result;
	}

	public int insert(Card bean) throws Exception {
		int result = 0;
		if (bean != null) {
			result = cardMapper.insertSelective(bean);
		}
		return result;
	}

	public int update(Card bean) throws Exception {
		int result = 0;
		if (bean != null) {
			for (int i = 0; i < cardList.size(); i++) {
				if (cardList.get(i).getCardNum().equals(bean.getCardNum())) {
					cardList.set(i, bean);
				}
			}
//			result = cardMapper.updateByPrimaryKeySelective(bean);
		}
		return result;
	}

	public Long findTotal(Card bean) throws Exception {
		Long result = null;
		if (bean != null) {
			result = cardMapper.findTotal(bean);
		}
		return result;
	}

}
