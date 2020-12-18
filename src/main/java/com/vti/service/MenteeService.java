package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vti.dto.UpdatingMenteeForm;
import com.vti.entity.Mentee;
import com.vti.repository.IMenteeRepository;

@Service
public class MenteeService implements IMenteeService {

	@Autowired
	private IMenteeRepository repository;

	@Override
	public List<Mentee> getAllMentees() {

		return repository.findAll();
	}

	@Override
	public Mentee getMenteeByID(short id) {

		return repository.findById(id).get();
	}

	@Override
	public Mentee getMenteeByUserName(String userName) {
		return repository.findByUserName(userName);
	}

	@Override
	public void createMentee(Mentee Mentee) {
		repository.save(Mentee);
	}

	@Override
	public void updateMentee(short id, UpdatingMenteeForm form) {
		Mentee mentee = getMenteeByID(id);

		if (form.getEmail() != null & !form.getEmail().equals("")) {
			mentee.setEmail(form.getEmail());
		}


		if (form.getPassword() != null & !form.getPassword().equals("")) {
			mentee.setPassword(form.getPassword());
		}

		
		if (form.getPhoneNumber() != null & !form.getPhoneNumber().equals("")) {
			mentee.setPhoneNumber(form.getPhoneNumber());
		}

		if (form.getUserName() != null & !form.getUserName().equals("")) {
			mentee.setUserName(form.getUserName());
		}

		repository.save(mentee);
	}

	@Override
	public void deleteMentee(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isMenteeExistsByID(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isMenteeExistsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}

	public boolean login(String userName, String password) {
		return repository.existsByUserNameAndPassword(userName, password);
	}

	public Mentee getMenteeAndLogin(String userName, String password) {
		return repository.findByUserNameAndPassword(userName, password);
	}

}
