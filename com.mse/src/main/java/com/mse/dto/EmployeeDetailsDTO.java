package com.mse.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDetailsDTO {


   
    @NotBlank(message = "Employee code is required")
    private String employeeCode;

    @NotBlank(message = "Salutation is required")
    private String salutation;

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @NotBlank(message = "Father/Husband name is required")
    private String fatherHusbandName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotNull
    @PastOrPresent(message = "Date of joining must be in the past or present")
    private LocalDate doj;

    @NotBlank(message = "Aadhar number is required")
    private String aadharNo;

    @Email(message = "Personal email ID is not valid")
    private String personalEmailId;

    @Pattern(regexp = "\\d{10}", message = "Invalid work phone number")
    private String workPhoneNo;

    @Pattern(regexp = "\\d{10}", message = "Invalid contact number")
    private String contactNo;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "Religion is required")
    private String religion;

    @NotBlank(message = "Caste is required")
    private String caste;

    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @NotBlank(message = "Identification mark 1 is required")
    private String identificationMark1;

    @NotBlank(message = "Identification mark 2 is required")
    private String identificationMark2;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotBlank(message = "University is required")
    private String university;

    @Min(value = 1900, message = "Passout year must be greater than or equal to 1900")
    private int passoutYear;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    private String otherAchievements;

    @NotBlank(message = "Marital status is required")
    private String martialStatus;

    private String marriageCertificateNo;

    private LocalDate marriageCertificateDor;

    @NotBlank(message = "Emergency contact person is required")
    private String emergencyContactPerson;

    //to know about this regex
    @Pattern(regexp = "\\d{10}", message = "Invalid emergency contact number")
    private String emergencyContactNo;

    @Email(message = "Work email ID is not valid")
    private String workEmailId;

    @NotBlank(message = "Work location is required")
    private String workLocation;

    @NotBlank(message = "Employee type is required")
    private String employeeType;

    @NotBlank(message = "Department is required")
    private String department;

    private LocalDate confirmationDate;

    @NotBlank(message = "Source of hire is required")
    private String sourceOfHire;

    @Min(value = 0, message = "DPS experience must be greater than or equal to 0")
    private int dpsExperience;

    private Integer employeeFullImage;

    private boolean isTransferred;

    private Integer employeeThumbImage;
	
	
}
