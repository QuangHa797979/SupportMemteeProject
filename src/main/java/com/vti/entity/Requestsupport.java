package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.vti.entity.converter.StatusConverter;
import com.vti.entity.converter.TypeConverter;
import com.vti.entity.Request;
import com.vti.entity.Request.Type;
import com.vti.entity.Mentee;

@Entity
@Table(name = "Requestsupport", catalog = "demomockproject")
@PrimaryKeyJoinColumn(name = "request_support_id")
public class Requestsupport extends Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "subject_name", length = 50, nullable = false)
	private String subjectName;

	@Column(name = "lesson_name	", length = 50, nullable = false)
	private String lessonName;

	@Column(name = "start_time", nullable = false)
	private String startime;

	@Column(name = " end_time", nullable = false)
	private String endtime;

	@Column(name = "supervisor_name", length = 50, nullable = false)
	private String supervisorName;

	@Column(name = "create_date", nullable = false)
	private String createDate;

	@Convert(converter = StatusConverter.class)
	private Status status;

//	
//	private Mentee mentee;
//	
//	@Convert(converter = TypeConverter.class)
//	private Type type;

	public Requestsupport() {

	}

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

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

//
//	public Mentee getMentee() {
//		return mentee;
//	}
//
//	public void setMentee(Mentee mentee) {
//		this.mentee = mentee;
//	}
//
//	public Type getType() {
//		return type;
//	}
//
//	public void setType(Type type) {
//		this.type = type;
//	}

	public enum Status {
		SEND("send"), PENDING("pending"), APPROVE("approve"), REFUSE("refuse");

		private String signal;

		private Status(String signal) {
			this.signal = signal;
		}

		public String getSignal() {
			return signal;
		}

		public static Status fromSignal(String signal) {
			switch (signal) {
			case "send":
				return Status.SEND;

			case "pending":
				return Status.PENDING;

			case "approve":
				return Status.APPROVE;

			case "refuse":
				return Status.REFUSE;
			default:
				throw new IllegalArgumentException("Signal [" + signal + "] not supported.");
			}
		}
	}

	public Requestsupport(String subjectName, String lessonName, String startime, String endtime, String supervisorName,
			String createDate, Status status, String note, String title, Type type, Mentee mentee) {
		super();
		this.subjectName = subjectName;
		this.lessonName = lessonName;
		this.startime = startime;
		this.endtime = endtime;
		this.supervisorName = supervisorName;
		this.createDate = createDate;
		this.status = status;
		setNote(note);
		setTitle(title);
		setType(type);
		setMentee(mentee);
	}

//
//	public Requestsupport(String subjectName, String lessonName, String startime, String endtime, String supervisorName,
//			String createDate, Status status) {
//		this.subjectName = subjectName;
//		this.lessonName = lessonName;
//		this.startime = startime;
//		this.endtime = endtime;
//		this.supervisorName = supervisorName;
//		this.createDate = createDate;
//		this.status = status;
//	}

//	public Requestsupport(String subjectName, String lessonName, String startime, String endtime, String supervisorName,
//			String createDate, Status status, String note, String title, Mentee mentee, Type type) {
//		super();
//		this.subjectName = subjectName;
//		this.lessonName = lessonName;
//		this.startime = startime;
//		this.endtime = endtime;
//		this.supervisorName = supervisorName;
//		this.createDate = createDate;
//		this.status = status;
//		this.note = note;
//		this.title = title;
//		this.mentee = mentee;
//		this.type = type;
//	}

}
