package com.akshay.urbanCoding.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
}
