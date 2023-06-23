package com.akshay.urbanCoding.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
	@ManyToMany
	@JoinTable(
			  name = "cart_content", 
			  joinColumns = @JoinColumn(name = "cart_id"), 
			  inverseJoinColumns = @JoinColumn(name = "content_id"))
	private List<Content> courses;
	
	@OneToOne(mappedBy="cart")
	private Student student;
	
	
}
