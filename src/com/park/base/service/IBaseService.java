package com.park.base.service;

import com.park.support.PageInfo;

public interface IBaseService<T> {

	//���
	void saveEntity(T entity);
	//�޸�
	void updateEntity(T entity);
	//ɾ��
	void deleteByPrimaryKey(Object id);
	//��ѯ
	T selectEntity(Object id);
	//��PageInfo��ҳ��ѯ
	PageInfo<T> selectByPageInfo(PageInfo<T> pageInfo);
}
