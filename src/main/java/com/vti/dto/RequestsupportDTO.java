package com.vti.dto;

import java.util.List;

import com.vti.entity.Mentee;
import com.vti.entity.Request.Type;
import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;


public class RequestsupportDTO {

	private String subjectName;
	private String lessonName;
	private String supervisorName;
	private String starttime;
	private String endtime;
	private String createDate;
	private String status;
//	private List<String> callrequest;
//	private String note;
//	private String title;
//	private Mentee mentee;
//	private String type;

	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
//	public List<String> getRequest() {
//		return callrequest;
//	}
//
//	public void setRequest(List<String> request) {
//		this.callrequest = callrequest;
//	}
	
	
//	public String getNote() {
//		return note;
//	}
//
//	public void setNote(String note) {
//		this.note = note;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//
//	public Mentee getMentee() {
//		return mentee;
//	}
//
//	public void setMentee(Mentee mentee) {
//		this.mentee = mentee;
//	}
//	
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
	
	public RequestsupportDTO(String subjectName, String lessonName, String supervisorName, String starttime,
			String endtime, String createDate, String status) {
		super();
		this.subjectName = subjectName;
		this.lessonName = lessonName;
		this.supervisorName = supervisorName;
		this.starttime = starttime;
		this.endtime = endtime;
		this.createDate = createDate;
		this.status = status;
//		this.callrequest = request;
	}



	

//	public Requestsupport createRequestsupport() {
//		return new Requestsupport(subjectName, lessonName, starttime, endtime, supervisorName, createDate,
//				Status.fromSignal(status));
//	}





//	, note, title, mentee, Type.fromKind(type)
}
