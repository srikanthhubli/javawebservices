package com.myapp.spring;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyAPI {

	public MyAPI() {
		
	}
	
	@GetMapping("/hello")
	public String SayHello() {
		return "Current Date"+LocalDate.now()+" "+LocalTime.now();
		}
	
	@GetMapping("/hello2/{name}")
	public String SayHello2(@PathVariable("name") String name ) {
		return "Hello "+name +" " + "Current Date"+LocalDate.now()+" "+LocalTime.now();
		}
}
