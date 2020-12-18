package com.vti.service;

import java.util.List;

import com.vti.entity.Request;
import com.vti.entity.Request.Type;

public interface IRequestService {

	public List<Request> getAllRequests();

	public Request getRequestByID(short id);

	public List<Request> getRequestByType(Type type);

	public void createRequest(Request Request);

	public void updateRequest(Request Request);

	public void deleteRequestById(short id);

	public boolean isRequestExistsByID(short id);

	public boolean isRequestExistsByType(Type type);

	public List<Request> seachByType(Type type);

}
