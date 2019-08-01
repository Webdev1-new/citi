package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {

	@Autowired
	Ram ram;
	
	@RequestMapping("/")
	String homepage()
	{
		
		System.out.println("tomcat server");
		
		return "NewFile.html";
		
	}

@PostMapping("/request")
public ResponseEntity<?> noReturn(@RequestBody SimplPojo simplpojo) 

{
	if(ram.findById(simplpojo.getId2()).orElse(null)==null)
	{  

		 System.out.println(simplpojo.getId2());
	     ram.save(simplpojo);
	     return new ResponseEntity<String>("sucessfully registered",HttpStatus.OK);
	  
	}
	else
	{
		System.out.println(simplpojo.getId2());
		return new ResponseEntity<String>("Emp_id already exixts",HttpStatus.BAD_REQUEST);
    }
	
}
}
