package com.JunitTest.ReflectionTesting;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import com.JunitTest.TestingApplication;

@SpringBootTest(classes =TestingApplication.class )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReflcetionTestUtilsTest {

	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	CollegeStudent2 studentone;
	
	@Autowired
	StudentGrades2 studentGrades;
	
	@BeforeEach
	public void init() 
	{
		studentone.setFirstname("Saswtaa");
		studentone.setLastname("Goswami");
		studentone.setEmailAddress("saswata0202911");
		studentone.setStudentGrades(studentGrades);
		
		ReflectionTestUtils.setField(studentone,"id",1);
		ReflectionTestUtils.setField(studentone,"studentGrades",
				new StudentGrades2(new ArrayList<>(Arrays.asList(100.00,20.00,89.00,67.00,87.00))));
		
		
		
		
	}
	
	
	@Test
	@Order(2)
	public void getPrivateField() 
	{
		Assertions.assertEquals(1, ReflectionTestUtils.getField(studentone,"id"));
	}
	
	
	@Test
	@Order(1)
	public void getPrivateMethod() 
	{
		Assertions.assertEquals("Saswtaa   1",
				
				ReflectionTestUtils.invokeMethod(studentone,"getFirstnameStringandId"),"Call to Private Method didnt Happen");
	}
	}
