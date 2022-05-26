package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

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

public boolean encuentraDescripcion (String descripcion,int anno,int dato) throws ComunidadException {
	Iterator<Municipio> siguiente=this.listMunicipio.iterator();
	boolean encontrado = false;
	while (siguiente.hasNext()&&!encontrado) {
		Municipio aux=siguiente.next();
		if (aux.getDescrip().toUpperCase().equalsIgnoreCase(descripcion.toUpperCase())) {
			aux.addDato(anno, dato);
			encontrado=true;
		}
	}
	if (!encontrado) {
		throw new ComunidadException("Error la descripción no existe");
	}
	return encontrado;
}
	public int totalDatos(int anno) {
		int total=0;
		for (Municipio m:this.listMunicipio) {
			if (m.getDescrip().equalsIgnoreCase("TOTAL")) {
				total=m.numeroDatos(anno);
			}
		}
		return total;
	}
	public int sumaDatos(int anno) {
		int total=0;
		for (Municipio m:this.listMunicipio) {
			if (!m.getDescrip().equalsIgnoreCase("TOTAL")) {
				total+=m.numeroDatos(anno);
			}
		}
		return total;
	}
	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}
	

	
}
