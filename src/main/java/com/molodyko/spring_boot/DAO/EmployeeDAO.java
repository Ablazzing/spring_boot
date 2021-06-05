package com.molodyko.spring_boot.DAO;




import com.molodyko.spring_boot.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
