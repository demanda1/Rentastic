package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MailRequest;
import com.example.demo.entity.Customer;
import com.example.demo.entity.LoginModel;
import com.example.demo.entity.Product;
import com.example.demo.service.CustomerLoginService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.EmailService;
import com.example.demo.service.RenterService;

@RestController
public class HomeController {
	@Autowired CustomerService customerService;
	@Autowired CustomerLoginService customerLoginService;
	@Autowired RenterService renterService;
	@RequestMapping("/")
	public String selectCity() {
		return "select-city";
	}
	
	@RequestMapping("/showallproduct")
	public List<Product> showProductByCity(@RequestParam("city") String city,Model theModel){
		List<Product> productlist=renterService.showProductByCity(city, theModel);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
//		theModel.addAttribute("productlist",productlist);
		return productlist;
	}
	
	@RequestMapping("/showproduct") 
	public List<Product> showProduct(@RequestParam("category") String category, @RequestParam("city") String city, Model theModel){
		System.out.println("inside feign of renter");
		List<Product> productlist=renterService.showProduct(category,city);
		//theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
		return productlist;
	}
	
	@RequestMapping("/createproduct/{renterid}/{category}/{city}")
	public void createProduct(@PathVariable String renterid,@PathVariable String category,@PathVariable String city, @RequestBody Product p) {
		renterService.createProduct(renterid, category, city, p);
		
	}
	
	@RequestMapping("/deleteproduct/{pid}")
	public void deleteProduct(@PathVariable String pid) {
		renterService.deleteProduct(pid);
	}
	
	@RequestMapping("/updateproduct/{name}/{pid}")
	public void updateProduct(@PathVariable String name, @PathVariable String pid) {
		renterService.updateProduct(name,pid);
	}
	
	@RequestMapping("/deleterenter/{sid}")
	public void deleteRenter(@PathVariable String sid) {
		renterService.deleteRenter(sid);
	}
	
	@RequestMapping("/mycart/{pid}/{cid}")
	public void addToCart(@PathVariable String pid,@PathVariable String cid) {
		String status=customerService.addToCart(pid, cid);
		System.out.println(status);
	}
	
	@RequestMapping("/savecart/{cid}/{pid}/{quantity}")
	public void saveCart(@PathVariable String cid,@PathVariable String pid, @PathVariable String quantity) {
		String status=customerService.saveCart(cid, pid, quantity);
		System.out.println(status);
	}
	@RequestMapping("/checkout/{status}/{cid}")
	public String orderProduct(@PathVariable String cid, @PathVariable String status) {
		if(status.equals("success")) {
			return customerService.orderProduct(cid, status);
		}
		else {
			return null;
		}
		
	}
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer c){
		List<String> cid=new ArrayList<>();
		cid=customerLoginService.createCustomer(c);
		return cid;
	}
	
	@PostMapping("/login")
	public String loginCustomer(@RequestBody LoginModel request){
		String status = customerLoginService.loginCustomer(request);
		return status;
	}
	
	
	//EMAIL Service client Calls
	@Autowired
	private EmailService service;

	@PostMapping("/sendotp")
	public ResponseEntity<?> sendEmail(@RequestBody MailRequest request) {
		Object result = service.sendEmail(request);
		return ResponseEntity.ok(result);
		
	}
	
	
	@PostMapping("/otpverified")
	public ResponseEntity<?> resendotp(@RequestBody MailRequest request) {
		Object resp=service.resendotp(request);
		return ResponseEntity.ok(resp);
	}
	
}
