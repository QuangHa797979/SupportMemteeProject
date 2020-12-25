package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;
import com.vti.repository.IRequestsupportRepository;
@Service
public class SupportHistoryService implements ISupportHistoryService {
	@Autowired
	private IRequestsupportRepository repository;

	@Override
	public List<Requestsupport> getAllSupportHistory() {
		return repository.findAllByStatus(Status.APPROVE);
	}

}
