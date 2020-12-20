package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vti.entity.converter.TypeConverter;

@Entity
@Table(name = "`Request`", catalog = "demomockproject")
@Inheritance(strategy = InheritanceType.JOINED)
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "request_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short requestID;

	@Column(name = "note")
	private String note;

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@ManyToOne()
	@JoinColumn(name = "mentee_id", nullable = false)
	private Mentee mentee;

	@Convert(converter = TypeConverter.class)
	private Type type;

	public Request() {

	}

	public short getRequestID() {
		return requestID;
	}

	public void setRequestID(short requestID) {
		this.requestID = requestID;
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

	public Mentee getMentee() {
		return mentee;
	}

	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
// hàm khởi tạo, khai báo type
	public enum Type {
		RETEST("retest"), RESERVE("reserve"), SUPPORT("support");

		private String kind;

		private Type(String kind) {
			this.kind = kind;
		}

		public String getKind() {
			return kind;
		}

		public static Type fromKind(String kind) {
			switch (kind) {
			case "retest":
				return Type.RETEST;

			case "reserve":
				return Type.RESERVE;

			case "support":
				return Type.SUPPORT;
		default:
            throw new IllegalArgumentException("Kind [" + kind
                    + "] not supported.");
		}
	}
}

	public Request(String note, String title, Mentee mentee, Type type) {
		super();
		this.note = note;
		this.title = title;
		this.mentee = mentee;
		this.type = type;
	}
}

