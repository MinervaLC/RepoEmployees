package com.mx.Employees.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.Employees.Model.Genders;
import com.mx.Employees.Servicio.GendersServImp;

//Estereotipos o anotaciones
@RestController
@RequestMapping("GendersWS")
@CrossOrigin
public class GendersWS {

	@Autowired
	GendersServImp gendersServImp;

	// URL: url del servidor local + path de la clase + path del metodo

	// Listar
	// http://localhost:9000/GendersWS/listar
	@GetMapping("listar")
	public List<Genders> listar() {
		List<Genders> listaEmp = gendersServImp.listar();
		return listaEmp;
	}

	// Guardar
	// http://localhost:9000/EmpleadosWS/guardar
	@PostMapping("guardar")
	public void guardar(@RequestBody Genders genders) {
		gendersServImp.guardar(genders);
	}

	// Buscar
	// http://localhost:9000/EmpleadosWS/buscar
	@PostMapping("buscar")
	public Genders buscar(@RequestBody Genders genders) {
		return gendersServImp.buscar(genders);
	}

	// Editar
	// http://localhost:9000/EmpleadosWS/editar
	@PostMapping("editar")
	public void editar(@RequestBody Genders genders) {
		gendersServImp.editar(genders);
	}

	// Eliminar
	// http://localhost:9000/EmpleadosWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Genders genders) {
		gendersServImp.eliminar(genders);
	}

}
