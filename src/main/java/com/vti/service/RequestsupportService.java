package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.CreatingRequestsupportForm;
import com.vti.dto.UpdatingMenteeForm;
import com.vti.dto.UpdatingRequestsupportForm;
import com.vti.entity.Mentee;
import com.vti.entity.Request;
import com.vti.entity.Request.Type;
import com.vti.entity.Requestsupport;
import com.vti.entity.Requestsupport.Status;
import com.vti.repository.IMenteeRepository;
import com.vti.repository.IRequestsupportRepository;

@Service
public class RequestsupportService implements IRequestsupportService {

	@Autowired
	private IRequestsupportRepository repository;

	@Autowired
	private IMenteeRepository menteeRepository;

	@Override
	public List<Requestsupport> getAllRequestsupports() {
		return repository.findAll();
	}

	@Override
	public Requestsupport getRequestsupportByID(short id) {
		return repository.findById(id).get();
	}

	@Override
	public Requestsupport getRequestsupportBySubjectName(String subjectName) {
		return repository.findBySubjectName(subjectName);
	}

	@Override
	public void createRequestsupport(CreatingRequestsupportForm form) {
		Mentee mentee = menteeRepository.findById(form.getMenteeID()).get();
		
		Requestsupport entity = new Requestsupport(
				form.getSubjectName(),
				form.getLessonName(),
				form.getStarttime(),
				form.getEndtime(),
				form.getSupervisorName(),
				form.getCreateDate(),
				Status.fromSignal(form.getStatus()),
				form.getNote(),
				form.getTitle(),
				Type.fromKind(form.getType()),
				mentee);
				
		repository.save(entity);
	}
		
//		String subjectName, String lessonName, String startime, String endtime, String supervisorName,
//		String createDate, Status status, String note, String title, Type type, Mentee mentee
//		repository.save(entity);
//	}

//	@Override
//	public void updateRequestsupport(Requestsupport Requestsupport) {
//		repository.save(Requestsupport);
//	}

	@Override
	public void updateRequestsupport(short id, UpdatingRequestsupportForm form) {
		Requestsupport requestsupport = getRequestsupportByID(id);

		if (form.getSubjectName() != null & !form.getSubjectName().equals("")) {
			requestsupport.setSubjectName(form.getSubjectName());
		}

		if (form.getLessonName() != null & !form.getLessonName().equals("")) {
			requestsupport.setLessonName(form.getLessonName());
		}

		if (form.getSupervisorName() != null & !form.getSupervisorName().equals("")) {
			requestsupport.setSupervisorName(form.getSupervisorName());
		}

		if (form.getStarttime() != null & !form.getStarttime().equals("")) {
			requestsupport.setStartime(form.getStarttime());
		}

		if (form.getEndtime() != null & !form.getEndtime().equals("")) {
			requestsupport.setEndtime(form.getEndtime());
		}

		if (form.getCreateDate() != null & !form.getCreateDate().equals("")) {
			requestsupport.setCreateDate(form.getCreateDate());
		}

		if (form.getStatus() != null & !form.getStatus().equals("")) {
			requestsupport.setStatus(Status.fromSignal(form.getStatus()));
		}

		if (form.getNote() != null & !form.getNote().equals("")) {
			requestsupport.setNote(form.getNote());
		}

		if (form.getTitle() != null & !form.getTitle().equals("")) {
			requestsupport.setTitle(form.getTitle());
		}

		if (form.getType() != null & !form.getType().equals("")) {
			requestsupport.setType(Type.fromKind(form.getType()));
		}
//		
//		short menteeId = 1;

		if (form.getType() != null & !form.getType().equals("")) {
			requestsupport.setType(Type.fromKind(form.getType()));
		}

		if (form.getMenteeID() != null) {
			Mentee mentee = menteeRepository.findById(form.getMenteeID()).get();
			requestsupport.setMentee(mentee);
		}

		repository.save(requestsupport);
	}

	@Override
	public void deleteRequestsupport(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isRequestsupportExistsByID(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isRequestsupportExistsBySubjectName(String subjectName) {
		return repository.existsBySubjectName(subjectName);
	}

}
