package com.mx.Employees.Servicio;

import java.util.List;
import com.mx.Employees.Model.Employees;

public interface EmployeesServ {

	public void guardar(Employees employees);

	public void editar(Employees employees);

	public void eliminar(Employees employees);

	public Employees buscar(Employees employees);

	public List<Employees> listar();
}