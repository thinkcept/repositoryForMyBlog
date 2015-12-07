package com.org.coop.junit;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.coop.bs.config.BusinessServiceConfig;
import com.org.coop.service.EmailService;
import com.org.coop.service.LoginService;
import com.org.coop.society.data.transaction.config.DataAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataAppConfig.class, BusinessServiceConfig.class})
public class CooperativeServiceTest {
	private static final Logger logger = Logger.getLogger(CooperativeServiceTest.class);
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EmailService emailService;
	
//	@Test
	public void fetchStaff() {
		List<String> role = loginService.getRole("ashish");
		System.out.println(role);
		logger.info("Role: " + role);
	}
	
	@Test
	public void emailTester() {
		emailService.sendEmail("asmo00b1@gmail.com", "coop@gmail.com", "Test mail from java app", "This is a test mail");
	}
}