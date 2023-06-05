package com.JunitTest.Arrays;

import java.util.Arrays;
import java.util.List;

public class Testarr {
	
	private String[] firstarray= {"C","V","A"};
	
	List<String>aList=Arrays.asList("Beni","Arpita");

	public String[] getFirstarray() {
		return firstarray;
	}

	public void setFirstarray(String[] firstarray) {
		this.firstarray = firstarray;
	}

	public List<String> getaList() {
		return aList;
	}

	public void setaList(List<String> aList) {
		this.aList = aList;
	}
	
	public static String ExceptionA(Integer a) throws Exception 
	{
		if(a<0)
			throw new Exception("Value has to be greater than zzero!");
		
		return "Value is Approved !";
	}

}
