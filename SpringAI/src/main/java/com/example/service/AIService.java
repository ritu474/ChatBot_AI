package com.example.service;

import org.springframework.ai.client.AiClient;

import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {

	@Autowired
	AiClient aiClient;
	
	public String getInformation(String topic)
	{ 
		//creating a custom prompt
		PromptTemplate promptTemplate=new PromptTemplate("""
				
				Please provide me some information regarding the given {topic}
				Provide me the information as brief as possible
				
				
				""");
		promptTemplate.add("topic",topic);
		return this.aiClient.generate(promptTemplate.create()).getGeneration().getText();
	}
	
	//generate output in the JSON format
	public String getBooks(String category,String year)
	{
		PromptTemplate promptTemplate=new PromptTemplate("""
				
				Provide me the best books for the given {category} and the {year}.
				Give me a summary of the book as well as some information should be limited and not much in 
				depth. Provide me details in JSON format
				containing this information : category,year,review,author,summary
				
				""");
		
		promptTemplate.add("category",category);
		promptTemplate.add("year",year);
		return this.aiClient.generate(promptTemplate.create()).getGeneration().getText();
	}
	
}
