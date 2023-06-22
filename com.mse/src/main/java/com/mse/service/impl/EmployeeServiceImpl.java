package com.mse.service.impl;


import com.mse.dto.EmployeeDetailsDTO;
import com.mse.entity.EmployeeEntity;
import com.mse.entity.InstituteEntity;
import com.mse.exception.NoEmployeeFoundException;
import com.mse.exception.NoInstituteFoundException;
import com.mse.mapper.AutoUserMapper;
import com.mse.projection.EmployeeProjection;
import com.mse.repo.EmployeeRepository;
import com.mse.repo.InstituteRepository;
import com.mse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private AutoUserMapper mapper = AutoUserMapper.MAPPER;

	@Autowired
	private EmployeeRepository emprepo;

	@Autowired
	private InstituteRepository instrepo;
	
	ProjectionFactory pf = new SpelAwareProxyProjectionFactory();


	@Override
	public List<EmployeeProjection> saveEmployee(List<EmployeeDetailsDTO> dto, Integer instituteId) {

		List<EmployeeEntity> lstOfEmployees = new ArrayList<>();

		for (EmployeeDetailsDTO dto1 : dto) {
			//BeanUtils.copyProperties(dto1, entity);

			EmployeeEntity employeeEntity = mapper.maptoEmpEntity(dto1);

			lstOfEmployees.add(employeeEntity);

		}

		Optional<InstituteEntity> instituteDetails = instrepo.findById(instituteId);
		if(instituteDetails.isPresent()) {
		   InstituteEntity instituteEntity = instituteDetails.get();
		  for (EmployeeEntity employeeEntity : lstOfEmployees) {
			employeeEntity.setActive(true);
			employeeEntity.setInstitute(instituteEntity);
		 }

		  List<EmployeeEntity> saveAll = emprepo.saveAllAndFlush(lstOfEmployees);

		  return lstOfEmployees.stream()
                .map(entity -> pf.createNullableProjection(EmployeeProjection.class,entity))
                .collect(Collectors.toList());
		
		
		
		}
		throw new NoInstituteFoundException("No institute is present with this id");
	}

	@Override
	public EmployeeProjection updateEmployee(EmployeeDetailsDTO dto, Integer instituteId,Integer employeeId) {

	
		Optional<InstituteEntity> findById2 = instrepo.findById(instituteId);
		
		if(findById2.isPresent()) {
		Optional<EmployeeEntity> findById = emprepo.findById(employeeId);
		if (findById.isPresent() && findById.get().getId() != null) {
			
		return 	pf.createNullableProjection(EmployeeProjection.class,findById.get());

			/*	EmployeeEntity employeeEntity = findById.get();
				BeanUtils.copyProperties(dto, employeeEntity);
				EmployeeEntity save = emprepo.save(employeeEntity);
				return dto;*/
			}
		
		throw new NoEmployeeFoundException("No one Employee is present with this id");
	}
		throw new NoInstituteFoundException("No institute is there with this id");
	}

	@Override
	public List<EmployeeProjection> getAllEmployees(Integer instituteId) {

		Optional<InstituteEntity> findById = instrepo.findById(instituteId);
		if (findById.isPresent() && findById.get().isActive() == true) {
			List<EmployeeEntity> employees = findById.get().getEmployees();
			List<EmployeeDetailsDTO> lstOfDto = new ArrayList<>();

			return employees.stream()
	                .map(entity -> pf.createNullableProjection(EmployeeProjection.class,entity))
	                .collect(Collectors.toList());
			
			
			
			
			
			/*for (EmployeeEntity entity : employees) {
				EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
				BeanUtils.copyProperties(entity, dto);
				lstOfDto.add(dto);
			}

			return lstOfDto;*/
			
			
		}

		throw new NoInstituteFoundException("No institute is present with this id");

	}

	@Override
	public EmployeeProjection getEmployee(Integer instituteId, Integer employeeId) {

		Optional<InstituteEntity> institute = instrepo.findById(instituteId);
		if (institute.isPresent() && institute.get().isActive() == true) {
			Optional<EmployeeEntity> employee = institute.get().getEmployees().stream()
					.filter(emp -> emp.getId() == (employeeId)).findFirst();

			if (employee.isPresent()) {
				
			return 	pf.createNullableProjection(EmployeeProjection.class,employee.get());
/*
				EmployeeDetailsDTO dto = new EmployeeDetailsDTO();

				BeanUtils.copyProperties(employee.get(), dto);

				return dto;*/

			} else
				throw new NoEmployeeFoundException("No employee is present with this employee id");

		} else
			throw new NoInstituteFoundException("No institute is present with this institute id");

	}

	@Override
	public void deleteEmployee(Integer instituteId, Integer employeeId) {

		Optional<InstituteEntity> institute = instrepo.findById(instituteId);
		if (institute.isPresent()) {

			Optional<EmployeeEntity> findFirst = institute.get().getEmployees().stream()
					.filter(emp -> emp.getId() == (employeeId)).findFirst();

			if (findFirst.isPresent()) {

				EmployeeEntity employeeEntity = findFirst.get();

				employeeEntity.setActive(false);

				emprepo.save(employeeEntity);

			} else

				throw new NoEmployeeFoundException("No employee is present with this employee id");

		} else

			throw new NoInstituteFoundException("No institute is present with this institute id");

	}

}
