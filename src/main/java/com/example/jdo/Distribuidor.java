package com.example.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Distribuidor {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int code;
	
	private String nombre;
	private String codigo_distr;
	private String password;
	
	public Distribuidor() {
		
	}
	
	public Distribuidor(String nombre, String codigo_dis, String password) {
		this.nombre = nombre;
		this.codigo_distr = codigo_dis;
		this.password = password;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo_distr() {
		return codigo_distr;
	}

	public void setCodigo_distr(String codigo_distr) {
		this.codigo_distr = codigo_distr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Distribuidor [code=" + code + ", nombre=" + nombre + ", codigo_distr=" + codigo_distr + ", password="
				+ password + "]";
	}
	

}
