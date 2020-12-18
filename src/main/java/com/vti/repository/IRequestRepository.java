package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Request;
import com.vti.entity.Request.Type;

public interface IRequestRepository extends JpaRepository<Request, Short> {
	
	public List<Request> findByType(Type type);

	public boolean existsByType(Type type);

}
