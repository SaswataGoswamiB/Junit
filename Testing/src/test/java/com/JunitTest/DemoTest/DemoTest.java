package com.JunitTest.DemoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import com.JunitTest.DemoUtils;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class DemoTest {

	DemoUtils dmDemoUtils;

	@BeforeEach
	public void run() {
		dmDemoUtils = new DemoUtils();
		System.out.println("Runnign Before Each");
	}

	@Test
	@DisplayName("Checking for Equality")
	void testequalsornotequals() {

		int a = dmDemoUtils.add(2, 8);
		int expected = 10;
		Assertions.assertEquals(a, expected);
	}
	
	@Test
	void testsame() 
	{
		String aString="Saswata";
		
		String bString="Arpita";
		
		//assertSame(aString, bString,"Objects are same!");
		//assertTrue(1<2, "Conditin appied !");
		
	}


}
