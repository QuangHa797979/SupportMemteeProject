package com.vti.dto;

import java.util.Date;

import com.vti.entity.RequestRetest;

public class RequestRetestDTO {

	private short id;
	private Date time;
	private short point;
	private String status;
	public RequestRetestDTO() {
		super();
	}

	
	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public short getPoint() {
		return point;
	}


	public void setPoint(short point) {
		this.point = point;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public RequestRetestDTO(short id, Date time, short point, String status) {
		super();
		this.id = id;
		this.time = time;
		this.point = point;
		this.status = status;
	}
	@Override
	public String toString() {
		return "RequestRetestDTO [id=" + id + ", time=" + time + ", point=" + point + ", status=" + status + "]";
	}
	public RequestRetest toEntity() {
		return new RequestRetest();
	}
	
	
}
