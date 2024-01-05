package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class HomeController {
	
	@Autowired
	 private StudentRepository studentrepository;
	
	@GetMapping("/")
	public String index() {
		return "My name is akshata";
	}
	
	//Handler for creating new record in db
	@PostMapping("/savestudent")
	public Student saveData(@RequestBody Student student) {
		studentrepository.save(student);
		return student;
	}
	
	//Handler for fetching a particular record
	@GetMapping("/getData/{rollNo}")
	public Student getStudentData(@PathVariable int rollNo) {
		Optional<Student> student = studentrepository.findById(rollNo);
		Student student1 = student.get();
	    return student1;
	}
	
	//Handler for fetching record from db
	@GetMapping("/getAllStudent")
	public List<Student> getAll(){
		List<Student> studentlist = studentrepository.findAll();
		return studentlist;
	}
	
	//Handler for deleting particular record from db
	@DeleteMapping("/deleteStudent/{rollNo}")
	public String deleteStudent(@PathVariable int rollNo) {
		Student student = studentrepository.findById(rollNo).get();
		if(student!=null)
			studentrepository.delete(student);
		return "Deleted Successfully !";
	}
	
	//Handler for updating a particular record from db
	@PutMapping("/updateData")
	public Student updateStudentData(@RequestBody Student student) {
		studentrepository.save(student);
		return student;
	}
	
}
