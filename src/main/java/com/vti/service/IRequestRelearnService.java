package com.vti.service;

import java.util.List;

import com.vti.entity.RequestRelearn;

public interface IRequestRelearnService {
	public List<RequestRelearn> getAllRequestRelearns();

	public RequestRelearn getRequestRelearnByID(short id);

//	public RequestRelearn getRequestRelearnByName(String name);

//	public void createRequestRelearn (creatRequestRelearnForm form);

//	public void updateRequestRelearn (short id, UpdateRequestRelearnForm form);

	public void deleteRequestRelearn(short id);

//	public boolean isRequestRelearnExistsByID(short id);
//
//	public boolean isRequestRelearnExistsByName(String name);
}
