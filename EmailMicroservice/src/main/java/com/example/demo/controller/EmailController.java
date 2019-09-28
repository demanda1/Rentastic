package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.dto.MailRequest;
import com.example.demo.dto.OtpResponse;
import com.example.demo.service.EmailService;

@RestController
public class EmailController {

	
	@Autowired
	private EmailService service;

	@PostMapping("/sendotp")
	public ResponseEntity<?> sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model=service.settingModel(request);
		Object result = service.sendEmail(request, model);
		return ResponseEntity.ok(result);
		
	}
	
	
	@PostMapping("/otpverified")
	public ResponseEntity<?> resendotp(@RequestBody MailRequest request) {
		Object resp=service.deleteVerifiedOtp(request.getTo());
		return ResponseEntity.ok(resp);
	}
}
