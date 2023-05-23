package com.akshay.urbanCoding.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akshay.urbanCoding.payloads.TeacherDto;

@Service
public interface TeacherService {
	TeacherDto createTeacher(TeacherDto teacher);
	TeacherDto updateTeacher(TeacherDto teacher,Integer teacherId);
	TeacherDto getTeacherById(Integer teacherId);
	List<TeacherDto> getAllTeachers();
	void deleteTeacher(Integer teacherId);
}
