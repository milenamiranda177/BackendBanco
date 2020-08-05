package com.pruebabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebabanco.entity.Factura;
import com.pruebabanco.repository.FacturaRepository;

@Service
public class FacturaService {

	@Autowired
	FacturaRepository repositorio;

	@Transactional
	public List<Factura> buscarTodas() {
		return repositorio.buscarTodas();
	}
	@Transactional
	public void insertar(Factura factura) {
		repositorio.insertar(factura);
	}
	
	@Transactional
	public void insertarVarios(Factura f1,Factura f2) {
		repositorio.insertar(f1);
		repositorio.insertar(f2);
		
	}
	@Transactional
	public void borrar(Factura factura) {
		repositorio.borrar(factura);
	}
	@Transactional
	public void actualizar(Factura factura) {
		repositorio.actualizar(factura);
	}
	public Factura buscarUna(int numero) {
		return repositorio.buscarUna(numero);
	}
	
	
}
