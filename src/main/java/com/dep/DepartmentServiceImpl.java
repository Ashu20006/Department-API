package com.dep;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
    private DepartmentRespository departmentRepository ;
 
    // Save operation
	@Override
	public Department saveDepartment(Department department) {
		
		return (Department) departmentRepository.save(department);
	}

	// Read or select Operations
	@Override
	public List<Department> fetchDepartmentList() {
		
		return (List<Department>)
	            departmentRepository.findAll();

	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		
		Department depDB
        = (Department) departmentRepository.findById(departmentId).get();

    if (Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(
            (String) department.getDepartmentName())) {
        depDB.setDepartmentName(
            department.getDepartmentName());
    }

    if (Objects.nonNull(
            department.getDepartmentAddress())
        && !"".equalsIgnoreCase(
            department.getDepartmentAddress())) {
        depDB.setDepartmentAddress(
            department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode())
        && !"".equalsIgnoreCase(
            department.getDepartmentCode())) {
        depDB.setDepartmentCode(
            department.getDepartmentCode());
    }

    return (Department) departmentRepository.save(depDB);

	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		
        departmentRepository.deleteById(departmentId);
		
	}
	
	
}

	

