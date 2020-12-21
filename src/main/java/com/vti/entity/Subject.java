package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`Subject`", catalog = "demomockproject")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "subject_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short Id;

	@Column(name = "subject_name", length = 50, nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "subject")
	private List<Lesson> lessons;

	public Subject() {
	}

	public Subject(short id, String name, List<Lesson> lessons) {
		Id = id;
		this.name = name;
		this.lessons = lessons;
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

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

}
