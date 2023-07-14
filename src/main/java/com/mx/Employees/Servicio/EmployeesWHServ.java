package com.mx.Employees.Servicio;

import java.util.List;
import com.mx.Employees.Model.EmployeesWH;

public interface EmployeesWHServ {

	public void guardar(EmployeesWH employeesWH);

	public void editar(EmployeesWH employeesWH);

	public void eliminar(EmployeesWH employeesWH);

	public EmployeesWH buscar(EmployeesWH employeesWH);

	public List<EmployeesWH> listar();
}
