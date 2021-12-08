package com.example.assignment8.controller;

import java.text.ParseException;
import java.util.List;
import java.util.function.Function;

import com.example.assignment8.dto.departmentDTO.AccountDTO;
import com.example.assignment8.dto.departmentDTO.DetailDepartmentDTO;
import com.example.assignment8.form.Department.DepartmentFormFilter;
import com.example.assignment8.form.Department.DepartmentFormForCreating;
import com.example.assignment8.form.Department.DepartmentFormForUpdating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.assignment8.dto.departmentDTO.DepartmentDTO;
import com.example.assignment8.entity.Department;
import com.example.assignment8.service.Department.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "*")

public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments( Pageable pageable,
												@RequestParam(required = false) String search,
												DepartmentFormFilter departmentFormFilter) throws ParseException {
		Page<Department> departments = service.getAllDepartments(pageable, search, departmentFormFilter);

		Page<DepartmentDTO> departmentDTOS = departments.map(new Function<Department, DepartmentDTO>() {
			@Override
			public DepartmentDTO apply(Department department) {
				DepartmentDTO departmentDTO = new DepartmentDTO(
						department.getId(),
						department.getName(),
						new AccountDTO(
								department.getAuthor().getId(),
								department.getAuthor().getFullName()),
						department.getCreateDate());
				return departmentDTO;
			}
		});
		return new ResponseEntity<>(departmentDTOS,  HttpStatus.OK);
	};

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		Department department = service.getDepartmentByID(id);
		DetailDepartmentDTO dto = new DetailDepartmentDTO(
				department.getId(),
				department.getName(),
				new AccountDTO(
						department.getAuthor().getId(),
						department.getAuthor().getFullName()),
					department.getCreateDate());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}/exists")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>( service.isDepartmentExistsByName(name), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		service.createDepartment(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentFormForUpdating form) {
		service.updateDepartment(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	@DeleteMapping
	public void deleteDepartments (@RequestParam(name = "ids") List<Short> ids){
		service.deleteDepartments(ids);
	}
}
