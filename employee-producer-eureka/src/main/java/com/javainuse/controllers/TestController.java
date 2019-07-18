package com.javainuse.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class TestController {

	@HystrixCommand(fallbackMethod = "recommendationFallback")
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		String baseUrl = "http://localhost:3000/questions";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);

			System.out.println("response: " + response.getBody());
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return emp;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}


	public Employee recommendationFallback() {
		System.out.println("=======recommendationFallback=========");
		return new Employee("HISTRIX");
	}
}
