package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

public class Municipio {

	private String descrip;
	ArrayList<Datos> datos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		datos = new ArrayList<>();
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int numeroDatos(int anno) {
		int total=0;
		for (Datos d:this.datos) {
			if(d.getAno()==anno) {
				total=d.getDato();
			}
		}
		return total;
	}
	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos + "]";
	}

	public String devuelve(int anno) {
		StringBuilder resultado = new StringBuilder();
		for (Datos d : this.datos) {
			if (d.getAno() == anno) {
				resultado.append(d + "\n");
			}
		}
		return resultado.toString();
	}

	public void addDato(int anno, int dato) {
		Iterator<Datos> siguiente = this.datos.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Datos aux = siguiente.next();
			if (aux.getAno() == anno) {
				aux.setDato(dato);
				encontrado = true;
			}
		}
		if (!encontrado) {
			Datos nuevo = new Datos(anno, dato);
			this.datos.add(nuevo);
		}
	}
}
