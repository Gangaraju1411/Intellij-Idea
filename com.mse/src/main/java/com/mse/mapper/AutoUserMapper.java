package com.mse.mapper;


import com.mse.dto.EmployeeDetailsDTO;
import com.mse.dto.InstituteDetailsDTO;
import com.mse.entity.EmployeeEntity;
import com.mse.entity.InstituteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	InstituteDetailsDTO mapToDTO(InstituteEntity entity);
	InstituteEntity mapToInstituteEntity(InstituteDetailsDTO dto);
	EmployeeEntity maptoEmpEntity(EmployeeDetailsDTO dto);
	List<EmployeeEntity> mapToEmpEntity(List<EmployeeDetailsDTO> dto);

}
