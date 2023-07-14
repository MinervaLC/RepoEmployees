package com.mx.Employees.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EmployeesWH {
	// Mapeo
	@Id
	int id;
	int worked_hours;
	Date worked_date;

	// Cardinalidad
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employees employees;

	public EmployeesWH() {
	}

	public EmployeesWH(int id) {
		this.id = id;
	}

	public EmployeesWH(int id, int worked_hours, Date worked_date, Employees employees) {
		this.id = id;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeesWH [id=" + id + ", worked_hours=" + worked_hours + ", worked_date=" + worked_date
				+ ", employees=" + employees + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	
}
