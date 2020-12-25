package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ViewSupportHistory;
import com.vti.entity.Requestsupport;
import com.vti.service.ISupportHistoryService;

@RestController
@RequestMapping(value = "api/v1/requests/supportHistory")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class SupportHistoryController {
	@Autowired
	private ISupportHistoryService service;

	@GetMapping()
	public ResponseEntity<?> getAllHistorySupports() {
		List<Requestsupport> entities = service.getAllSupportHistory();

		// convert entity to dto
		List<ViewSupportHistory> dtos = new ArrayList<>();

		for (Requestsupport entity : entities) {
			ViewSupportHistory dto = new ViewSupportHistory(entity.getStartime(), entity.getEndtime(),
					entity.getSupervisorName(), entity.getType(), entity.getNote());

			dtos.add(dto);

		}
		return new ResponseEntity<List<ViewSupportHistory>>(dtos, HttpStatus.OK);
	}
}
