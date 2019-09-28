package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;

@Repository
public interface MyCartRepository extends JpaRepository<MyCart, Integer>{

	List<MyCart> findByCustomerid(String cid);
	void deleteByCustomerid(String cid);
	List<MyCart> findByCustomeridAndProductid(String cid, String pid);
}
