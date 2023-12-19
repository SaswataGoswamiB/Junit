package com.JunitTest.GradeBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.JunitTest.GradeBook.Models.CollegeStudent;
import com.JunitTest.GradeBook.Models.Gradebook;
import com.JunitTest.GradeBook.Service.StudentandGradeService;

@Controller
public class GradebookController {

	@Autowired
	private Gradebook gradebook;
	
	@Autowired
	CollegeStudent collegeStudent;
	
	
	@Autowired
	StudentandGradeService studentandGradeService;


	@RequestMapping(value = "/getsudent", method = RequestMethod.GET)
	public String getStudents(Model m) {
		
		Iterable<CollegeStudent>collegestudentiterbale=studentandGradeService.getgradebook();
		m.addAttribute("students", collegestudentiterbale);
		return "index";
	}


	@GetMapping("/studentInformation/{id}")
		public String studentInformation(@PathVariable int id, Model m) {
		return "studentInformation";
		}

}