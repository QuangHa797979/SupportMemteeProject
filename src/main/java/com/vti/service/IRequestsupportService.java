package com.vti.service;

import java.util.List;

import com.vti.dto.CreatingRequestsupportForm;
import com.vti.dto.UpdatingRequestsupportForm;
import com.vti.entity.Request;
import com.vti.entity.Requestsupport;

public interface IRequestsupportService {

	public List<Requestsupport> getAllRequestsupports();

	public Requestsupport getRequestsupportByID(short id);

	public Requestsupport getRequestsupportBySubjectName(String subjectName);

	public void createRequestsupport(CreatingRequestsupportForm form);

	public void updateRequestsupport(short id, UpdatingRequestsupportForm form);

	public void deleteRequestsupport(short id);

	public boolean isRequestsupportExistsByID(short id);

	public boolean isRequestsupportExistsBySubjectName(String subjectName);

}

