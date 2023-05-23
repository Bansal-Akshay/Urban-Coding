package com.akshay.urbanCoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.akshay.urbanCoding.entities.Student;
import com.akshay.urbanCoding.payloads.StudentDto;
import com.akshay.urbanCoding.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	//Create new Student
	@PostMapping("/new")
	public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto){
//		System.out.println("hello");
		StudentDto savedStudentDto=this.studentService.createStudent(studentDto);
		return new ResponseEntity<>(savedStudentDto,HttpStatus.CREATED);
	}
	
	//Get Student by id
	@GetMapping("/get/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable  int studentId){
//		System.out.println("hello");
		StudentDto savedStudentDto=this.studentService.getStudentById(studentId);
		return new ResponseEntity<>(savedStudentDto,HttpStatus.OK);
	}
	
	//Delete Student by id
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable  int studentId){
//		System.out.println("hello");
		this.studentService.deleteStudent(studentId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	//Update Student by id
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable int studentId,@Valid @RequestBody StudentDto studentDto){
//		System.out.println("hello");
		StudentDto savedStudentDto=this.studentService.updateStudent(studentDto,studentId);
		return new ResponseEntity<>(savedStudentDto,HttpStatus.OK);
	}
	
}

