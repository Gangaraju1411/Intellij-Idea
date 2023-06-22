package com.mse.dto;



import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class InstituteDetailsDTO {

	@NotBlank(message = "Institute name is required")
	private String instituteName;

	@NotBlank(message = "Short name is required")
	@Size(min = 1, max = 45)
	private String shortName;

	@NotBlank
	@Email(message = "Invalid email address")
	private String emailId;

	@Pattern(regexp = "\\d{6}", message = "Invalid pincode")
	private String pincode;

	@NotBlank(message = "Affiliation number is required")
	private String affiliationNo;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Licence type is required")
	private String licenceType;

	@Future(message = "Licence expiry date must be in the future")
	private LocalDate licenceExpiryDate;

	@Pattern(regexp = "\\d{10}", message = "Invalid phone number")
	private String institutionPhoneNo;

	@Pattern(regexp = "\\d{3}", message = "Invalid speed dial")
	private String speedDial;

	//@Pattern(regexp = "\\d{10}", message = "Invalid fax number")
	private String fax;

	//@URL(message = "Invalid website URL")
	private String website;

	@NotBlank(message = "Contact person's first name is required")
	private String contactPersonFirstName;

	@NotBlank(message = "Contact person's last name is required")
	private String contactPersonLastName;

	@Pattern(regexp = "\\d{10}", message = "Invalid contact person phone number")
	private String contactPersonPhoneNo;

	@Email(message = "Invalid contact person email address")
	private String contactPersonEmail;

	private String directions;

	@DecimalMin(value = "-90", message = "Latitude must be between -90 and 90")
	@DecimalMax(value = "90", message = "Latitude must be between -90 and 90")
	private Double latitude;

	@DecimalMin(value = "-180", message = "Longitude must be between -180 and 180")
	@DecimalMax(value = "180", message = "Longitude must be between -180 and 180")
	private Double longitude;

	private String displayName;

	private String logoUrlId;

	private long instituteGroupId;
	

	private boolean isActive;

}
