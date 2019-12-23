package com.park.mapper;

import java.util.List;

import com.park.support.PageInfo;

public interface IBaseMapper<T> {

	 int deleteByPrimaryKey(Object chcId);
	 
	 int insertSelective(T record);
	 
	 T selectByPrimaryKey(Object chcId);
	 
	 int updateByPrimaryKeySelective(T record);
	 
	  //��ҳ��ѯ
	    List<T> selectByPageInfo(PageInfo<T> pageInfo);
	    
	    //��ѯ������
	    int selectCountByPageInfo(PageInfo<T> pageInfo);
}
