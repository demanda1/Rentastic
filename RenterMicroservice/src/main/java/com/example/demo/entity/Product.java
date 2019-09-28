package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productid;
	private String productname;
	private String productcategory;
	private String productsubcategory;
	private String productdescription;
	private int productprice;
	private int productquantity;
	private boolean productavailability;
	private String productimage;

	@ManyToOne
	@JoinColumn(name="renterid")
	private Renter renter;
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	@ManyToOne
	@JoinColumn(name="cityid")
	private City city;
	public Product(String productid, String productname, String productcategory, String productsubcategory,
			String productdescription, int productprice, int productquantity, boolean productavailability,
			String productimage) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productcategory = productcategory;
		this.productsubcategory = productsubcategory;
		this.productdescription = productdescription;
		this.productprice = productprice;
		this.productquantity = productquantity;
		this.productavailability = productavailability;
		this.productimage = productimage;
	}
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getProductsubcategory() {
		return productsubcategory;
	}
	public void setProductsubcategory(String productsubcategory) {
		this.productsubcategory = productsubcategory;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public int getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}
	public boolean isProductavailability() {
		return productavailability;
	}
	public void setProductavailability(boolean productavailability) {
		this.productavailability = productavailability;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	@JsonIgnore
	public Renter getRenter() {
		return renter;
	}
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	@JsonIgnore
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@JsonIgnore
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
