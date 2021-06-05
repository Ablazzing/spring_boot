package com.molodyko.spring_boot.DAO;




import com.molodyko.spring_boot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
    List<Employee> findEmployeeByName(String name);

}
