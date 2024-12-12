package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

@SpringBootApplication
public class FacturacionApplication implements CommandLineRunner{

	@Autowired
	private DaoFactory dao;
	
	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			
			Producto producto1 = new Producto("Remera", 100);
			Producto producto2 = new Producto("Pantalon", 200);
			Producto producto3 = new Producto("Campera", 300);
			
			Cliente cliente1 = new Cliente("Valeria","Casatti","valeria@email.com");
			Cliente cliente2 = new Cliente("Maria","Perez","maria@email.com");

			dao.persistirProducto(producto1);
			dao.persistirProducto(producto2);
			dao.persistirProducto(producto3);
			
			dao.persistirCliente(cliente1);
			dao.persistirCliente(cliente2);
			
			
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}

}
