package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;
	
	

	
	public Comunidad(String descrip) {
		
		this.nombre = descrip;
		this.listMunicipio=new ArrayList<>();
		
	}




	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}
	

	
}
