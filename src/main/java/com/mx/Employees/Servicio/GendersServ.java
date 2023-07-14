package com.mx.Employees.Servicio;

import java.util.List;
import com.mx.Employees.Model.Genders;

public interface GendersServ {

	public void guardar(Genders genders);

	public void editar(Genders genders);

	public void eliminar(Genders genders);

	public Genders buscar(Genders genders);

	public List<Genders> listar();
}
