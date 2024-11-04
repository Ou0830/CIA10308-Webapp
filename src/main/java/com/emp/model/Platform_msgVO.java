package com.emp.model;
import java.sql.Date;

public class Platform_msgVO implements java.io.Serializable{
	private Integer id;
	private Integer member_id;
	private Integer business_id;
	private String message;
	private Date msg_time;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Date msg_time) {
		this.msg_time = msg_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}