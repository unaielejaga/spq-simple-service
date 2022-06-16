package com.example.jdo;

public class Producto {

	private String nombre;
	private String marca;
	private String fechacad;
	private String fechacompr;
	private String fechacons;
	
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String marca, String fechacad, String fechacompr, String fechacons) {
		this.nombre = nombre;
		this.marca = marca;
		this.fechacad = fechacad;
		this.fechacompr = fechacompr;
		this.fechacons = fechacons;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFechacad() {
		return fechacad;
	}

	public void setFechacad(String fechacad) {
		this.fechacad = fechacad;
	}

	public String getFechacompr() {
		return fechacompr;
	}

	public void setFechacompr(String fechacompr) {
		this.fechacompr = fechacompr;
	}

	public String getFechacons() {
		return fechacons;
	}

	public void setFechacons(String fechacons) {
		this.fechacons = fechacons;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", marca=" + marca + ", fechacad=" + fechacad + ", fechacompr="
				+ fechacompr + ", fechacons=" + fechacons + "]";
	}
	
	
	
}
