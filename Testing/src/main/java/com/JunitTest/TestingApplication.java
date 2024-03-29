package com.JunitTest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.JunitTest.GradeBook.Models.Grade;
import com.JunitTest.GradeBook.Models.HistoryGrade;
import com.JunitTest.GradeBook.Models.MathGrade;
import com.JunitTest.GradeBook.Models.ScienceGrade;
import com.JunitTest.ReflectionTesting.CollegeStudent2;
import com.JunitTest.SpringSupport.Models.CollegeStudent;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		
		System.out.println("Came here my frnd!");
		SpringApplication.run(TestingApplication.class, args);
	}
	
	
	@Bean
	@Scope(value = "prototype")
	CollegeStudent getCollegeStudent() {
		return new CollegeStudent();
	}

	@Bean
	@Scope(value = "prototype")
	Grade getMathGrade(double grade) {
		return new MathGrade(grade);
	}

	@Bean
	@Scope(value = "prototype")
	@Qualifier("mathGrades")
	MathGrade getGrade() {
		return new MathGrade();
	}

	@Bean
	@Scope(value = "prototype")
	@Qualifier("scienceGrades")
	ScienceGrade getScienceGrade() {
		return new ScienceGrade();
	}

	@Bean
	@Scope(value = "prototype")
	@Qualifier("historyGrades")
	HistoryGrade getHistoryGrade() {
		return new HistoryGrade();
	}


	}


