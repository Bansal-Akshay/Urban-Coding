package com.akshay.urbanCoding.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.urbanCoding.dao.TeacherRepo;
import com.akshay.urbanCoding.entities.Teacher;
import com.akshay.urbanCoding.exceptions.ResourceNotFoundException;
import com.akshay.urbanCoding.payloads.TeacherDto;
import com.akshay.urbanCoding.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		Teacher teacher=this.dtoToTeacher(teacherDto);
		Teacher savedTeacher=this.teacherRepo.save(teacher);
		return this.teacherToDto(savedTeacher);
//		return teacher;
	}

	@Override
	public TeacherDto updateTeacher(TeacherDto teacherDto, Integer teacherId) {
//		Teacher teacher=this.dtoToTeacher(teacherDto);
		Teacher teacher=this.teacherRepo.findById(teacherId).orElseThrow((()-> new ResourceNotFoundException("Teacher","Teacher id ",teacherId)));
		teacher.setTeacherCollege(teacherDto.getTeacherCollege());
		teacher.setTeacherContact(teacherDto.getTeacherContact());
		teacher.setTeacherEmail(teacherDto.getTeacherEmail());
//		teacher.setTeacherId(oldTeacher.getTeacherId());
		teacher.setTeacherName(teacherDto.getTeacherName());
		teacher.setTeacherPassword(teacherDto.getTeacherPassword());
		teacher.setTeacherUserName(teacherDto.getTeacherUserName());
		Teacher savedTeacher=this.teacherRepo.save(teacher);
		return this.teacherToDto(savedTeacher);
	}

	@Override
	public TeacherDto getTeacherById(Integer teacherId) {
		Teacher teacher=this.teacherRepo.findById(teacherId).orElseThrow((()-> new ResourceNotFoundException("Teacher","Teacher id ",teacherId)));
		return this.teacherToDto(teacher);
	}

	@Override
	public List<TeacherDto> getAllTeachers() {
		List<TeacherDto> teacherDtoList=this.teacherRepo.findAll().stream().map(teacher-> this.teacherToDto(teacher)).collect(Collectors.toList());
		return teacherDtoList;
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		this.teacherRepo.deleteById(teacherId);
	}
	
	public Teacher dtoToTeacher(TeacherDto teacherDto) {
		Teacher teacher=this.modelMapper.map(teacherDto,Teacher.class);
		return teacher;
	}
	
	public TeacherDto teacherToDto(Teacher teacher) {
		TeacherDto teacherDto=this.modelMapper.map(teacher,TeacherDto.class);
		return teacherDto;
	}
	
}
