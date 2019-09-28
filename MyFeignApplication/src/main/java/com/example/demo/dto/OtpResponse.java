package com.example.demo.dto;

import lombok.Data;

@Data
public class OtpResponse {

	private String to;
	private String otp;
	private long timeStamp;
}
