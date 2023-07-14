package com.mx.Employees.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.Employees.Dao.EmployeesWHDao;
import com.mx.Employees.Model.EmployeesWH;

@Service
public class EmployeesWHServImp implements EmployeesWHServ {

	// Inyeccion de dependencia
	@Autowired
	EmployeesWHDao employeesWHDao;

	@Override
	public void guardar(EmployeesWH employeesWH) {
		employeesWHDao.save(employeesWH);
	}

	@Override
	public void editar(EmployeesWH employeesWH) {
		employeesWHDao.save(employeesWH);
	}

	@Override
	public void eliminar(EmployeesWH employeesWH) {
		employeesWHDao.delete(employeesWH);
	}

	@Override
	public EmployeesWH buscar(EmployeesWH employeesWH) {
		return employeesWHDao.findById(employeesWH.getId()).orElse(null);
	}

	@Override
	public List<EmployeesWH> listar() {
		return (List<EmployeesWH>) employeesWHDao.findAll();
	}
}
