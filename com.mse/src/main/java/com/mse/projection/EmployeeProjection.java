package com.mse.projection;



public interface EmployeeProjection {

	
	Integer getId();
	
	String getEmployeeCode();
	
	String getEmployeeName();
	
	 String getPersonalEmailId();
	
	 String getContactNo();
	 
	 String getDepartment();
	 
	 
	 InstituteProjection getInstitute();
	 
	 interface InstituteProjection {

			String getInstituteName();
			
			String getAddress();
			
			String getInstitutionPhoneNo();
			
			boolean getIsActive();
			
	 }
	
	
}
