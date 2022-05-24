package com.jacaranda.tamano;
import java.util.ArrayList;

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
	public
	
}
