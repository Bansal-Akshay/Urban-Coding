package com.akshay.urbanCoding.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studId;
	
	@NotBlank(message="Name cannot be blank")
	private String studName;
	
	@Email(regexp = ".+@.+\\..+",message="Email is not valid")
	private String studEmail;
	
	@NotBlank(message="Username cannot be blank")
	private String studUserName;
	
	@NotBlank(message="Password cannot be blank")
	private String studPassword;
	
	@NotBlank(message="College cannot be blank")
	private String studCollege;
	
	@NotBlank(message="Contact cannot be blank")
	private String studContact;
	
	 @OneToMany(mappedBy="student")
//	 @JoinColumn(name = "teacherId")
	List<Teacher> subscribedPaidTeacher;
	 
//	 @ManyToOne
//	 @JoinColumn(name = "commentId")
//	List<Comment> commentsMade;
//	
	
}
