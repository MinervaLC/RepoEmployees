package com.mx.Employees.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Employees.Dao.GendersDao;
import com.mx.Employees.Model.Genders;

@Service
public class GendersServImp implements GendersServ {

	// Inyeccion de dependencia
	@Autowired
	GendersDao gendersDao;

	@Override
	public void guardar(Genders genders) {
		gendersDao.save(genders);
	}

	@Override
	public void editar(Genders genders) {
		gendersDao.save(genders);
	}

	@Override
	public void eliminar(Genders genders) {
		gendersDao.delete(genders);
	}

	@Override
	public Genders buscar(Genders genders) {
		return gendersDao.findById(genders.getId()).orElse(null);
	}

	@Override
	public List<Genders> listar() {
		return (List<Genders>) gendersDao.findAll();
	}

	@Transactional(readOnly = true)
	public Genders buscarXN(String nombre) {
		Genders e = new Genders();
		for (Genders es : gendersDao.findAll()) {
			if (es.getName().equals(nombre)) {
				e = es;
			}
		}
		return e;
	}
}
