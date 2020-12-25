package com.vti.dto;

import java.util.Date;

import com.vti.entity.RequestRelearn;

public class ViewRequestRelearnDTO {
	private short id;
	private String menteeName;
	private String subjectName;
	private String lessonName;
	private Date startDate;
	private Date endDate;
	private String note;
	private String titel;
	private String status;

	public ViewRequestRelearnDTO() {
	}

	public ViewRequestRelearnDTO(short id, String menteeName, String subjectName, String lessonName, Date startDate, Date endDate,
			String note, String titel, String status) {
		this.id = id;
		this.menteeName = menteeName;
		this.subjectName = subjectName;
		this.lessonName = lessonName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.note = note;
		this.titel = titel;
		this.status = status;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getMenteeName() {
		return menteeName;
	}

	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}


	@Override
	public String toString() {
		return "ViewRequestRelearnDTO [id=" + id + ", menteeName=" + menteeName + ", subjectName=" + subjectName
				+ ", lessonName=" + lessonName + ", startDate=" + startDate + ", endDate=" + endDate + ", note=" + note
				+ ", titel=" + titel + ", status=" + status + "]";
	}

	public RequestRelearn toEntity() {
		return new RequestRelearn();

	}
}
