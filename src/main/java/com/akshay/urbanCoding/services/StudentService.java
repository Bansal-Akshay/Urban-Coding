package com.akshay.urbanCoding.services;

import java.util.List;

import com.akshay.urbanCoding.payloads.StudentDto;

public interface StudentService {
	
//	Student st;
	StudentDto createStudent(StudentDto student);
	StudentDto updateStudent(StudentDto student,Integer studentId);
	StudentDto getStudentById(Integer studentId);
	List<StudentDto> getAllStudents();
	void deleteStudent(Integer studentId);
}
