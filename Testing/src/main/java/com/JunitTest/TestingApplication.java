package com.JunitTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.JunitTest.SpringSupport.Models.CollegeStudent;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		
		System.out.println("Came here my frnd!");
		SpringApplication.run(TestingApplication.class, args);
	}
	
	
	@Bean(name = "collegeStudent")
	@Scope(value = "prototype")
	CollegeStudent getCollegeStudent() {
		
		System.out.println("This method ran for creating Bean!!");
		return new CollegeStudent();
	}

}
