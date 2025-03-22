package com.sathya.mvc.entity;

<<<<<<< HEAD
import java.time.LocalDateTime;  
=======
import java.time.LocalDateTime; 
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProductEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String name;
	private double price;
	private int quantity;
	private String brand;
	private String madein;
	private double taxamount;
	private double totalamount;
	private LocalDateTime createdAt;
	private String createdby;
	

}
