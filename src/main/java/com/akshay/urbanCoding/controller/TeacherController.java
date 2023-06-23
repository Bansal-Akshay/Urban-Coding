package com.akshay.urbanCoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.urbanCoding.payloads.TeacherDto;
import com.akshay.urbanCoding.services.TeacherService;

import jakarta.validation.Valid;

@RequestMapping("/teachers")
@RestController
//@Validated
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	//save new teacher
	@PostMapping("/new")
	public ResponseEntity<TeacherDto> saveTeacher(@Valid @RequestBody TeacherDto teacherDto){
		TeacherDto savedTeacherDto=this.teacherService.createTeacher(teacherDto);
		return new ResponseEntity<>(savedTeacherDto,HttpStatus.CREATED);
	}
	
	//get teacher by id
	@GetMapping("/get/{id}")
	public ResponseEntity<TeacherDto> getTeacherById(@PathVariable int id){
		TeacherDto teacherDto=this.teacherService.getTeacherById(id);
		return new ResponseEntity<>(teacherDto,HttpStatus.OK);
	}
	
	//get all Teachers
//	public ResponseEntity<> saveTeacher(){
//		
//	}
	
	//delete teacher by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable int id){
		this.teacherService.deleteTeacher(id);
		return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
	}
	
	//update teacher by id
	@PutMapping("/update/{id}")
	public ResponseEntity<TeacherDto> updateTeacher(@Valid @RequestBody TeacherDto teacherDto,@PathVariable int id){
		TeacherDto savedTeacherDto= this.teacherService.updateTeacher(teacherDto, id);
		return new ResponseEntity<>(savedTeacherDto,HttpStatus.OK);
	}
	
	// post content
	
	//subscribe to model
	
	// unsubscribe to model
	
	// reply to comments on content
	
	// delete comment of students from own content
	
	// edit content
	
	// delete content
	
	
	
}
