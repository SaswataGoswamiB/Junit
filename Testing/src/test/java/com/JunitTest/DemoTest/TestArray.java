package com.JunitTest.DemoTest;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.JunitTest.Arrays.Testarr;

//order by displayname.
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//Order by method name.
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestArray {

	Testarr testarr;
	@BeforeEach
	void initial() 
	{
		testarr=new Testarr();
	}
	
	@Test
	@Order(1)
	@DisplayName("TestingArrays")
	void LetsTest() 
	{
		String[] firstarray= {"C","V","A"};
		Assertions.assertArrayEquals(firstarray,testarr.getFirstarray(),"Arrays are equal!");
		
	}
	
	@Test
	@Order(0)
	@DisplayName("Testing the ArrayList")
	void TestArray() 
	{
		List<String>aList=Arrays.asList("Beni","Arpita");
		Assertions.assertIterableEquals(aList,testarr.getaList(),"Lists are equal!!");
	}
	
	@Test
	@Order(-5)
	@DisplayName("Tetsing Exception!")
	void TestExcp() 
	{
		Assertions.assertThrows(Exception.class,()->testarr.ExceptionA(-1),"Should throw exception!");
		Assertions.assertDoesNotThrow(()->testarr.ExceptionA(9),"houldnot Throw exception! ");
	}
}
