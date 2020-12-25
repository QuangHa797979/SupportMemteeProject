package com.vti.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.vti.dto.UpdatingMenteeForm;
import com.vti.entity.Mentee;

public interface IMenteeService {

	public List<Mentee> getAllMentees();

	public Mentee getMenteeByID(short id);

	public Mentee getMenteeByUserName(String userName);

//	public boolean createMentee(Mentee Mentee);
	
	public void createMentee(Mentee Mentee);

	public void updateMentee(short id, UpdatingMenteeForm form);

	public void deleteMentee(short id);

	public boolean isMenteeExistsByID(short id);

	public boolean isMenteeExistsByUserName(String userName);
	
//	public boolean isMenteeExistsByUserName(Mentee mentee);

	public boolean login(String userName, String password);

	public Mentee getMenteeAndLogin(String userName, String password);

	public Mentee getMenteeByEmail(String email);

	public boolean isMenteeExistsByEmail(String email);

}
