package com.cwacrudapp.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwacrudapp.demo.model.MailRequest;
import com.cwacrudapp.demo.model.MailResponse;
import com.cwacrudapp.demo.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService eservice;
	
	@PostMapping("/sendmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		
		Map<String,Object> model = new HashMap<>();
		model.put("url", "https://www.google.com/");
		
		return eservice.sendEmail(request,model);
	}
	
}
