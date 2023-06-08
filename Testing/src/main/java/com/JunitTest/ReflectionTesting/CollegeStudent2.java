package com.JunitTest.ReflectionTesting;

import org.springframework.beans.factory.annotation.Value;

public class CollegeStudent2 implements Student2 {
	
	private int id;
   
	@Value("Arpita")
	private String firstname;
	@Value("#{new java.lang.String('Biswas')}")
    private String lastname;
    private String emailAddress;
    private StudentGrades2 studentGrades;

    public CollegeStudent2() {
    }

   
    public CollegeStudent2(int id, String firstname, String lastname, String emailAddress,
			StudentGrades2 studentGrades) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.studentGrades = studentGrades;
	}


	public String getFirstname() {
        return firstname;
    }

    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public StudentGrades2 getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(StudentGrades2 studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", studentGrades=" + studentGrades +
                '}';
    }

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress();
    }

    @Override
    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }
    
    private String getFirstnameStringandId() 
    {
    	
    	return getFirstname()+"   "+getId();
    }
}
