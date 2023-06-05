package com.JunitTest;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.JunitTest.SpringSupport.Models.CollegeStudent;
import com.JunitTest.SpringSupport.Models.StudentGrades;

@SpringBootTest(classes = TestingApplication.class)
class TestingApplicationTests {
	
	private static int count=0;
	
	@Value("${info.school.name}")
	private String schoolinfo;
	
	@Value("${info.app.name}")
	private String appname;
	
	@Value("${info.app.desc}")
	private String appdesc;
	
	@Value("${info.app.version}")
	private String appversion;
	
	@Autowired
	CollegeStudent collegeStudent;
	
	@Autowired
	StudentGrades studentGrades;
	
	@Autowired
	ApplicationContext applicationContext;

	@BeforeEach
	public void inti() 
	{
		
		count=count+1;
		System.out.println("App name "+appname+" which is "+appdesc);
		collegeStudent.setEmailAddress("Saswata@gmaiil.com");
		collegeStudent.setFirstname("Saswata");
		collegeStudent.setLastname("Goswmai");
		studentGrades.setMathGradeResults(new ArrayList<Double>(Arrays.asList(100.0,76.0,78.0,80.0)));
		collegeStudent.setStudentGrades(studentGrades);
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("Adding up the grades of it!")
	public void addGrades() 
	{
		Assertions.assertEquals(334,
				studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
	}
	
	@Test
	@DisplayName("Verify Students are Prototypes")
	public void verifyPrototype() 
	{
		CollegeStudent collegeStudenttwo=applicationContext.getBean("collegeStudent",CollegeStudent.class);
		StudentGrades studentGrades=applicationContext.getBean("studentgrades",StudentGrades.class);
		collegeStudenttwo.setEmailAddress("Saswata@gmaiil.com");
		collegeStudenttwo.setFirstname("Saswata");
		collegeStudenttwo.setLastname("Goswmai");
		studentGrades.setMathGradeResults(new ArrayList<Double>(Arrays.asList(100.0,76.0,78.0,80.0)));
		collegeStudenttwo.setStudentGrades(studentGrades);
		Assertions.assertNotSame(collegeStudenttwo,collegeStudent);
		
	}
}
