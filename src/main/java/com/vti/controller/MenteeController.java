package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vti.dto.CreatingMenteeForm;
import com.vti.dto.MenteeDTO;
import com.vti.dto.UpdatingMenteeForm;
import com.vti.entity.Mentee;
import com.vti.entity.Request;
import com.vti.entity.Request.Type;
import com.vti.service.IMenteeService;
import com.vti.service.MenteeService;
import com.vti.utils.ScannerUtilMentee;

@RestController
@RequestMapping(value = "api/v1/mentees")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MenteeController {

	@Autowired
	private IMenteeService menteeService;

	@GetMapping()
	public ResponseEntity<?> getAllMentees() {
		List<Mentee> mentees = menteeService.getAllMentees();

		// convert entity to dto
		List<MenteeDTO> dtos = new ArrayList<>();
		for (Mentee mentee : mentees) {

			MenteeDTO dto;
			List<String> requestTitles = new ArrayList<>();

			for (Request request : mentee.getRequests()) {
				requestTitles.add(request.getTitle());
				requestTitles.add(request.getNote());
				requestTitles.add(request.getType().getKind());
			}
//			List<Integer> requestTitles2 = new ArrayList<>();
//				
//				
//			requestTitles.add(request.getMentee().getMenteeID());
//		}
//				requestTitles.add(request.getRequestID(), request.getTitle());
//			}

			// convert 1 entity => 1 dto
			dto = new MenteeDTO(mentee.getUserName(), mentee.getPhoneNumber(), mentee.getEmail(), requestTitles);

			dtos.add(dto);
		}

		return new ResponseEntity<List<MenteeDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getMenteeByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Mentee>(menteeService.getMenteeByID(id), HttpStatus.OK);
	}
	
//	@PostMapping()
//	public ResponseEntity<?> createMentee(@RequestBody CreatingMenteeForm form) {
//		Mentee entity = form.toEntity();
//		menteeService.createMentee(entity);
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}

	@PostMapping()
	public ResponseEntity<Boolean> createMentee(@RequestBody CreatingMenteeForm form) {
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("UserName: ");
//		String username = ScannerUtilMentee.readUsername(scanner, "error");
//		System.out.println("Password: ");
//		String password = ScannerUtilMentee.readPassword(scanner, "error");
//		boolean bl = new MenteeService().login(username, password);
//		if(bl){
//			System.out.println("Login succesed!");
//		} else {
//			System.out.println("Login failed!");
//		}

		Scanner scanner = new Scanner(System.in);
//		System.out.println("UserName: ");
		String username = ScannerUtilMentee.readUsername(scanner, "error");
//		System.out.println("Password: ");
		String password = ScannerUtilMentee.readPassword(scanner, "error");
		Mentee entity = form.toEntity();
		menteeService.createMentee(entity);
		boolean bl = new MenteeService().login(username, password);
		if(bl){
		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
		} else {
		return new ResponseEntity<Boolean>(HttpStatus.FORBIDDEN);
	}
}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateMentee(@PathVariable(name = "id") short id, @RequestBody UpdatingMenteeForm form) {
		menteeService.updateMentee(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteMentee(@PathVariable(name = "id") short id) {
		menteeService.deleteMentee(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}



