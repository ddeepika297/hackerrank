package com.hackerrank.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.sample.dto.StringResponse;

@RestController
public class SampleController {
	@GetMapping(value = "/defaultHello")
	public ResponseEntity getHelloMessage(@RequestParam(required = false) String message) {
		String finalmessage = "Hello World!";
		if (message!=null)
			finalmessage = "Hello " + message;
		StringResponse str = new StringResponse(finalmessage);
		ResponseEntity res = new ResponseEntity(str, HttpStatus.OK);
		return res;

	}

	@PostMapping(value = "/customHello")
	public ResponseEntity PostHelloMessage(@RequestParam(required = false) String message) {

		if (message !=null) {
			String finalmessage = "Custom " + message;
			StringResponse str = new StringResponse(finalmessage);
			ResponseEntity res = new ResponseEntity(str, HttpStatus.OK);
			return res;
		}
		else return new ResponseEntity( HttpStatus.BAD_REQUEST);

	}
}
