package com.jacaranda.tamano;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	public boolean addDato(String comunidad,String descripcion,int anno,int dato) throws ComunidadException, TamanoMunicipioComunidadException {
		Iterator<Comunidad> siguiente=this.lista.iterator();
		boolean encontrado=false;
		while (siguiente.hasNext()&&!encontrado) {
			Comunidad aux=siguiente.next();
			if (aux.getNombre().toUpperCase().equalsIgnoreCase(comunidad.toUpperCase())) {
				aux.encuentraDescripcion(descripcion, anno, dato);
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new TamanoMunicipioComunidadException("La comunidad no existe");
		}
		return encontrado;
	}
	public String compara(String comunidad,int anno) {
		String result="";
		Comunidad c=null;
		Iterator<Comunidad> siguiente=this.lista.iterator();
		boolean encontrado=false;
		while(siguiente.hasNext()&& !encontrado) {
			Comunidad aux=siguiente.next();
			if (aux.getNombre().toUpperCase().equalsIgnoreCase(comunidad.toUpperCase())) {
				c=aux;
				encontrado=true;
			}
		}
		int suma=c.sumaDatos(anno);
		int total=c.totalDatos(anno);
		if (suma==total) {
			result ="Igual";
		}else if(suma!=total) {
			result="Total: "+ String.valueOf(suma)+" Deberia estar: "+String.valueOf(total);
		}
		return result;
	}
	
	
	
	public void salvarDatos(String fichero) {
		Gson gsonBonito= new GsonBuilder().setPrettyPrinting().create();
		String ponerloBonito=gsonBonito.toJson(this.lista);
		escribirEnFicheroJson(fichero, ponerloBonito);
	}
	private static void escribirEnFicheroJson(String nombre, String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
