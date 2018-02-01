package com.geekspain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "empleados") // el nombre de la tabla que se creará en la b.d.
public class Empleado {

	@Id
	@Column(name = "id") // este atributo estará relacinado conla columna id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "nombre") // este atributo estará relacinado conla columna nombre
	private String nombre;
	
	@Column(name = "fecha_de_inicio")
	private Date fdi;
	
	@Column(name = "salario")
	private Double salario;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFdi() {
		return fdi;
	}

	public void setFdi(Date fdi) {
		this.fdi = fdi;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [Id=" + Id + ", nombre=" + nombre + ", fdi=" + fdi + ", salario=" + salario + "]";
	}
	
	

}
