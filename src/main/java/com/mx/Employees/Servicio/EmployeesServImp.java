package com.mx.Employees.Servicio;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.Employees.Dao.EmployeesDao;
import com.mx.Employees.Model.Employees;

@Service
public class EmployeesServImp implements EmployeesServ {

	// Inyeccion de dependencia
	@Autowired
	EmployeesDao employeesDao;

	@Override
	public void guardar(Employees employees) {
		employeesDao.save(employees);
	}

	@Override
	public void editar(Employees employees) {
		employeesDao.save(employees);
	}

	@Override
	public void eliminar(Employees employees) {
		employeesDao.delete(employees);
	}

	@Override
	public Employees buscar(Employees employees) {
		return employeesDao.findById(employees.getId()).orElse(null);
	}

	@Override
	public List<Employees> listar() {
		return (List<Employees>) employeesDao.findAll();
	}

}
