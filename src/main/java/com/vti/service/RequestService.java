package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Request;
import com.vti.entity.Request.Type;
import com.vti.repository.IRequestRepository;

@Service
public class RequestService implements IRequestService {

	@Autowired
	private IRequestRepository repository;

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Request getRequestByID(short id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Request> getRequestByType(Type type) {
		// TODO Auto-generated method stub
		return repository.findByType(type);
	}

	@Override
	public void createRequest(Request Request) {
		// TODO Auto-generated method stub
		repository.save(Request);
	}

	@Override
	public void updateRequest(Request Request) {
		// TODO Auto-generated method stub
		repository.save(Request);
	}

	@Override
	public void deleteRequestById(short id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public boolean isRequestExistsByID(short id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	@Override
	public boolean isRequestExistsByType(Type type) {
		// TODO Auto-generated method stub
		return repository.existsByType(type);
	}

	public List<Request> seachByType(Type type) {

		return repository.findByType(type);
	}
}
