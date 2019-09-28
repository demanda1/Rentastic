package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class OtpRegistered {

	private int id;
	private String to;
	private String otp;
	private long timeStamp;
	
	public OtpRegistered(@Email String to, String otp, long timeStamp) {
		super();
		this.to = to;
		this.otp = otp;
		this.timeStamp = timeStamp;
	}
	
	
	
	
	
	
}
