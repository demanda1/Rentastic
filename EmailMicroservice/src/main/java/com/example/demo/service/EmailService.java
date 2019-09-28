package com.example.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.example.demo.dto.MailRequest;
import com.example.demo.dto.MailResponse;
import com.example.demo.dto.OtpResponse;
import com.example.demo.entity.OtpRegistered;
import com.example.demo.repository.OtpRepository;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	private  OtpRegistered regOtp= new OtpRegistered();
	
	@Autowired JavaMailSender sender;
	
	@Autowired Configuration config;
	
	@Autowired OtpRepository otpRepo;
	
	public Object sendEmail(MailRequest request, Map<String, Object> model) {
		
		MailResponse response = new MailResponse();
		OtpResponse otpResponse = new OtpResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
//			helper.addAttachment("invoice.pdf", new ClassPathResource("invoice.pdf"));

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			
			sender.send(message);
			System.out.println("message send");
			
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			otpResponse= mapper.map(regOtp, OtpResponse.class);
			
			return otpResponse;

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
			return response;
		}

	}
	
	//incase user is verified, we have to delete the otp and timestamp record related to that particular email
    public Object deleteVerifiedOtp(String email) {
    	otpRepo.deleteByTo(email);
		return "deleted..!";
    	
    }
	
	
	//generating the OTP
	public static char[] generatorOTP() 
	  { 
		int length =6;
	    System.out.print("Your OTP is : "); 
	              //Creating object of Random class
	    Random obj = new Random(); 
	    char[] otp = new char[length]; 
	    for (int i=0; i<length; i++) 
	    { 
	      otp[i]= (char)(obj.nextInt(10)+48); 
	    } 
	    return otp; 
	  } 
	
	
	//setting model for my freeMaker Template
	public  Map<String, Object> settingModel(MailRequest request) {
		
		Map<String, Object> model = new HashMap<>();
		
		model.put("fName", request.getFname());
		model.put("lName", request.getLname());
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		regOtp = mapper.map(request, OtpRegistered.class);
		
		//checking if we have already sent the OTP mail to the user or not  
		if(otpRepo.findByTo(regOtp.getTo())!=null) {
		otpRepo.deleteByTo(regOtp.getTo());//if exist then delete that record and send the new OTP mail to the user
		}
		
		regOtp.setOtp(new String(EmailService.generatorOTP()));
		regOtp.setTimeStamp(settingTimeStamp());
		otpRepo.save(regOtp);
		
		model.put("OTP", regOtp.getOtp());
		model.put("location", "Bangalore,India");
		return model;
		
	}
	
	
	
	//generating timeStamp
	public long settingTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}

	

}
