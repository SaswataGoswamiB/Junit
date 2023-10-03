package com.JunitTest;

import java.security.PublicKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Useless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String statusCode = "200";
        
		
		
        
        // Checking the value of the HttpStatus enum
        System.out.println("HttpStatus: " + getresposnse()); // HttpStatus
        
        System.out.println("HttpStatus 2 : " + getresposnse2()); // HttpStatus
        
      // HttpStatus httpStatus= HttpStatus.valueOf(200);
		
		
//		HttpStatus customHttpStatus = new HttpStatus(200, "Custom Status");
//		
//		  System.out.println("Custom HttpStatus: " + customHttpStatus); // Custom HttpStatus: 200 Custom Status
//    }
				
		
        
       

	}
	
	
	public static ResponseEntity<String> getresposnse()
	{
		CustomHttpStatus customHttpStatus=CustomHttpStatus.HTTP_418_CUSTOM_TEAPOT;
		
		return ResponseEntity.status(customHttpStatus.toHttpStatus()).body("Exampleeee");
	}
	
	public static ResponseEntity<String> getresposnse2()
	{

		
		return ResponseEntity.status(200).build();
	}

}
