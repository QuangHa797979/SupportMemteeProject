package com.vti.dto;

import com.vti.entity.Request.Type;

public class ViewSupportHistory {
	private String startime;
	private String endtime;
	private String supervisorName;
	private Type type;
	private String note;

	public ViewSupportHistory() {
	}

	public ViewSupportHistory(String startime, String endtime, String supervisorName, Type type, String note) {
		this.startime = startime;
		this.endtime = endtime;
		this.supervisorName = supervisorName;
		this.type = type;
		this.note = note;
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

	public String getsupervisorName() {
		return supervisorName;
	}

	public void setUserName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
