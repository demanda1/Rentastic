package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OtpRegistered;
import java.lang.String;
import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface OtpRepository  extends JpaRepository<OtpRegistered , Integer>{

	OtpRegistered findByTo(String to);
	@Transactional
	void deleteByTo(String to);
}
