package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.City;
import com.example.demo.entity.Product;
import com.example.demo.entity.Renter;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.RenterRepository;

@Service
public class RenterService {
	@Autowired CityRepository cityrepo;
	@Autowired ProductRepository productrepo;
	@Autowired RenterRepository renterrepo;
	@Autowired CategoryRepository categoryrepo;
	
	public List<Product> showProduct(String category,String city){
		System.out.println(category+city);
		List<Product> productobj=productrepo.findByCategoryAndCity(categoryrepo.findByCategory(category),cityrepo.findByCity(city));
		List<Product> prodlist=new ArrayList<>();
		for(Product p:productobj) {
			System.out.println(p);
			prodlist.add(p);
		}
		return prodlist;
	}
	
	public List<Product> showProductByCity(String city){
		List<City> cityobj=cityrepo.findByCity(city);
		List<Product> plist=productrepo.findByProductid("p2");
		for(Product p:plist) {
			System.out.println(p.getCategory());
		}
		for(City c:cityobj) {
			return c.getProductlist();
		}
		return null;
	}
	public void createProduct(Product p,String renterid,String category, String city) {
		
		List<Renter> renterList=renterrepo.findByRenterid(renterid);
		List<Category> categoryList=categoryrepo.findByCategory(category);
		List<City> cityList=cityrepo.findByCity(city);
		for(Renter r:renterList) {
			p.setRenter(r);
			List<Product> prodlist=r.getProductlist();
			prodlist.add(p);
			r.setProductlist(prodlist);
			System.out.println(r.getRentername());
			
		   }
			for(Category c:categoryList) {
				p.setCategory(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(p);
				c.setProductlist(prodlist);
				System.out.println(c.getCategory());
			}
			for(City c:cityList) {
				p.setCity(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(p);
				c.setProductlist(prodlist);
				System.out.println(c.getCity());
				
			}
			productrepo.save(p);
	}
	
	@Transactional
	public void deleteProduct(String pid) {
		
		 productrepo.deleteByProductid(pid);
		
	}
	
	@Transactional
	public void updateProduct(String name, String pid) {
		List<Product> p=productrepo.findByProductid(pid);
		for(Product pro:p) {
			pro.setProductname(name);
		}
	}
	
	@Transactional
	public void deleteRenter(String renterid) {
		renterrepo.deleteByRenterid(renterid);
	}
}
