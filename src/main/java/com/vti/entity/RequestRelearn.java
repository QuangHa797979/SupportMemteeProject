package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Request_relearn", catalog = "demomockproject")
@PrimaryKeyJoinColumn(name = "request_id")
public class RequestRelearn extends Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id")
	private Lesson lesson;

	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date endDate;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
//	@Convert(converter = StatusConverter.class)
	private Status statusRelearn;

	public enum Status {
		SEND, PENDING, APPROVE, REFUSE;
	}

	public RequestRelearn() {
	}

	public RequestRelearn(Lesson lesson, Date startDate, Date endDate, Status statusRelearn, String note, String title,
			Mentee mentee) {
		this.lesson = lesson;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusRelearn = statusRelearn;
		setNote(note);
		setTitle(title);
		setMentee(mentee);
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Status getStatusRelearn() {
		return statusRelearn;
	}

	public void setStatusRelearn(Status statusRelearn) {
		this.statusRelearn = statusRelearn;
	}
}
