package com.example.security.demosecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private Studentrepo repo;

	public StudentService(Studentrepo repo) {

		this.repo = repo;
	}
	
	public List<Student> getAll(){
		return repo.findAll();
	}
	
	
//	public Student getStudentById(Long id) {
//		return repo.findById(id);
//	}
	
	public Student saveStudent(Student st) {
		return repo.save(st);
	}
	

}
