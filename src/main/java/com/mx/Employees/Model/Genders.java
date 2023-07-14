package com.mx.Employees.Model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GENDERS")
public class Genders {
	//Mapeo
	@Id
	int id;
	String name;
	
	// Cardinalidad
	@OneToMany(mappedBy = "genders", cascade = CascadeType.ALL)
	List<Employees> lista = new ArrayList<Employees>();

	public Genders() {
	}

	public Genders(int id) {
		this.id = id;
	}

	public Genders(int id, String name, List<Employees> lista) {
		this.id = id;
		this.name = name;
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Genders [Id=" + id + ", Nombre=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
