package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class MailRequest {
	
	private String fname;
	private String lname;
	private String to;
	private String subject;
}
