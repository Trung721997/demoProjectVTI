package com.example.assignment8.service.Department;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.assignment8.Specification.DepartmentSpecification;
import com.example.assignment8.entity.Account;
import com.example.assignment8.form.Department.DepartmentFormFilter;
import com.example.assignment8.form.Department.DepartmentFormForUpdating;
import com.example.assignment8.repository.IAccountRepository;
import com.example.assignment8.form.Department.DepartmentFormForCreating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.assignment8.entity.Department;
import com.example.assignment8.repository.IDepartmentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFormFilter departmentFormFilter) throws ParseException {
		Specification<Department> where = null;
		if (!StringUtils.isEmpty(search)) {
			DepartmentSpecification nameSpecification = new DepartmentSpecification("name", "LIKE", search);
			DepartmentSpecification authorSpecification = new DepartmentSpecification("author.fullName", "LIKE", search);
			DepartmentSpecification addressSpecification = new DepartmentSpecification("name", "address", search);
			DepartmentSpecification accountSpecification = new DepartmentSpecification("name", "author", search);

			where = Specification.where(nameSpecification).or(authorSpecification).or(addressSpecification).or(accountSpecification);
		}
		if (departmentFormFilter != null && departmentFormFilter.getMinDate() != null){
			DepartmentSpecification minSpecification = new DepartmentSpecification("createDate", ">=", departmentFormFilter.getMinDate());
			if (where == null){
				where = Specification.where(minSpecification);
			}else {
				where = where.and(minSpecification);
			}
		}
		if (departmentFormFilter != null && departmentFormFilter.getMaxDate() != null){
			DepartmentSpecification maxSpecification = new DepartmentSpecification("createDate", "<=", departmentFormFilter.getMaxDate());
			if (where == null){
				where = Specification.where(maxSpecification);
			}else {
				where = where.and(maxSpecification);
			}
		}
		if (departmentFormFilter != null && departmentFormFilter.getMinYear() != null){
			Date minYearDate = new SimpleDateFormat("yyyy-MM-dd").parse(departmentFormFilter.getMinYear()+ "-01-01");
			DepartmentSpecification minYaer = new DepartmentSpecification("createDate", ">=", minYearDate);
			if (where == null){
				where = Specification.where(minYaer);
			} else {
				where = where.and(minYaer);
			}
		}
		return departmentRepository.findAll(where,pageable);
	}

	@Override
	public Department getDepartmentByID(short id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String nam) {
		return departmentRepository.findByName(nam);
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		Account author = accountRepository.findById(form.getAuthorId());
		Department department = new Department(form.getName());
		department.setAuthor(author);
		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(short id, DepartmentFormForUpdating form) {
		Department department = getDepartmentByID(id);
		department.setName(form.getName());
		department.setModifiedDate(new Date());
		departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public  void deleteDepartments(List<Short> ids){
		departmentRepository.deleteByIds(ids);
	}

	@Override
	public boolean isDepartmentExistsByID(short id) {
		return departmentRepository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		return departmentRepository.existsByName(name);
	}





}
