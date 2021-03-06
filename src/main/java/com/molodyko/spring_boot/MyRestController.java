package com.molodyko.spring_boot;




import com.molodyko.spring_boot.Entity.Employee;
import com.molodyko.spring_boot.exception_handler.NoSuchEmployee;
import com.molodyko.spring_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployee("employee with this id "+id + " is not exist yeah!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "success";
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee){
        if (employee.getId()==0){
            throw new NoSuchEmployee("Request body has not employee.id for update");
        }
        employeeService.saveEmployee(employee);
        return "success";
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employeeForDelete = employeeService.getEmployee(id);
        if (employeeForDelete==null){
            throw new NoSuchEmployee("The employee with id "+id+" not found ");
        }
        employeeService.deleteEmployee(employeeForDelete);

        return "success";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> findEmployeesByName(@PathVariable String name){
        List<Employee> employees = employeeService.findEmployeeByName(name);
        if (employees.size()==0){
            throw new NoSuchEmployee("The employees with name "+name+" are not found ");
        }
        return employees;
    }


}
