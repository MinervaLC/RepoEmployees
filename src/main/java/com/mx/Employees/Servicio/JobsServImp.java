package com.mx.Employees.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mx.Employees.Dao.JobsDao;
import com.mx.Employees.Model.Jobs;

@Service
public class JobsServImp implements JobsServ {

	// Inyeccion de dependencia
	@Autowired
	JobsDao jobsDao;

	@Override
	public void guardar(Jobs jobs) {
		jobsDao.save(jobs);
	}

	@Override
	public void editar(Jobs jobs) {
		jobsDao.save(jobs);
	}

	@Override
	public void eliminar(Jobs jobs) {
		jobsDao.delete(jobs);
	}

	@Override
	public Jobs buscar(Jobs jobs) {
		return jobsDao.findById(jobs.getId()).orElse(null);
	}

	@Override
	public List<Jobs> listar() {
		return (List<Jobs>) jobsDao.findAll();
	}

	@Transactional(readOnly = true)
	public Jobs buscarXN(String nombre) {
		Jobs e = new Jobs();
		for (Jobs es : jobsDao.findAll()) {
			if (es.getName().equals(nombre)) {
				e = es;
			}
		}
		return e;
	}
}
