package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="CustomerMicroservice")
public interface CustomerService {
	
	@RequestMapping(value="/mycart/{pid}/{cid}",  method=RequestMethod.GET)
	public String addToCart(@PathVariable String pid,@PathVariable String cid);
	
	@RequestMapping(value="/savecart/{cid}/{pid}/{quantity}",  method=RequestMethod.GET)
	public String saveCart(@PathVariable String cid,@PathVariable String pid, @PathVariable String quantity);
	@RequestMapping(value="/checkout/{status}/{cid}",  method=RequestMethod.GET)
	public String orderProduct(@PathVariable String cid, @PathVariable String status);
	
}
