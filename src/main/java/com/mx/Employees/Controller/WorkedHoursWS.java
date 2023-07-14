package com.mx.Employees.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.Employees.Dao.EmployeesWHDao;
import com.mx.Employees.Model.EmployeesWH;
import com.mx.Employees.Servicio.EmployeesWHServImp;

//Estereotipos o anotaciones
@RestController
@RequestMapping("WorkedHoursWS")
@CrossOrigin
public class WorkedHoursWS {

	@Autowired
	EmployeesWHServImp employeesWHServImp;
	@Autowired
	EmployeesWHDao employeesWHDao;

	// URL: url del servidor local + path de la clase + path del metodo

	// Listar
	// http://localhost:9000/WorkedHoursWS/listar
	@GetMapping("listar")
	public List<EmployeesWH> listar() {
		List<EmployeesWH> listaEmp = employeesWHServImp.listar();
		return listaEmp;
	}

	// Guardar
	// http://localhost:9000/WorkedHoursWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody EmployeesWH employeesWH) {
		if (employeesWH.getEmployees() != null) {
			employeesWHServImp.guardar(employeesWH);
			return ResponseEntity.ok().body("Horas guardadas");
		}else {
			System.out.println("Error");
			return ResponseEntity.badRequest().body("No existen empleados");
		}
	}

	// Buscar
	// http://localhost:9000/WorkedHoursWS/buscar
	@PostMapping("buscar")
	public EmployeesWH buscar(@RequestBody EmployeesWH employeesWH) {
		return employeesWHServImp.buscar(employeesWH);
	}

	// Editar
	// http://localhost:9000/WorkedHoursWS/editar
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody EmployeesWH employeesWH) {
		if (employeesWH.getEmployees() != null) {
			employeesWHServImp.editar(employeesWH);
			return ResponseEntity.ok().body("Horas actualizadas");
		}else {
			System.out.println("Error");
			return ResponseEntity.badRequest().body("No existen empleados");
		}
	}

	// Eliminar
	// http://localhost:9000/WorkedHoursWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody EmployeesWH employeesWH) {
		employeesWHServImp.eliminar(employeesWH);
	}

}
