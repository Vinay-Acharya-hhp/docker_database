package com.example.security.demosecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StudentController {
     
	@Autowired
	private StudentService service;


	
	@PostMapping("/add")
	public Student create(@RequestBody Student st) {
		return service.saveStudent(st);
	}
	
	
	@GetMapping("/get")
	public List<Student> getall(){
		return service.getAll();
	}
	
	
	
}
