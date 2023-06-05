package com.JunitTest.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.JunitTest.TestingApplication;
import com.JunitTest.Mockito.Dao.ApplicationDao;
import com.JunitTest.Mockito.Service.ApplicationService;
import com.JunitTest.SpringSupport.Models.CollegeStudent;
import com.JunitTest.SpringSupport.Models.StudentGrades;

@SpringBootTest(classes = TestingApplication.class)
public class MockAnnotationTest {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CollegeStudent collegeStudent;

	@Autowired
	StudentGrades studentGradestwoGrades;
	
	@Mock
	private ApplicationDao applicationDao;
	
	@InjectMocks
	private ApplicationService applicationService;
	
	
	@BeforeEach
	public void init() 
	{
		collegeStudent.setFirstname("Saswata");
		collegeStudent.setLastname("Goswami");
		collegeStudent.setEmailAddress("saswatas02091998@gmail.com");
		collegeStudent.setStudentGrades(studentGradestwoGrades);
	}
	
	@DisplayName("When and Verify")
	@Test
	public void assertrEqualksTest() 
	{
		
		Mockito.when(applicationDao.addGradeResultsForSingleClass(ArgumentMatchers.any())).thenReturn(100.00);
		
		Assertions.assertEquals(100,
				applicationService.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
		
		Mockito.verify(applicationDao,Mockito.times(1)).addGradeResultsForSingleClass(studentGradestwoGrades.getMathGradeResults());
		
		
	}

}
