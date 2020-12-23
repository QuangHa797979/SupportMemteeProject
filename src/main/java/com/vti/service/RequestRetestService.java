package com.vti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.RequestRetest;
import com.vti.repository.IMenteeRepository;
import com.vti.repository.IRequestRetestRepository;

@Service
public class RequestRetestService implements IRequestRetestService {

	@Autowired
	private IRequestRetestRepository repositoryRequestRetest;

	@Override
	public List<RequestRetest> getAllRequestRetests() {
		// TODO Auto-generated method stub
		return repositoryRequestRetest.findAll();
	}

}
