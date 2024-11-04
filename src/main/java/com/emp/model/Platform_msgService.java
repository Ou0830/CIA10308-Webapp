package com.emp.model;

import java.sql.Date;
import java.util.List;

public class Platform_msgService {

	private Platform_msgDAO_interface dao;

	public Platform_msgService() {
		dao = new Platform_msgJDBCDAO();
	}

	public Platform_msgVO addEmp(Integer id, Integer member_id, Integer business_id, 
			String message, Date msg_time,Integer status) {

		Platform_msgVO msgVO = new Platform_msgVO();

		msgVO.setId(id);
		msgVO.setMember_id(member_id);
		msgVO.setBusiness_id(business_id);
		msgVO.setMessage(message);
		msgVO.setMsg_time(msg_time);
		msgVO.setStatus(status);
		dao.insert(msgVO);

		return msgVO;
	}

	public Platform_msgVO updateEmp(Integer id, Integer member_id, Integer business_id, 
			String message, Date msg_time,Integer status) {


		Platform_msgVO msgVO = new Platform_msgVO();

		
		msgVO.setId(id);
		msgVO.setMember_id(member_id);
		msgVO.setBusiness_id(business_id);
		msgVO.setMessage(message);
		msgVO.setMsg_time(msg_time);
		msgVO.setStatus(status);
		dao.update(msgVO);

		return msgVO;
	}

	public void deleteEmp(Integer id) {
		dao.delete(id);
	}

	public Platform_msgVO getOneEmp(Integer id) {
		return dao.findByPrimaryKey(id);
	}

	public List<Platform_msgVO> getAll() {
		return dao.getAll();
	}
}
