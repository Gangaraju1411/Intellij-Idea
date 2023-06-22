package com.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductEntity {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
	    private String name;
	    private Double price;
	    private String description;
	    private String brand;
		private String store;
	    private Integer quantity;
	
	
}
