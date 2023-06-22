package com.mse.service;


import com.mse.dto.EmployeeDetailsDTO;
import com.mse.projection.EmployeeProjection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
	
	
	//public List<EmployeeDetailsDTO> saveEmployee(List<EmployeeDetailsDTO> dto,Integer instituteId);
	
	public List<EmployeeProjection> saveEmployee(List<EmployeeDetailsDTO> dto, Integer instituteId);

	
	//public EmployeeDetailsDTO updateEmployee(EmployeeDetailsDTO dto, Integer instituteId, Integer employeeId);
	
	public EmployeeProjection updateEmployee(EmployeeDetailsDTO dto, Integer instituteId, Integer employeeId);

	
	
	public EmployeeProjection getEmployee(Integer instituteId,Integer employeeId);
	
	public List<EmployeeProjection> getAllEmployees(Integer instituteId);
	
	public void  deleteEmployee(Integer instituteId,Integer employeeId);


	
	

}
