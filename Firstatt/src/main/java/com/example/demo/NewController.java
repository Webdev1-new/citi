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
	@Autowired
	Login log;
	
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


@PostMapping("/logrequest")
public ResponseEntity<?> logReturn(@RequestBody LoginPojo loginpojo) 

{
	if(ram.findById(loginpojo.getLogin1()).orElse(null)==null)
	{
	   return  new ResponseEntity<String>("NOT registered",HttpStatus.BAD_REQUEST);
	   
	
    }
	else
	{
		if(loginpojo.getLogin2().equals(ram.findById(loginpojo.getLogin1()).orElse(null).getId5() ))
		{
		     log.save(loginpojo);
			return new ResponseEntity<String>("login sucessful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Please provide correct password",HttpStatus.BAD_REQUEST);
		}
	}
}
@PostMapping("/resetrequest")
public ResponseEntity<?>  resetReturn(@RequestBody ForgetPojo forgetpojo) 
{
	if(ram.existsById(forgetpojo.getResetid()))
	{
		SimplPojo spojo=ram.findById(forgetpojo.getResetid()).orElse(null);
		if(spojo.getId6().equals(forgetpojo.getQuestion()) && spojo.getId7().equals(forgetpojo.getSecret()))
           {
			spojo.setId5(forgetpojo.getResetlogin());
			ram.save(spojo);
			return new ResponseEntity<String>("Password updated Succesfully",HttpStatus.OK);
           }
		else
		{
			return new ResponseEntity<String>("Please provide correct security question and answer",HttpStatus.BAD_REQUEST);
		}
	}
	else
	{
		return new ResponseEntity<String>("Please provide correct credentials",HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}

}


