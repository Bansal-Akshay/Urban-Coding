package com.akshay.urbanCoding.entities;

import java.util.List;
//import java.util.concurrent.Flow.Subscription;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Model {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int modelId;
	
	private String modelName;
	
	private int modelPrice;
	
	private int validity; // in number of days
	
	@OneToMany(mappedBy="model")
	private List<Subscription> subscription; 
}
