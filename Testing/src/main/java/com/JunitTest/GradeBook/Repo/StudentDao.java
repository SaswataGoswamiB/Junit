package com.JunitTest.GradeBook.Repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.JunitTest.GradeBook.Models.CollegeStudent;

@Repository
@Component("studentDao")
public interface StudentDao extends CrudRepository<CollegeStudent, Integer> {


	 public CollegeStudent findByEmailAddress(String string);

}
