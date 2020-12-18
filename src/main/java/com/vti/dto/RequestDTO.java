package com.vti.dto;

import java.util.Arrays;
import java.util.Date;

import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;
import com.vti.entity.Mentee;
import com.vti.entity.Request;
import com.vti.entity.Request.Type;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class RequestDTO {

	
	private String note;
	private String title;
	private Mentee mentee;
	private String type;
	
	
//	public enum Type {
//		retest, reserve, support;
//		private String value;
//
//		private Type(String value) {
//			this.value = value;
//		}

//		public static Type fromValue(String value) {
//			for (Type category : values()) {
//				if (category.value.equalsIgnoreCase(value)) {
//					return category;
//				}
//			}
//			throw new IllegalArgumentException(
//					"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
//		}

//	}
	
//
//	public Type getType() {
//		return type;
//	}
//
//	public void setType(Type type) {
//		this.type = type;
//	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RequestDTO() {
		super();
	}
	
	public Request createRequest() {
		return new Request(note, title, mentee, Type.fromKind(type));
	}
	
//	public Request createRequest(Mentee mentee, Requestsupport requestsupport) {
//		return new Request();
//	}	
}

//@Component
//public class GenderEnumConverter implements Converter<String, GenderEnum> {
//    @Override
//    public GenderEnum convert(String value) {
//        return GenderEnum.of(Integer.valueOf(value));
//    }
//}

//Mentee mentee, Requestsupport requestsupport
	


