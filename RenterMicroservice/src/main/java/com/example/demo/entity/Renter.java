package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="renter")
public class Renter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String renterid;
	private String rentername;
	private String renteremail;
	private String renterpassword;
	private String rentercontact;
	private String rentergender;
	private String renteraddress;
	private String renterpancard;
	private int renterrating;
	
	
	
	@OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
	private List<Product> productlist;
	
	
	
	
	public Renter(String renterid, String rentername, String renteremail, String renterpassword, String rentercontact,
			String rentergender, String renteraddress, String renterpancard, int renterrating) {
		super();
		this.renterid = renterid;
		this.rentername = rentername;
		this.renteremail = renteremail;
		this.renterpassword = renterpassword;
		this.rentercontact = rentercontact;
		this.rentergender = rentergender;
		this.renteraddress = renteraddress;
		this.renterpancard = renterpancard;
		this.renterrating = renterrating;
	}
	public Renter() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRenterid() {
		return renterid;
	}
	public void setRenterid(String renterid) {
		this.renterid = renterid;
	}
	public String getRentername() {
		return rentername;
	}
	public void setRentername(String rentername) {
		this.rentername = rentername;
	}
	public String getRenteremail() {
		return renteremail;
	}
	public void setRenteremail(String renteremail) {
		this.renteremail = renteremail;
	}
	public String getRenterpassword() {
		return renterpassword;
	}
	public void setRenterpassword(String renterpassword) {
		this.renterpassword = renterpassword;
	}
	public String getRentercontact() {
		return rentercontact;
	}
	public void setRentercontact(String rentercontact) {
		this.rentercontact = rentercontact;
	}
	public String getRentergender() {
		return rentergender;
	}
	public void setRentergender(String rentergender) {
		this.rentergender = rentergender;
	}
	public String getRenteraddress() {
		return renteraddress;
	}
	public void setRenteraddress(String renteraddress) {
		this.renteraddress = renteraddress;
	}
	public String getRenterpancard() {
		return renterpancard;
	}
	public void setRenterpancard(String renterpancard) {
		this.renterpancard = renterpancard;
	}
	
	public int getRenterrating() {
		return renterrating;
	}
	public void setRenterrating(int renterrating) {
		this.renterrating = renterrating;
	}
	@JsonIgnore
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	

	
}
