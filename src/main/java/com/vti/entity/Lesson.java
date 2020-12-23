package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Lesson", catalog = "demomockproject")
public class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "lesson_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short Id;

	@Column(name = "lesson_name", length = 50, nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject;

	public Lesson() {
	}

	public Lesson(short id, String name, Subject subject) {
		Id = id;
		this.name = name;
		this.subject = subject;
	}

	public Lesson(short id, Subject subject, String name) {
		Id = id;
		this.name = name;
		this.subject = subject;
	}

	public short getId() {
		return Id;
	}

	public void setId(short id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
