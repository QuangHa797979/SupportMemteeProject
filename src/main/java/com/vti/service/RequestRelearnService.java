package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.RequestRelearn;
import com.vti.repository.IRequestRelearnRepository;

@Service
public class RequestRelearnService implements IRequestRelearnService{
@Autowired
private IRequestRelearnRepository relearnRepository;
	@Override
	public List<RequestRelearn> getAllRequestRelearns() {
		return relearnRepository.findAll();
	}

	@Override
	public RequestRelearn getRequestRelearnByID(short id) {
		return relearnRepository.findById(id).get();
	}

//	@Override
//	public RequestRelearn getRequestRelearnByName(String name) {
//		return null;
//	}

	@Override
	public void deleteRequestRelearn(short id) {
		relearnRepository.deleteById(id);	
	}

}
