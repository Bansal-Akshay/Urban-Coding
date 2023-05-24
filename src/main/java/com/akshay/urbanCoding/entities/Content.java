//package com.akshay.urbanCoding.entities;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Data;
//
//@Data
//@Entity
//public class Content {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int contentId;
//	
//	private int teacherId;
//	
//	private String dateAndTime;
//	
//	@NotBlank(message="Please provide type of content")
//	private String contentType;
//	
//	
//	private boolean paid;
//	
//	
//	private int modelId;
//	
//	@NotBlank(message="Please provide title of content")
//	private String contentTitle;
//	
//	@NotBlank(message="Please provide description of content")
//	private String contentDescription;
//	
//	
//	private String content;
//}
