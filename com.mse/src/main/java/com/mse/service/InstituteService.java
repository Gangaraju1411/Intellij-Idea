package com.mse.service;


import com.mse.dto.InstituteDetailsDTO;
import com.mse.projection.InstituteProjection;
import org.springframework.stereotype.Component;

@Component
public interface InstituteService {
	
	
	public InstituteProjection saveInstitute(InstituteDetailsDTO dto);
	
	
	public InstituteProjection get(Integer id);

	
	public InstituteProjection updateInstitute(InstituteDetailsDTO dto, Integer id);
	
	public void softDelete(Integer id);
	
	


}
