package com.JunitTest.GradeBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.JunitTest.GradeBook.Models.CollegeStudent;
import com.JunitTest.GradeBook.Repo.StudentDao;
import com.JunitTest.GradeBook.Service.StudentandGradeService;

@TestPropertySource("/application.properties")
@SpringBootTest(classes = MvcTestingExampleApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

//what is @Test Instance.
@TestInstance(Lifecycle.PER_CLASS)
public class StudentandGradeServiceTest {

	@Autowired
	StudentandGradeService studentandGradeService;

	@Autowired
	StudentDao studentDao;


    static JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
//	@BeforeAll
//	public  static  void init() 
//	{
//		jdbcTemplate.execute("insert into student(id,firstname,lastname,email_address)"+
//											"values(1,'Saswata','Goswami','saswaata@gail.com')");
//	}

	@Test
	public void createStudentService() { 

		studentandGradeService.CreateStudent("Saswata", "Goswami", "saswata@gail.com",1);

		CollegeStudent student = studentDao.findByEmailAddress("saswata@gail.com");

		Assertions.assertEquals("Saswata", student.getFirstname());

	}

	@Test 
	public void isStudentnullCheck() {
		
		studentandGradeService.CreateStudent("Saswata", "Goswami", "saswata@gail.com",1);
		Assertions.assertTrue(studentandGradeService.checkIdstudentNull(1));
	}

	@Test
	@Order(1)
	public void DeleteStudent() {
		
		studentandGradeService.CreateStudent("Saswata", "Goswami", "saswata@gail.com",1);
		Optional<CollegeStudent> collegeOptional = studentDao.findById(1);
		
		//l,studentandGradeService.deleteStudent()


	}
	
	@Test
	@Order(2)
	public void getGradeBook() 
	{
		
		
		Iterable<CollegeStudent> collegestudentliStudent=studentandGradeService.getgradebook();
		
		List<CollegeStudent>collegestudentliStudents=new ArrayList<>();
		
		for(CollegeStudent collegeStudent : collegestudentliStudent) 
		{
			collegestudentliStudents.add(collegeStudent);
		}
		
		
		Assertions.assertEquals(1,collegestudentliStudents.size());
	}
	
	//we can create a Custom SQL file in the Resources section and execute that sql file using @SQL.
	//The @SQL executes after the @BeforeEach.
	@Sql("/InsertData.sql")
	@Test
	public void getGradeBooksql() 
	{
		
		
		Iterable<CollegeStudent> collegestudentliStudent=studentandGradeService.getgradebook();
		
		List<CollegeStudent>collegestudentliStudents=new ArrayList<>();
		
		for(CollegeStudent collegeStudent : collegestudentliStudent) 
		{
			collegestudentliStudents.add(collegeStudent);
		}
		
		
		Assertions.assertEquals(6,collegestudentliStudents.size());
	}


}
