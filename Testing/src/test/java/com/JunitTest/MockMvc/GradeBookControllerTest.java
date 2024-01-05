package com.JunitTest.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import com.JunitTest.GradeBook.MvcTestingExampleApplication;
import com.JunitTest.GradeBook.Models.CollegeStudent;
import com.JunitTest.GradeBook.Models.GradebookCollegeStudent;
import com.JunitTest.GradeBook.Repo.StudentDao;
import com.JunitTest.GradeBook.Service.StudentandGradeService;

//@PropertySource("/application.properties")
@AutoConfigureMockMvc
@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class GradeBookControllerTest {
	
	public static MockHttpServletRequest mockHttpServletRequest;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired  
	private MockMvc mockmvc;	
	
	@Mock   
	private StudentandGradeService studentandGradeService; 
	
	@Autowired
	private StudentDao studentDao;
	
	@BeforeAll
	//alll the fields inside Beforeall has to be static.
	public static void setup() 
	{
		mockHttpServletRequest=new MockHttpServletRequest();
		mockHttpServletRequest.setParameter("firstname","Saswata");
		mockHttpServletRequest.setParameter("lastname", "Goswami");
		mockHttpServletRequest.setParameter("emailAddress", "Saswata02091998@Gmail.com");
		
	}
	
	@BeforeEach
	public void beforeEach() 
	{
		jdbcTemplate.execute("insert into student(id,firstname,lastname,email_address)"+
 			"values(1,'Saswata','Goswami','saswaata@gail.com')");
		
	}
	
	@Test
	public void getStudentHttpRequest() throws Exception
	{
		CollegeStudent student=new GradebookCollegeStudent("Saswata","Goswami","saswaata@gail.com");
		
		CollegeStudent studentone=new GradebookCollegeStudent("IG","LamarGod","iglamargod@gail.com");
		
		List<CollegeStudent> collegestudentliStudents=new ArrayList<>(Arrays.asList(student,studentone));
		
		Mockito.when(studentandGradeService.getgradebook()).thenReturn(collegestudentliStudents);
		
		Assertions.assertIterableEquals(collegestudentliStudents,studentandGradeService.getgradebook());
		
		MvcResult mvcResult=mockmvc.perform(MockMvcRequestBuilders.get("/getsudent")).
				andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		ModelAndView modelAndView=mvcResult.getModelAndView();
		
		Assertions.assertEquals("index",modelAndView.getViewName());
	}
	
	@Test
	public void CreateStudent() throws Exception 
	{
		
		MvcResult mvcResult=mockmvc.perform(MockMvcRequestBuilders.post("/").
				contentType(MediaType.APPLICATION_JSON).
				param("firstname",mockHttpServletRequest.getParameterValues("firstname")).
				param("lastname",mockHttpServletRequest.getParameterValues("lastname")).
				param("email", mockHttpServletRequest.getParameterValues("emailAddress"))).
				andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		ModelAndView modelAndView=mvcResult.getModelAndView();
		
		ModelAndViewAssert.assertViewName(modelAndView,"index");
		
	}
	
	@Test
	public void deleteStudent() throws Exception
	{
		
		Assertions.assertTrue(studentDao.findById(1).isPresent());
		
		MvcResult mvcResult=mockmvc.perform(MockMvcRequestBuilders.get("/delete/student/{id}")).
				andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		ModelAndView modelAndView=mvcResult.getModelAndView();
		
		ModelAndViewAssert.assertViewName(modelAndView,"index");
	}
	
	@AfterEach
	public void after() 
	{
		jdbcTemplate.execute("DELETE FROM student");
	}

		
	}


