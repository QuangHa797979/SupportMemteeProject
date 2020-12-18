package com.vti.dto;

import java.util.List;

import com.vti.entity.Mentee;
import com.vti.entity.Request.Type;
import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;

public class CreatingRequestsupportForm {

	private String subjectName;
	private String lessonName;
	private String supervisorName;
	private String starttime;
	private String endtime;
	private String createDate;
	private String status;
	private String type;
	private String note;
	private String title;
	private short menteeID;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//	
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
//	public short getMenteeID() {
//		return menteeID;
//	}
//
//	public void setMenteeID(short menteeID) {
//		this.menteeID = menteeID;
//	}

	public Short getMenteeID() {
		return menteeID;
	}

	public void setMenteeID(Short menteeID) {
		this.menteeID = menteeID;
	}

	public CreatingRequestsupportForm() {

	}

//	public Requestsupport toEntity() {
//		return new Requestsupport(subjectName, lessonName, starttime, endtime, supervisorName, createDate,
//				Status.fromSignal(status), note, title, Type.fromKind(type), menteeID);
//	}

//	, Type.fromKind(type), note, title, menteeID

//	, note, title, mentee, Type.fromKind(type)
}
