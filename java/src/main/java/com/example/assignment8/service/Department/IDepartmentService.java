package com.example.assignment8.service.Department;

import java.text.ParseException;
import java.util.List;

import com.example.assignment8.entity.Department;
import com.example.assignment8.form.Department.DepartmentFormFilter;
import com.example.assignment8.form.Department.DepartmentFormForCreating;
import com.example.assignment8.form.Department.DepartmentFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFormFilter departmentFormFilter ) throws ParseException;

	public Department getDepartmentByID(short id);

	public Department getDepartmentByName(String name);

	public void createDepartment(DepartmentFormForCreating form);

	public void updateDepartment(short id, DepartmentFormForUpdating form);

	public  void deleteDepartments(List<Short> ids);

	public void deleteDepartment(short id);

	public boolean isDepartmentExistsByID(short id);

	public boolean isDepartmentExistsByName(String name);



}
