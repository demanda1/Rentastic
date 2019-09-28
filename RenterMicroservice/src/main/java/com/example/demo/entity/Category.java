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
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String categoryid;
	private String category;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> productlist;
	public Category() {
		super();
	}
	
	public Category(String category, String categoryid) {
		super();
		this.category = category;
		this.categoryid=categoryid;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@JsonIgnore
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
