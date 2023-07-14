package com.mx.Employees.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.Employees.Model.Jobs;
import com.mx.Employees.Servicio.JobsServImp;

//Estereotipos o anotaciones
@RestController
@RequestMapping("JobsWS")
@CrossOrigin
public class JobsWS {

	@Autowired
	JobsServImp JobsServImp;

	// URL: url del servidor local + path de la clase + path del metodo

	// Listar
	// http://localhost:9000/EmpleadosWS/listar
	@GetMapping("listar")
	public List<Jobs> listar() {
		List<Jobs> listaEmp = JobsServImp.listar();
		return listaEmp;
	}

	// Guardar
	// http://localhost:9000/EmpleadosWS/guardar
	@PostMapping("guardar")
	public void guardar(@RequestBody Jobs jobs) {
		JobsServImp.guardar(jobs);
	}

	// Buscar
	// http://localhost:9000/EmpleadosWS/buscar
	@PostMapping("buscar")
	public Jobs buscar(@RequestBody Jobs jobs) {
		return JobsServImp.buscar(jobs);
	}

	// Editar
	// http://localhost:9000/EmpleadosWS/editar
	@PostMapping("editar")
	public void editar(@RequestBody Jobs jobs) {
		JobsServImp.editar(jobs);
	}

	// Eliminar
	// http://localhost:9000/EmpleadosWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Jobs jobs) {
		JobsServImp.eliminar(jobs);
	}

}
