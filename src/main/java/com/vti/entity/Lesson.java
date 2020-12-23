package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lesson", catalog = "demomockproject")
public class Lesson implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short lesson_id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String lesson_name;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	public short getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(short lesson_id) {
		this.lesson_id = lesson_id;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Lesson(short lesson_id, String lesson_name, Subject subject) {
		super();
		this.lesson_id = lesson_id;
		this.lesson_name = lesson_name;
		this.subject = subject;
	}

	public Lesson() {
		super();
	}

	@Override
	public String toString() {
		return "Lesson [lesson_id=" + lesson_id + ", lesson_name=" + lesson_name + ", subject=" + subject + "]";
	}
	
	
	

}
