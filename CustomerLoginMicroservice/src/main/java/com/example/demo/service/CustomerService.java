package com.example.demo.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired CustomerRepository customerrepo;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String createCustomer(Customer c) {
			String email= c.getCustomeremail();
			System.out.println(email);
			List<Customer> customerlist = customerrepo.findByCustomeremail(c.getCustomeremail());
			if(customerlist.isEmpty()) {
				c.setCustomerid(generateRandomString());
				c.setCustomerpassword(bCryptPasswordEncoder.encode(c.getCustomerpassword()));
				customerrepo.save(c);
				return c.getCustomerid().toString();
			}
			System.out.println("user already exist.!");
			return null;
	   }
	

		public List<Customer> verifyUser(String cemail, String cpass ) {
			List<Customer> customerlist = customerrepo.findByCustomeremail(cemail);
		       for(Customer c:customerlist) {
		    	   if(c.getCustomeremail().equals(cemail) &&  bCryptPasswordEncoder.matches(cpass,c.getCustomerpassword())) {
		    		   
		    		   return customerlist;
		    	   }
		    	   else {
		    		   return null;
		    	   }
		    	   
		       }
				return null;
			 }
	
	
	public static String generateRandomString() {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        int length=6;
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

	
}
