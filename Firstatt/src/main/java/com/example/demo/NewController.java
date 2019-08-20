package com.example.demo;
import java.util.HashMap;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewController {

	@Autowired
	Ram ram;
	@Autowired
	Login log;
	@Autowired
	Request1 request;
	@Autowired
	Response response;
	HashMap<String,String> map=new HashMap<>();
	
	@RequestMapping("/")
	String homepage()
	{
		
		System.out.println("tomcat server");
		
		return "NewFile.html";
		
	}

@PostMapping("/request1")
public ResponseEntity<?> noReturn1(@RequestBody SimplPojo simplpojo) 

	{
	  request.save(simplpojo);
	  return new ResponseEntity<String>("sucessfully registered",HttpStatus.OK);
		
	}	

@PostMapping("/request2")
public ResponseEntity<?> noReturn2(@RequestBody SimplPojo1 simplpojo) 

{

	if(ram.findById(simplpojo.getId5()).orElse(null)==null)
	{  

		 System.out.println(simplpojo.getId5());
	     ram.save(simplpojo);
	     return new ResponseEntity<String>("sucessfully registered",HttpStatus.OK);
	  
	}
	else
	{
		System.out.println(simplpojo.getId5());
		return new ResponseEntity<String>("Emp_id already exixts",HttpStatus.BAD_REQUEST);
    }
	
}


@PostMapping("/logrequest")
public ResponseEntity<?> logReturn(@RequestBody LoginPojo loginpojo,HttpSession session) 
{
    if(map.containsKey(session.getId()))
    {
    	return new ResponseEntity<String>("Redirecting",HttpStatus.OK);
    }
    else
    {
    	map.put(session.getId(), loginpojo.getLogin1());
    

    if(ram.findById(loginpojo.getLogin1()).orElse(null)==null)
	{
	   return  new ResponseEntity<String>("NOT registered",HttpStatus.BAD_REQUEST);
	   
	
    }
	else
	{
		if(loginpojo.getLogin2().equals(ram.findById(loginpojo.getLogin1()).orElse(null).getId6() ))
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
   
}
	
@PostMapping("/resetrequest")
public ResponseEntity<?>  resetReturn(@RequestBody ForgetPojo forgetpojo) 
{
	if(ram.existsById(forgetpojo.getResetid()))
	{
		SimplPojo1 spojo=ram.findById(forgetpojo.getResetid()).orElse(null);
		if(spojo.getId7().equals(forgetpojo.getQuestion()) && spojo.getId8().equals(forgetpojo.getSecret()))
           {
			  spojo.setId6(forgetpojo.getResetlogin());
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
@GetMapping("/logoutrequest")
 public ResponseEntity<?> logoutRequest(HttpSession session)
{
	map.remove(session.getId());
	session.invalidate();
	return new ResponseEntity<String>("Please provide correct credentials",HttpStatus.OK);
}


@PostMapping("/getinforequest")
public ResponseEntity<?> getInfo(@RequestBody Searchmap name)
{
	System.out.println(name.getSearch());
	 List<SimplPojo> result= request.findById3(name.getSearch()) ;
	 List<SimplPojo> result1= request.findById4(name.getSearch());
	 if(result!=null)
	 {
		 for(SimplPojo ob:result)
		 {
			System.out.println(ob.getId1()+ " "+ob.getId2()+ " "+ob.getId3()+" "+ob.getId4()) ;
		 }
	 }
	 if(result==null && result1==null)
	 {
		 return new ResponseEntity<String>("No such users exist",HttpStatus.BAD_REQUEST);
	 }
	 else
	 {
		 response.setMsg("success");
		 response.setGetinfo(result);
		 response.setGetinfo1(result1);
		 return  new ResponseEntity<Response>(response,HttpStatus.OK);
		 
	 }
	
}
}

