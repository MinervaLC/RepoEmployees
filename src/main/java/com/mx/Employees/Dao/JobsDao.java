package com.mx.Employees.Dao;

import org.springframework.data.repository.CrudRepository;
import com.mx.Employees.Model.Jobs;


public interface JobsDao extends CrudRepository<Jobs, Integer>{

}
