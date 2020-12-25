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

import com.vti.dto.RequestRetestDTO;
import com.vti.entity.RequestRetest;
import com.vti.service.IRequestRetestService;

@RestController
@RequestMapping(value = "api/v1/requests/retest")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RequestRetestController {

	@Autowired
	private IRequestRetestService service;

	@GetMapping()
	public ResponseEntity<?> getAllRequestRetest() {
		List<RequestRetest> requestRetest = service.getAllRequestRetests();

		List<RequestRetestDTO> dtos = new ArrayList<>();
		for (RequestRetest request : requestRetest) {
			RequestRetestDTO dto;
			String statuss = request.getStatus().toString();
			dto = new RequestRetestDTO(request.getRequestID(), request.getTime(), request.getPoint(), statuss);
			dtos.add(dto);
		}

		return new ResponseEntity<List<RequestRetestDTO>>(dtos, HttpStatus.OK);
	}
}
