package com.dep;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.validation.annotation.Validated;
//import jakarta.validation.valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

@CrossOrigin(origins="http://localhost:3000")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	// Greeting Endpoint 
    @GetMapping("/hello")
	public String greet() {
		return "Hello World from Department Rest API... ";
    }

    // End Point Save operation  in REST API
    @PostMapping("/departments")
    public Department saveDepartment(
       @Validated        
       @RequestBody 
       Department department)
    {
        return departmentService.saveDepartment(department);
    }
    
    // End Point for Read operation  in REST API
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    } 
    
    // End Point for Update operation in REST API
    //@PutMapping("/departments/{id}")
    @PutMapping("/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
            department, departmentId);
    }

    // End Point for Delete operation in REST API
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id")   Long departmentId)
    {
        departmentService.deleteDepartmentById(
            departmentId);
        return "Deleted Successfully";
    }


}
