package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.vti.dto.CreatingRequestsupportForm;
import com.vti.dto.UpdatingRequestsupportForm;
import com.vti.dto.MenteeDTO;
import com.vti.dto.RequestDTO;
import com.vti.dto.RequestsupportDTO;
import com.vti.entity.Mentee;
import com.vti.entity.Request;
import com.vti.entity.Requestsupport;
import com.vti.service.IRequestsupportService;
import com.vti.service.RequestService;

@RestController
@RequestMapping(value = "api/v1/requests/support")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RequestsupportController {

	@Autowired
	private IRequestsupportService requestsupportService;
//	private RequestService requestService;
//	private Mentee mentee;
//	private Object menteeService;
//	private RequestDTO request;
//	private Requestsupport requestsupport;

	@GetMapping()
	public ResponseEntity<?> getAllRequestsupports() {
		List<Requestsupport> Requestsupports = requestsupportService.getAllRequestsupports();
		List<RequestsupportDTO> dtos = new ArrayList<>();
		for (Requestsupport requestsupport : Requestsupports) {

			RequestsupportDTO dto;
			
			dto = new RequestsupportDTO(requestsupport.getSubjectName(), requestsupport.getLessonName(), requestsupport.getCreateDate(),requestsupport.getStartime(), requestsupport.getEndtime(), requestsupport.getSupervisorName(), requestsupport.getStatus().getSignal());

			dtos.add(dto);
		}
		return new ResponseEntity<List<RequestsupportDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getRequestsupportByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Requestsupport>(requestsupportService.getRequestsupportByID(id), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> createRequestsupport(@RequestBody CreatingRequestsupportForm form) {
		requestsupportService.createRequestsupport(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}
//
//	@PostMapping()
//	public ResponseEntity<?> createRequestsupport(@RequestBody RequestsupportDTO dto) {
//		Requestsupport requestsupport = dto.createRequestsupport();
//		requestsupportService.createRequestsupport(requestsupport);
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateRequestsupport(@PathVariable(name = "id") short id, @RequestBody RequestDTO dto1,
//			@RequestBody RequestsupportDTO dto2) {
//		System.out.println(dto1.toString());
//		System.out.println(dto2.toString());
//		Request request = dto1.createRequest();
//		Requestsupport requestsupport = dto2.createRequestsupport();
//		// requestsupport.setRequestSupportID(id);
//		System.out.println(request.toString());
//		System.out.println(requestsupport.toString());
//		requestsupportService.updateRequestsupport(request, requestsupport);
//		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<?> updateRequestsupport(@PathVariable(name = "id") short id,
//			@RequestBody UpdatingRequestsupportForm form) {
//		List<Requestsupport> requestsupports = requestsupportService.getAllRequestsupports();

		// convert entity to dto
//		List<RequestsupportDTO> dtos = new ArrayList<>();
////		for (Request request : requests) {
//
//			RequestsupportDTO dto;
//			List<String> callrequest = new ArrayList<>();
//
//			for (Requestsupport requestsupport : requestsupports) {
//				callrequest.add(requestsupport.getMentee().getMenteeID(), requestsupport.getType().getKind());
////				requestTitles.add(request.getRequestID(), request.getTitle())
//
//			// convert 1 entity => 1 dto
//			dto = new RequestsupportDTO(requestsupport.getSubjectName(), requestsupport.getLessonName(), requestsupport.getSupervisorName(), requestsupport.getStartime(), requestsupport.getEndtime(), requestsupport.getCreateDate(), requestsupport.getStatus().getSignal(),  callrequest);
//
//			dtos.add(dto);
//		}
//		Requestsupport requestsupport = form.createRequestsupport();
//		// requestsupport.setRequestSupportID(id);
//		System.out.println(requestsupport.toString());
//		requestsupportService.updateRequestsupport(requestsupport);
//		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
//	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateRequestsupport(@PathVariable(name = "id") short id,
			@RequestBody UpdatingRequestsupportForm form) {
		requestsupportService.updateRequestsupport(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteRequestsupport(@PathVariable(name = "id") short id) {
		requestsupportService.deleteRequestsupport(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
