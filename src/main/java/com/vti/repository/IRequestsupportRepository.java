package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;

public interface IRequestsupportRepository extends JpaRepository<Requestsupport, Short> {

	public Requestsupport findBySubjectName(String subjectName);

	public boolean existsBySubjectName(String subjectName);

//	public void save(Request request, Requestsupport requestsupport);
	
	List<Requestsupport> findAllByStatus(Status status);

}
