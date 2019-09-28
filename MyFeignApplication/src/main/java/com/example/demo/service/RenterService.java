package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
@FeignClient(name="RenterMicroservice")
public interface RenterService {
	
	@RequestMapping(value="/",  method=RequestMethod.GET)
	public String selectCity();
	
	@RequestMapping(value="/showallproduct",  method=RequestMethod.GET)
	public List<Product> showProductByCity(@RequestParam("city") String city,Model theModel);
	
	@RequestMapping(value="/showproduct",  method=RequestMethod.GET)
	public List<Product> showProduct(@RequestParam String category, @RequestParam String city);
	
	@RequestMapping(value="/createproduct/{renterid}/{category}/{city}",  method=RequestMethod.POST)
	public void createProduct(@PathVariable String renterid,@PathVariable String category,@PathVariable String city, @RequestBody Product p);
	
	@RequestMapping(value="/deleteproduct/{pid}",  method=RequestMethod.GET)
	public void deleteProduct(@PathVariable String pid);
	
	@RequestMapping(value="/updateproduct/{name}/{pid}",  method=RequestMethod.GET)
	public void updateProduct(@PathVariable String name, @PathVariable String pid);
	
	@RequestMapping(value="/deleterenter/{sid}",  method=RequestMethod.GET)
	public void deleteRenter(@PathVariable String sid);
}
