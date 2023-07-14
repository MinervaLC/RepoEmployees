package com.mx.Employees.Dao;

import org.springframework.data.repository.CrudRepository;
import com.mx.Employees.Model.Employees;


public interface EmployeesDao extends CrudRepository<Employees, Integer>{

}
