package com.JunitTest.GradeBook.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JunitTest.GradeBook.Models.CollegeStudent;
import com.JunitTest.GradeBook.Repo.StudentDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentandGradeService {

	@Autowired
	private StudentDao studentDao;

	public CollegeStudent CreateStudent(String firstnameString, String Lastname, String email, Integer id) {

		CollegeStudent collegeStudent = new CollegeStudent(firstnameString, Lastname, email);
		collegeStudent.setId(id);
		// studentDao.save(collegeStudent);
		return studentDao.save(collegeStudent);

	}

	public boolean checkIdstudentNull(int id) {
		// TODO Auto-generated method stub

		Optional<CollegeStudent> studentOptional = studentDao.findById(id);

		// System.out.println(studentOptional.get().getEmailAddress());
		if (studentOptional.isPresent()) {
			return true;
		}

		return false;

	}

	public Iterable<CollegeStudent> getgradebook() {
		// TODO Auto-generated method stub

		Iterable<CollegeStudent> collegeStudents = studentDao.findAll();
		return collegeStudents;
	}

}
