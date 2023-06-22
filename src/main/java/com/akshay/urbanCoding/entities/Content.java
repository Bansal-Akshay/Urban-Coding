package com.akshay.urbanCoding.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Content {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contentId;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher;
	
	private String dateAndTime;
	
	@NotBlank(message="Please provide type of content")
	private String contentType;
	
	
	private boolean paid;
	
	private int price;
	
	private int modelId;
	
	@NotBlank(message="Please provide title of content")
	private String contentTitle;
	
	@NotBlank(message="Please provide description of content")
	private String contentDescription;
	
	
	private String content;
	
	 @OneToMany(mappedBy="content")
	 List<Comment> commentsMade;
}
