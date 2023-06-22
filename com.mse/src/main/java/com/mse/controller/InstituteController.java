package com.mse.controller;


import com.mse.dto.InstituteDetailsDTO;
import com.mse.projection.InstituteProjection;
import com.mse.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InstituteController {
	@Autowired
	private InstituteService service;

	@PostMapping("/institute/save")
	public ResponseEntity<InstituteProjection> saveInstitute(@Valid @RequestBody InstituteDetailsDTO dto) {

	 InstituteProjection saveInstitute = service.saveInstitute(dto);
		return ResponseEntity.ok(saveInstitute);

	}

	@PutMapping("/institute/update/{id}")
	public ResponseEntity<InstituteProjection> updateInstitute(@Valid @RequestBody InstituteDetailsDTO dto,
			@PathVariable Integer id) {

		InstituteProjection updateInstitute = service.updateInstitute(dto, id);
		return ResponseEntity.ok(updateInstitute);
	}

	@GetMapping("/institute/getinst/{instId}")
	public ResponseEntity<InstituteProjection> getEmployee(@PathVariable("instId") Integer instituteId) {
		 InstituteProjection instituteProjection = service.get(instituteId);
		return ResponseEntity.ok(instituteProjection);
	}

	@PostMapping("/institute/softdelete/{id}")
	public ResponseEntity<Void> deleteInstitute(@PathVariable Integer id) {
		service.softDelete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
