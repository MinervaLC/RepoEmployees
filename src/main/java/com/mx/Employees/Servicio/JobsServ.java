package com.mx.Employees.Servicio;

import java.util.List;
import com.mx.Employees.Model.Jobs;

public interface JobsServ {

	public void guardar(Jobs jobs);

	public void editar(Jobs jobs);

	public void eliminar(Jobs jobs);

	public Jobs buscar(Jobs jobs);

	public List<Jobs> listar();
}