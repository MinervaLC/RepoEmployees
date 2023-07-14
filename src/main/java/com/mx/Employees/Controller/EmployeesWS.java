package com.mx.Employees.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.Employees.Dao.EmployeesDao;
import com.mx.Employees.Model.Employees;
import com.mx.Employees.Servicio.EmployeesServImp;

//Estereotipos o anotaciones
@RestController
@RequestMapping("EmployeesWS")
@CrossOrigin
public class EmployeesWS {

	@Autowired
	EmployeesServImp employeesServImp;
	@Autowired
	EmployeesDao employeesDao;

	// URL: url del servidor local + path de la clase + path del metodo

	// Listar
	// http://localhost:9000/EmpleadosWS/listar
	@GetMapping("listar")
	public List<Employees> listar() {
		List<Employees> listaEmp = employeesServImp.listar();
		return listaEmp;
	}

	// Guardar
	// http://localhost:9000/EmpleadosWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Employees employees) {
		List<Employees> listaNom = (List<Employees>) employeesDao.findAll();
		// Validar si el empleado es mayor de edad
		LocalDate currentDate = LocalDate.now();
		LocalDate birthdat = employees.getBirthdate();
		int age = Period.between(birthdat, currentDate).getYears();

		List<Employees> listaEmpleados = (List<Employees>) employeesDao.findAll();
		List<String> nombreCompletos = new ArrayList<String>();

		for (Employees e : listaEmpleados) {
			String nombreCompleto = e.getName() + " " + e.getLast_name();
			nombreCompletos.add(nombreCompleto);
		}

		if (age > 18) {
			System.out.println(age);
			if (employees.getJobs() != null) {
				System.out.println(employees.getJobs());
				if (employees.getGenders() != null) {
					System.out.println(employees.getGenders());
					String nombreCompleto2 = employees.getName() + " " + employees.getLast_name();
					if (!nombreCompletos.contains(nombreCompleto2)) {
						employeesServImp.guardar(employees);
						return ResponseEntity.ok().body("Empleado guardado exitosamente");
					} else {
						System.out.println("Error en el nombre");
						return ResponseEntity.badRequest().body("El nombre indicado ya existe");
					}
				} else {
					System.out.println("Error den el genero");
					return ResponseEntity.badRequest().body("El ID de genero no existe");
				}

			} else {
				System.out.println("Error en el trabajo");
				return ResponseEntity.badRequest().body("El ID trabajo no existe");
			}
		}else {
			System.out.println("Error en la edad");
			return ResponseEntity.badRequest().body("El empleado debe ser mayor de edad");
		}
		
	}

	// Buscar
	// http://localhost:9000/EmpleadosWS/buscar
	@PostMapping("buscar")
	public Employees buscar(@RequestBody Employees employees) {
		return employeesServImp.buscar(employees);
	}

	// Editar
	// http://localhost:9000/EmpleadosWS/editar
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody Employees employees) {
		List<Employees> listaNom = (List<Employees>) employeesDao.findAll();
		// Validar si el empleado es mayor de edad
		LocalDate currentDate = LocalDate.now();
		LocalDate birthdat = employees.getBirthdate();
		int age = Period.between(birthdat, currentDate).getYears();

		List<Employees> listaEmpleados = (List<Employees>) employeesDao.findAll();
		List<String> nombreCompletos = new ArrayList<String>();

		for (Employees e : listaEmpleados) {
			String nombreCompleto = e.getName() + " " + e.getLast_name();
			nombreCompletos.add(nombreCompleto);
		}

		if (age > 18) {
			System.out.println(age);
			if (employees.getJobs() != null) {
				System.out.println(employees.getJobs());
				if (employees.getGenders() != null) {
					System.out.println(employees.getGenders());
					String nombreCompleto2 = employees.getName() + " " + employees.getLast_name();
					if (!nombreCompletos.contains(nombreCompleto2) || nombreCompleto2.equals(nombreCompleto2)) {
						employeesServImp.editar(employees);
						return ResponseEntity.ok().body("Empleado actualizado exitosamente");
					} else {
						System.out.println("Error en el nombre");
						return ResponseEntity.badRequest().body("El nombre indicado ya existe");
					}
				} else {
					System.out.println("Error den el genero");
					return ResponseEntity.badRequest().body("El ID de genero no existe");
				}

			} else {
				System.out.println("Error en el trabajo");
				return ResponseEntity.badRequest().body("El ID trabajo no existe");
			}
		}else {
			System.out.println("Error en la edad");
			return ResponseEntity.badRequest().body("El empleado debe ser mayor de edad");
		}
	}

	// Eliminar
	// http://localhost:9000/EmpleadosWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Employees employees) {
		employeesServImp.eliminar(employees);
	}

}
