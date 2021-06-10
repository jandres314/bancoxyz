package com.poligran.bancoxyz.presentacion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class ControllerSalud {

	@GetMapping
	public ResponseEntity<String> info() {
		String data = String.format("success: %s", LocalDateTime.now());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
