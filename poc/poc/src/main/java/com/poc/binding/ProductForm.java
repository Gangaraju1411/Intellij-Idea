package com.poc.binding;

import lombok.Data;

@Data
public class ProductForm {
	
	private String name;
    private Double price;
    private String description;
    private String brand;
    private String store;
    private Integer quantity;


}
