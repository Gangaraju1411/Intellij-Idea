package com.mse.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@javax.persistence.Entity
@Data
@EqualsAndHashCode(callSuper=false)
@ToString
@Table(name = "mse_institute_details")
public class InstituteEntity extends BaseEntity {

	@Column(name = "Institute_name")
	private String instituteName;

	@Column(name = "Short_name")
	private String shortName;

	@Column(name = "Email_id")
	private String emailId;

	private String pincode;
	private String affiliationNo;
	private String address;
	private String licenceType;
	private LocalDate licenceExpiryDate;
	private String institutionPhoneNo;
	private String speedDial;
	private String fax;
	private String website;
	private String contactPersonFirstName;
	private String contactPersonLastName;

	@Column(name = "Contact_person_Phone_no")
	private String contactPersonPhoneNo;
	private String contactPersonEmail;
	private String directions;
	private double latitude;
	private double longitude;
	private String displayName;
	private String logoUrlId;
	private long instituteGroupId;

	@Column(name = "is_Active")
	private boolean isActive;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "institute", orphanRemoval = true,fetch= FetchType.EAGER)
	private List<EmployeeEntity> employees;
	
	
	
	

}
