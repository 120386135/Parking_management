package com.park.support;

import java.io.Serializable;
import java.util.List;

/**
 * ���Խ��@ResponseBody
 * ����{total:��2��,rows:[{��id��:��1��,��name��:��������},{��id��:��2��,��name��:�����ġ�}]}
 * �������͵�����
 * @author Lenovo
 *
 */
public class EasyUIDataGridResult implements Serializable{

	 private Integer total;
     
	 private List<?> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	 
	 
 
}

