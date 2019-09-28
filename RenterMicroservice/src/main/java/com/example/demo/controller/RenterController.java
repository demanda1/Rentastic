package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.RenterService;

@RestController
public class RenterController {

	@Autowired RenterService renterService;
	
	
	@RequestMapping("/showallproduct")
	public List<Product> showProductByCity(@RequestParam("city") String city,Model theModel){
		List<Product> productlist=renterService.showProductByCity(city);
	//	theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
		return productlist;
	}
	
	@RequestMapping("/showproduct")
	public List<Product> showProduct(@RequestParam("category") String category, @RequestParam("city") String city){
		System.out.println("reached in show product!!");
		List<Product> productlist=renterService.showProduct(category,city);
		//theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.toString());
		}
		return productlist;
	}
	
	@RequestMapping("/createproduct/{renterid}/{category}/{city}")
	public void createProduct(@PathVariable String renterid,@PathVariable String category,@PathVariable String city, @RequestBody Product p) {
		renterService.createProduct(p, renterid, category, city);
		
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
}
