package com.akshay.urbanCoding.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="cart_id",referencedColumnName = "cartId")
	private Cart cart;

	 @ManyToMany(cascade = { CascadeType.ALL })
	 @JsonInclude(JsonInclude.Include.NON_NULL)
	 @JoinTable(
			  name = "student_teacher", 
			  joinColumns = @JoinColumn(name = "student_id"), 
			  inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	List<Teacher> subscribedPaidTeacher;
	 
	@OneToMany(mappedBy="student",cascade = { CascadeType.ALL })
	List<Comment> commentsMade;
 
}
