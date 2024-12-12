package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	//Un cliente puede realizar muchas ventas
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Venta> ventas = new ArrayList<>();

	// encapsulamiento
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}

	//constructor
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, String email) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	

}
