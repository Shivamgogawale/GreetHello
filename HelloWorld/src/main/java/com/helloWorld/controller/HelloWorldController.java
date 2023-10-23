package com.helloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greetapi/v1" ,method = {RequestMethod.GET,RequestMethod.POST})
public class HelloWorldController {

	@GetMapping(value = "/hello")
	public String gethello()
	{
		return "hello World !!!";
	}
	
	@GetMapping(value = "/hellowithname")
	public String getHelloWithName(@RequestParam String name)
	{
		return "hello " + name+ " !!!";
	}
}
