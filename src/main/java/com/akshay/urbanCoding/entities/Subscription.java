package com.akshay.urbanCoding.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Subscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subscriptionId;
	
	private int price;
	
	private int validity;
	
    private LocalDate startDate;
	
	private LocalDate endDate;
	
	@OneToOne(mappedBy="subscription")
	private Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name="modelId")
	private Model model;
}
