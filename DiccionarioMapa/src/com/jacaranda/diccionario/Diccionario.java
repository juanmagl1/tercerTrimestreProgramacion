package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Diccionario {
private HashMap<String,HashSet<String>> palabraSignificado;
public Diccionario() {
	super();
	palabraSignificado=new HashMap<>();
}
public boolean annadirPalabra(String palabra,String significado) {
	boolean annadido=true;
	//Averigumos si la palabra esta en el diccionario
	HashSet<String> valor=this.palabraSignificado.get(palabra);
	if (valor==null) {
		//Creo el hashSet, le añado el significado y añado al mapa
		HashSet<String> significados=new HashSet<>();
		significados.add(significado);
		 if (this.palabraSignificado.put(palabra,significados)==null){
			 annadido=false;
		 }
	}else { //En el caso de la palabra este en el diccionario
		//Se iguala annadido al valor de add significado porque da un boolean
		annadido=valor.add(significado);
	}
	
	 return annadido;
	 }
public boolean borrarPalabra (String palabra) {
	boolean resultado;
	HashSet<String>valor=this.palabraSignificado.get(palabra);
	if (valor==null) {
		resultado=false;
	}else {
		resultado=this.palabraSignificado.remove(palabra, valor);
	}
	return resultado;
}
public boolean borrarPalabraYSignificado(String palabra,String significado) {
	//como el get accede al valor de la clave pues por eso tenemos el hashSet
	return this.palabraSignificado.get(palabra).remove(significado);
	
}
public String palabraEmpieza(String cadena) {
	StringBuilder resultado=new StringBuilder();
	for (String siguiente:this.palabraSignificado.keySet()) {
		if(siguiente.toUpperCase().startsWith(cadena.toUpperCase())) {
			resultado.append(siguiente + "\n");
		}
	}
	return resultado.toString();
	
}
@Override
public String toString() {
	return "Diccionario [palabraSignificado=" + palabraSignificado + "]";
}



}
