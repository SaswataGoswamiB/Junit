package com.JunitTest.Tdd;

public class FizzBuzz {
	
	public static String compute(int a) 
	{
		
		if(a%3==0 && a%5==0)
			return "FizzBuzz";
		if(a%3==0) 
		{
			return "Fizz";
		}
		if(a%5==0) 
		{
			return "Buzz";
		}
		return Integer.toString(a);
	}

}
