package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.entity.converter.StatusConvertRequestRetest;
import com.vti.entity.converter.StatusRequestRetest;

@Entity
@Table(name = "Request_retest", catalog = "demomockproject")
@PrimaryKeyJoinColumn(name = "request_id")
public class RequestRetest extends Request implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "subject_id")
	private short subject_id;

//	@Column(name = "type_retest", nullable = false)
//	@Convert(converter = TypeConvertRequestRetest.class)
//	private TypeRequestRetest type;

	@Column(name = "time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date time;

	@Column(name = "point")
	private short point;

	@Column(name = "status")
	@Convert(converter = StatusConvertRequestRetest.class)
	private StatusRequestRetest status;

	public RequestRetest() {
	
	}



//	private void setType(TypeRequestRetest type) {
//		this.type = type;
//	}




	@Override
	public String toString() {
		return "RequestRetest [subject_id=" + subject_id + ", time=" + time + ", point=" + point + ", status=" + status
				+ "]";
	}






	public short getSubject_id() {
		return subject_id;
	}



	public void setSubject_id(short subject_id) {
		this.subject_id = subject_id;
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



	public StatusRequestRetest getStatus() {
		return status;
	}



	public void setStatus(StatusRequestRetest status) {
		this.status = status;
	}



	public RequestRetest(short subject_id, Date time, short point, StatusRequestRetest status) {
		super();
		this.subject_id = subject_id;
		this.time = time;
		this.point = point;
		this.status = status;
	}



}
