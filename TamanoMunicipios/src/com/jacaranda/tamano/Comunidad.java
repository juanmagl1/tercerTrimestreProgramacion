package com.jacaranda.tamano;

import java.util.ArrayList;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;
	
	

	
	public Comunidad(String descrip) {
		
		this.nombre = descrip;
		this.listMunicipio=new ArrayList<>();
		
	}

public String getNombre() {
		return nombre;
	}

public String devuelve(int anno) {
	StringBuilder resultado=new StringBuilder();
	for (Municipio c:this.listMunicipio) {
		resultado.append(c.getDescrip()+"\n"+c.devuelve(anno));
	}
	return resultado.toString();
}

public ArrayList<Municipio> encuentraDescripcion () {
	Array
}
	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}
	

	
}
