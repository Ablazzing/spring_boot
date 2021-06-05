package com.molodyko.spring_boot.service;

import com.molodyko.spring_boot.DAO.EmployeeDAO;
import com.molodyko.spring_boot.Entity.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> optional = employeeDAO.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
    }

    @Override
    public List<Employee> findEmployeeByName(String name){
        return employeeDAO.findEmployeeByName(name);
    };
}
