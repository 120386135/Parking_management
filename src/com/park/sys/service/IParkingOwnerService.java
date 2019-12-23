package com.park.sys.service;


import com.park.base.service.IBaseService;
import com.park.bean.ParkingOwner;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IParkingOwnerService extends IBaseService<ParkingOwner>{

	EasyUIDataGridResult getOwnerList(int page, int rows);

	TaotaoResult save(ParkingOwner owner);

	TaotaoResult update(ParkingOwner owner);

	TaotaoResult delete(String ownId);
	//ģ����ѯ
	EasyUIDataGridResult getOwnerList(String carId, int page, int rows);
	//���ݳ��ƺŲ�ѯ
	EasyUIDataGridResult getOwnerWxList(String carId);

}
