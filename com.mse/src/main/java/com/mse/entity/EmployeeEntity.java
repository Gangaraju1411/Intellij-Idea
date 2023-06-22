package com.mse.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@javax.persistence.Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ToString
@javax.persistence.Table(name="mse_employee_details")
public class EmployeeEntity extends BaseEntity {

	private String employeeCode;
	private String salutation;
	private String employeeName;
	private String fatherHusbandName;
	private String gender;
	private LocalDate dob;
	private LocalDate doj;
	private String aadharNo;
	private String personalEmailId;
	private String workPhoneNo;
	private String contactNo;
	private String nationality;
	private String religion;
	private String caste;
	private String bloodGroup;
	private String identificationMark1;
	private String identificationMark2;
	private String qualification;
	private String university;
	private int passoutYear;
	private String specialization;
	private String otherAchievements;
	private String martialStatus;
	private String marriageCertificateNo;
	private LocalDate marriageCertificateDor;
	private String emergencyContactPerson;
	private String emergencyContactNo;
	private String workEmailId;
	private String workLocation;
	private String employeeType;
	private String department;
	private LocalDate confirmationDate;
	private String sourceOfHire;
	private int dpsExperience;
	private Integer employeeFullImage;
	private boolean isTransferred;
	private Integer employeeThumbImage;
	private boolean isActive;
	private String modifiedBy;
	
	@ManyToOne(cascade= {CascadeType.MERGE})//CascadeType.PERSIST,
	@JoinColumn(name ="institute_id")
	private InstituteEntity institute;
	
	

}
