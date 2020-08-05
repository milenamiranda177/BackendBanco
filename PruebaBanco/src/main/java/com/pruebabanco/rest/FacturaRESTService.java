package com.pruebabanco.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebabanco.entity.Factura;
import com.pruebabanco.service.FacturaService;

@RestController
@RequestMapping("/webapi")
public class FacturaRESTService {

	@Autowired
	FacturaService servicio;

	@GetMapping("/facturas")
	public List<Factura> buscarTodas() {

		return servicio.buscarTodas();

	}
	@DeleteMapping("/facturas/{numero}")
	public void borrar(@PathVariable int numero) {
		
		servicio.borrar(new Factura(numero));
		
	}
	@PostMapping("/facturas")
	public void insertar(@RequestBody Factura factura) {
		
		servicio.insertar(factura);
		
	}
	
	@PutMapping("/facturas/{numero}")
	public void actualizar(@PathVariable int numero,@RequestBody Factura factura) {
		Factura mifactura=servicio.buscarUna(numero);
		mifactura.setConcepto(factura.getConcepto());
		mifactura.setImporte(factura.getImporte());
		
		servicio.actualizar(mifactura);
		
	}
}
