package com.akshay.urbanCoding.entities;

import java.util.List;
import java.util.concurrent.Flow.Subscription;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "subscriberStudentId")
	private Student student;
	
	@OneToOne
	@JoinColumn(name="subscription_id",referencedColumnName = "subscriptionId")
	private Subscription subscription;

	@OneToMany(mappedBy="teacher")
	private List<Content> contentList;
}
