package com.akshay.urbanCoding.payloads;

import java.util.List;

import com.akshay.urbanCoding.entities.Content;
import com.akshay.urbanCoding.entities.Subscription;

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
	private Subscription subscription;
	private List<Content> contentList;
}
