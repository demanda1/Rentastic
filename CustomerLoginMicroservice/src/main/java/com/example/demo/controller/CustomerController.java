package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.LoginModel;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer c){
		List<String> cid=new ArrayList<>();
		String status=customerService.createCustomer(c);
		if(status==null) {
			cid.add("userexist");
		}
		cid.add(status);
		return cid;
	}
	
	@PostMapping("/login")
	public String loginCustomer(@RequestBody LoginModel request){
		String cemail=request.getEmail();
		System.out.println(cemail);
		String cpass = request.getPassword();
		List<Customer> customerlist = customerService.verifyUser(cemail,cpass);
		if(customerlist!=null) {
			return cemail;
		}
		else return "Wrong Credentials";
	}
}
