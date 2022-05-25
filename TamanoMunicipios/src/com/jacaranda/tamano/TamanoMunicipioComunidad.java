package com.jacaranda.tamano;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;
	
	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}
	
	public void cargarDatos(String datos) {
		Gson gson = new Gson();
		this.lista = gson.fromJson(datos,new TypeToken<ArrayList<Comunidad>>(){}.getType());
		
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista + "]";
	}
	public String mostrar() {
		StringBuilder resultado=new StringBuilder();
		for (Comunidad c:this.lista) {
			resultado.append(lista);
		}
		return resultado.toString();
	}
	public String mostrarComunidad(int anno) {
		StringBuilder resultado=new StringBuilder();
		for (Comunidad c:this.lista) {
			resultado.append(c.getNombre()+c.devuelve(anno));
		}
		return resultado.toString();
	}
	public String mostrarComunidadAno(int ano,String comunidad) {
		StringBuilder resultado=new StringBuilder();
		Iterator <Comunidad> siguiente=this.lista.iterator();
		boolean encontrado=false;
		while(siguiente.hasNext()&&!encontrado) {
			Comunidad aux=siguiente.next();
			if (aux.getNombre().toUpperCase().equalsIgnoreCase(comunidad.toUpperCase())) {
				resultado.append(aux.getNombre()+aux.devuelve(ano));
				encontrado=true;
			}
		}
		return resultado.toString();
	}
}
