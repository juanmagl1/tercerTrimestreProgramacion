package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {

	private String descrip;
	ArrayList<Datos> datos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		datos = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos + "]";
	}
	public  String devuelve(int anno) {
		StringBuilder resultado=new StringBuilder();
		for (Datos d:this.datos) {
			if (d.getAno()==anno) {
				resultado.append(d);
			}
		}
		return resultado.toString();
	}

}
