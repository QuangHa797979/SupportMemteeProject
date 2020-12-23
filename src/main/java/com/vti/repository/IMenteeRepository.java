package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Mentee;

public interface IMenteeRepository extends JpaRepository<Mentee, Short> {

	public Mentee findByUserName(String userName);

	public boolean existsByUserName(String userName);

	public boolean existsByUserNameAndPassword(String userName, String password);

	public Mentee findByUserNameAndPassword(String userName, String password);
}
