package com.akshay.urbanCoding.payloads;

import lombok.Data;

@Data
public class TeacherDto {
	private int teacherId;
	private String teacherName;
	private String teacherEmail;
	private String teacherUserName;
	private String teacherPassword;
	private String teacherCollege;
	private String teacherContact;
}
