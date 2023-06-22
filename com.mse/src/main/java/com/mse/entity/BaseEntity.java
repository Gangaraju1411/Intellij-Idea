package com.mse.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public  class BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	@CreationTimestamp
	protected LocalDate createdDate;
	
	@UpdateTimestamp
	protected LocalDate modifiedDate;
	
	
	protected LocalDate deletedDate; //soft delete

}
