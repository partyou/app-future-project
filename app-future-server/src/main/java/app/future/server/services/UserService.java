package app.future.server.services;

import com.alibaba.dubbo.common.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService<T> {

	public static <T> T oneOrDefualt(List<T> list){
		T reult = null;
		if (CollectionUtils.isNotEmpty(list) && list.size()>0) {
			reult = list.get(0);
		}
		return reult;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		UserService.oneOrDefualt(list);
	}
	

}
