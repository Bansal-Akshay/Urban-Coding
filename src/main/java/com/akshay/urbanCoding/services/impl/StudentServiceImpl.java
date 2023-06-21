package com.akshay.urbanCoding.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.urbanCoding.dao.StudentRepo;
import com.akshay.urbanCoding.entities.Student;
import com.akshay.urbanCoding.exceptions.ResourceNotFoundException;
import com.akshay.urbanCoding.payloads.StudentDto;
import com.akshay.urbanCoding.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		
		Student student = this.dtoToStudent(studentDto);
		Student savedStudent=this.studentRepo.save(student);
		return this.studentToDto(savedStudent);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
		
		Student student=this.studentRepo.findById(studentId).orElseThrow((()-> new ResourceNotFoundException("Student","Student id ",studentId)));
		
		student.setStudName(studentDto.getStudName());
		student.setStudEmail(studentDto.getStudEmail());
		student.setStudContact(studentDto.getStudContact());
		student.setStudCollege(studentDto.getStudCollege());
		student.setStudUserName(studentDto.getStudUserName());
		student.setStudPassword(studentDto.getStudPassword());
//		Student student = this.dtoToStudent(studentDto);
		Student updatedStudent=this.studentRepo.save(student);
//		return this.modelMapper.map(updatedStudent, StudentDto.class);
		System.out.println(updatedStudent);
		return this.studentToDto(updatedStudent);
	}

	@Override
	public StudentDto getStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		Student student=this.studentRepo.findById(studentId).orElseThrow((()-> new ResourceNotFoundException("Student","Student id",studentId)));
		
		return this.studentToDto(student);
	}
//	@Override
//	public Student getStudentById(Integer studentId) {
//		// TODO Auto-generated method stub
//		Student student=this.studentRepo.findById(studentId).orElseThrow((()-> new ResourceNotFoundException("Student","Student id",studentId)));
//		
//		return student;
//	}

	@Override
	public List<StudentDto> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> stduentList=this.studentRepo.findAll();
		List<StudentDto> stduentDtoList=stduentList.stream().map(student->this.studentToDto(student)).collect(Collectors.toList());
		return stduentDtoList;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student student=this.studentRepo.findById(studentId).orElseThrow((()-> new ResourceNotFoundException("Student","Student id",studentId)));
		this.studentRepo.delete(student);
	}
	
	//Student Dto to Student object
	public Student dtoToStudent(StudentDto studentDto) {
		
		Student student=this.modelMapper.map(studentDto, Student.class);
//		student.setStudId(studentDto.getStudId());
//		student.setStudName(studentDto.getStudName());
//		student.setStudEmail(studentDto.getStudEmail());
//		student.setStudCollege(studentDto.getStudCollege());
//		student.setStudContact(studentDto.getStudContact());
//		student.setStudUserName(studentDto.getStudUserName());
//		student.setStudPassword(studentDto.getStudPassword());
		return student;
	}
	//Student object to Student dto
	public StudentDto studentToDto(Student student) {
		StudentDto studentDto=this.modelMapper.map(student, StudentDto.class);
//		studentDto.setStudId(student.getStudId());
//		studentDto.setStudName(student.getStudName());
//		studentDto.setStudEmail(student.getStudEmail());
//		studentDto.setStudCollege(student.getStudCollege());
//		studentDto.setStudContact(student.getStudContact());
//		studentDto.setStudUserName(student.getStudUserName());
//		studentDto.setStudPassword(student.getStudPassword());
		return studentDto;
	}

}
