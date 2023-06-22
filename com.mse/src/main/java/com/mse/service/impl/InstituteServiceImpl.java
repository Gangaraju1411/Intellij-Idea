package com.mse.service.impl;


import com.mse.dto.InstituteDetailsDTO;
import com.mse.entity.InstituteEntity;
import com.mse.exception.NoInstituteFoundException;
import com.mse.projection.InstituteProjection;
import com.mse.repo.InstituteRepository;
import com.mse.service.InstituteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituteServiceImpl implements InstituteService {

	@Autowired
	private InstituteRepository instituteRepo;
	
	ProjectionFactory pf = new SpelAwareProxyProjectionFactory();


	@Override
	public InstituteProjection saveInstitute(InstituteDetailsDTO dto) {
		InstituteEntity entity = new InstituteEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActive(true);
	 InstituteEntity save = instituteRepo.save(entity);
	 return pf.createNullableProjection(InstituteProjection.class, save);
	}
	
	
	@Override
	public
	InstituteProjection updateInstitute(InstituteDetailsDTO dto, Integer id) {
		Optional<InstituteEntity> findById = instituteRepo.findById(id);

		if (findById != null) {
			if (findById.get().isActive()) {
				InstituteEntity instituteEntity = findById.get();
				BeanUtils.copyProperties(dto, instituteEntity);
				InstituteEntity updatedInstitute = instituteRepo.save(instituteEntity);
				return pf.createNullableProjection(InstituteProjection.class,updatedInstitute);
			}
		}

		throw new NoInstituteFoundException("No institute is found with this id");
	}

	@Override
	public InstituteProjection get(Integer instituteId) {
		InstituteEntity instituteEntity = instituteRepo.findById(instituteId).orElseThrow( () -> new NoInstituteFoundException("No institute is found with this id"));
		return pf.createNullableProjection(InstituteProjection.class,instituteEntity);
	}

	public void softDelete(Integer id) {
		Optional<InstituteEntity> findById = instituteRepo.findById(id);
		if (findById.isPresent()) {
			if (findById.get().isActive()==false) {
				throw new NoInstituteFoundException("No Institue is found with this id");
			} else {
				InstituteEntity instituteEntity = findById.get();
				instituteEntity.setActive(false);
				instituteRepo.save(instituteEntity);
			}
		} else
			throw new NoInstituteFoundException("No Institue Found");

	}
}
