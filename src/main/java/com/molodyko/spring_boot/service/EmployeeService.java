package com.molodyko.spring_boot.service;



import com.molodyko.spring_boot.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> findEmployeeByName(String name);
}
