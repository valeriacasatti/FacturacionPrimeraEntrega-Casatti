package com.coderhouse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.models.Venta;

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
			
			//creacion de productos y clientes
			Producto producto1 = new Producto("Remera", 100);
			Producto producto2 = new Producto("Pantalon", 200);
			Producto producto3 = new Producto("Campera", 300);
			Producto producto4 = new Producto("Short", 150);
			Producto producto5 = new Producto("Buzo", 280);
			
			Cliente cliente1 = new Cliente("Valeria","Casatti","valeria@email.com");
			Cliente cliente2 = new Cliente("Maria","Perez","maria@email.com");
			Cliente cliente3 = new Cliente("Julio","Fernandez","julio@email.com");
			Cliente cliente4 = new Cliente("Agustin","Juncos","agustin@email.com");
			Cliente cliente5 = new Cliente("Ana","Gonzalez","ana@email.com");

			//persistencia de productos y clientes
			dao.persistirProducto(producto1);
			dao.persistirProducto(producto2);
			dao.persistirProducto(producto3);
			dao.persistirProducto(producto4);
			dao.persistirProducto(producto5);
			
			dao.persistirCliente(cliente1);
			dao.persistirCliente(cliente2);
			dao.persistirCliente(cliente3);
			dao.persistirCliente(cliente4);
			dao.persistirCliente(cliente5);
			
			//creacion de ventas
			Venta venta1 = new Venta();
			venta1.setCliente(cliente1);
			venta1.setProductos(Arrays.asList(producto1, producto2));
			venta1.setFecha(new java.util.Date());
			venta1.setTotal(venta1.calcularTotal());
			
			Venta venta2 = new Venta();
			venta2.setCliente(cliente2);
			venta2.setProductos(Arrays.asList(producto3, producto4));
			venta2.setFecha(new java.util.Date());
			venta2.setTotal(venta2.calcularTotal());
			
			Venta venta3 = new Venta();
			venta3.setCliente(cliente3);
			venta3.setProductos(Arrays.asList(producto5, producto1));
			venta3.setFecha(new java.util.Date());
			venta3.setTotal(venta3.calcularTotal());
			
			Venta venta4 = new Venta();
			venta4.setCliente(cliente4);
			venta4.setProductos(Arrays.asList(producto2, producto3));
			venta4.setFecha(new java.util.Date());
			venta4.setTotal(venta4.calcularTotal());
			
			Venta venta5 = new Venta();
			venta5.setCliente(cliente5);
			venta5.setProductos(Arrays.asList(producto4, producto5));
			venta5.setFecha(new java.util.Date());
			venta5.setTotal(venta5.calcularTotal());
			
			//persistencia de las ventas
			dao.persistirVenta(venta1);
			dao.persistirVenta(venta2);
			dao.persistirVenta(venta3);
			dao.persistirVenta(venta4);
			dao.persistirVenta(venta5);
			
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}

}
