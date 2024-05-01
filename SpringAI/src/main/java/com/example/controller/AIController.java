package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.AIService;

@RestController
@RequestMapping("/api/v1")
public class AIController {

	@Autowired
	AIService aiService;
	
	@GetMapping("/info")
	public String getInformation(@RequestParam String topic)
	{
		return aiService.getInformation(topic);
	}
	
	@GetMapping("/books")
	public String getBook(@RequestParam String category,@RequestParam String year)
	{
		return aiService.getBooks(category, year);
	}
	
	
}
