package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Customer;
import com.example.demo.entity.LoginModel;
@FeignClient(name="CustomerLoginMicroservice")
public interface CustomerLoginService {
	
	@LoadBalanced
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer c);
	
	@LoadBalanced
	@PostMapping("/login")
	public String loginCustomer(@RequestBody LoginModel request);
}
