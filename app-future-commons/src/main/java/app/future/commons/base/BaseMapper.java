package app.future.commons.base;

import java.util.List;


public interface BaseMapper<T> {
	
    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T bean);

    T selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(T bean);
    
    int updateByPrimaryKey(T bean);

	List<T> find(T bean);

	Long findTotal(T bean);
}