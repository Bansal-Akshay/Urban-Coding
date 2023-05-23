package com.akshay.urbanCoding.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teacherId;
	
	@NotBlank(message="Name cannot be blank")
	private String teacherName;
	
	@Email(regexp = ".+@.+\\..+",message="Email is not valid")
	private String teacherEmail;
	
	@NotBlank(message="Username cannot be blank")
	private String teacherUserName;
	
	@NotBlank(message="Password cannot be blank")
	private String teacherPassword;
	
	@NotBlank(message="College cannot be blank")
	private String teacherCollege;
	
	@NotBlank(message="Contact cannot be blank")
	private String teacherContact;
}
