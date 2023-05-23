package com.akshay.urbanCoding.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	
	
	private int studentId;
	
	
	private int contentId;
	
	@NotBlank(message="Comment cannot be blank")
	private String comment;
	
	
	private String dateAndTime;
	
}
