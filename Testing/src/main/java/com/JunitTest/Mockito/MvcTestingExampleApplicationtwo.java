package com.JunitTest.Mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.JunitTest.Mockito.Dao.ApplicationDao;
import com.JunitTest.Mockito.Service.ApplicationService;
import com.JunitTest.SpringSupport.Models.CollegeStudent;


@SpringBootApplication
public class MvcTestingExampleApplicationtwo{

	public static void main(String[] args) {
		SpringApplication.run(MvcTestingExampleApplicationtwo.class, args);
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationExample")
	ApplicationService getApplicationService() {
		return new ApplicationService();
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationDao")
	ApplicationDao getApplicationDao() {
		return new ApplicationDao();
	}



}