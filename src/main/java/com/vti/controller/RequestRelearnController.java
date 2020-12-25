package com.vti.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ViewRequestRelearnDTO;
import com.vti.entity.RequestRelearn;
import com.vti.service.IRequestRelearnService;

@RestController
@RequestMapping(value = "api/v1/requests/relearns")
public class RequestRelearnController {
	@Autowired
	private IRequestRelearnService relearnService;

	@GetMapping()
	public ResponseEntity<?> getAllRequestRelearns() {
		List<RequestRelearn> requestRelearn = relearnService.getAllRequestRelearns();
		// Convert entity to DTO
		List<ViewRequestRelearnDTO> dtos = new ArrayList<>();
		for (RequestRelearn relearns : requestRelearn) {
			ViewRequestRelearnDTO dto;
		// convert enum to string
			String statusstr = relearns.getStatusRelearn().toString();
			dto = new ViewRequestRelearnDTO(relearns.getRequestID() ,relearns.getMentee().getUserName(), relearns.getLesson().getName(),
					relearns.getLesson().getSubject().getName(), relearns.getStartDate(), relearns.getEndDate(),
					relearns.getNote(), statusstr, relearns.getTitle());
			dtos.add(dto);
		}
		return new ResponseEntity<List<ViewRequestRelearnDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getRequestRelearnByID(@PathVariable(name = "id") short id) {
		RequestRelearn relearn=  relearnService.getRequestRelearnByID(id);
		ViewRequestRelearnDTO dto;
		// convert enum to string
			String statusstr = relearn.getStatusRelearn().toString();
			dto = new ViewRequestRelearnDTO(relearn.getRequestID() ,relearn.getMentee().getUserName(), relearn.getLesson().getName(),
					relearn.getLesson().getSubject().getName(), relearn.getStartDate(), relearn.getEndDate(),
					relearn.getNote(), statusstr, relearn.getTitle());
		return new ResponseEntity<ViewRequestRelearnDTO>(dto, HttpStatus.OK);
	}
}
