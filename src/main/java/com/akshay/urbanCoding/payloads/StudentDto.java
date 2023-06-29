package com.akshay.urbanCoding.payloads;

import java.util.List;

import com.akshay.urbanCoding.entities.Cart;
import com.akshay.urbanCoding.entities.Comment;
import com.akshay.urbanCoding.entities.Teacher;

import lombok.Data;

@Data
//@Getter
//@Setter
//@NoArgsConstructor
public class StudentDto {
	private int studId;
	private String studName;
	private String studEmail;
	private String studUserName;
	private String studPassword;
	private String studCollege;
	private String studContact;
	private List<Teacher> subscribedPaidTeacher;
	private Cart cart;
	private List<Comment> commentsMade;
}
