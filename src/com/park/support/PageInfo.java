package com.park.support;

import java.util.List;

/**
 * 
 * pageInfo<T>������

	��ҳ����Ҫ��Щ���ݣ�
	
	1 ������ int totalCount
	2 ÿһҳ������ int pageSize 
	3 ��ҳ�� int totalPage
	4 ��ʼ���� int start
	5 ��ǰҳ  int currentPage
	
	��ѯ����������
	Private List<T> lists
	
	������ѯ��ʱ��������Ҫ�������
	���Ա��浽��Ķ���������С�
	Private T entity;

 * @author Lenovo
 *
 */
public class PageInfo<T> {
	//������
	private int totalCount;
	// ÿһҳ������ ��ʼֵ��5
	private int pageSize = 5; 
	// ��ҳ��
	private int totalPage;
	// ��ʼ������
	private int start;
	
	//��ǰ��ҳ��
	private int currentPage = 1;
	
	//�Ѳ�ѯ�����ݷŵ�pageInfo�����ڴ���
	private List<T> lists;
	
	//�����ѯ������
	private T entity;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		start = (currentPage-1)*pageSize;
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	
}
