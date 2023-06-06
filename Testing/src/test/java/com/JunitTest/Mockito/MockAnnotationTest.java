package com.JunitTest.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import com.JunitTest.TestingApplication;
import com.JunitTest.Mockito.Dao.ApplicationDao;
import com.JunitTest.Mockito.Service.ApplicationService;
import com.JunitTest.SpringSupport.Models.CollegeStudent;
import com.JunitTest.SpringSupport.Models.StudentGrades;

@SpringBootTest(classes = TestingApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MockAnnotationTest {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CollegeStudent collegeStudent;

	@Autowired
	StudentGrades studentGradestwoGrades;

	// @Mock
	@MockBean
	private ApplicationDao applicationDao;

	// @InjectMocks
	@Autowired
	private ApplicationService applicationService;

	// @Mock is used over attribute that we are actually mocking.
	// @InjectsMocks is used to inject the dependency of the attribute that has the
	// @Mock and @Spy annotation.
	// So
	// @InjectMocks
	// Private ApplicationService applicationservice;

	// Here applicationservice is having a dependnecy of the applicatioindao(that
	// has been mocked with the mocked value.)

	// Without using the @InjectsMocks you cannot use the mocked value in the code
	// If you would have writtern

	// Private ApplicationService applicationservice;

	// you wodnt have got the mocked value.

	// Make a vuideo Please

	@BeforeEach
	public void init() {
		collegeStudent.setFirstname("Saswata");
		collegeStudent.setLastname("Goswami");
		collegeStudent.setEmailAddress("saswatas02091998@gmail.com");
		collegeStudent.setStudentGrades(studentGradestwoGrades);
	}

	@DisplayName("When and Verify")
	@Test
	@Order(2)
	public void assertrEqualksTest() {

		Mockito.when(applicationDao.addGradeResultsForSingleClass(ArgumentMatchers.any())).thenReturn(100.00);

		Assertions.assertEquals(100, applicationService
				.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));

		Mockito.verify(applicationDao, Mockito.times(1))
				.addGradeResultsForSingleClass(studentGradestwoGrades.getMathGradeResults());

		// Mockito.verify(applicationDao).addGradeResultsForSingleClass(studentGradestwoGrades.getMathGradeResults());

	}

	@DisplayName("Throwing Exception!")
	@Test
	@Order(1)
	public void Exception() {

		CollegeStudent collegeStudent1 = applicationContext.getBean("collegeStudent", CollegeStudent.class);

		//Here what willl happen is that for the first call to the applicationDao.checknull() method
		// we will get an exception and 
		//in the later calls(starting from the second call) we ill get the String --->"Donot throw this exception"
		Mockito.when(applicationDao.checkNull(ArgumentMatchers.any())).thenThrow(new RuntimeException())
				.thenReturn("Donot throw this exception");

		Assertions.assertThrows(RuntimeException.class, () -> applicationService.checkNull(collegeStudent));
		
		Assertions.assertEquals("Donot throw this exception",applicationService.checkNull(collegeStudent1));
	}

	@DisplayName("Testing Context and value")
	@Test
	@Order(3)
	public void Findit() {
		
		CollegeStudent collegeStudent1 = applicationContext.getBean("collegeStudent", CollegeStudent.class);

		System.out.println("The First name from Context is " + collegeStudent1.getFirstname());

		System.out.println("The First name from the Before call is " + collegeStudent.getFirstname());
	}
}
