package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Request;
import com.vti.entity.Requestsupport;

public interface IRequestsupportRepository extends JpaRepository<Requestsupport, Short> {

	public Requestsupport findBySubjectName(String subjectName);

	public boolean existsBySubjectName(String subjectName);

//	public void save(Request request, Requestsupport requestsupport);

}
