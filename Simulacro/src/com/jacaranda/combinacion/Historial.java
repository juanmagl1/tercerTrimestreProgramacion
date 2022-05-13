package com.jacaranda.combinacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Historial {
private Map<LocalDate,Combinacion> conjunto;

public Historial() {
	super();
	this.conjunto=new HashMap<>();
}
public boolean addSorteo(LocalDate fecha,Combinacion c) {
	boolean encontrado;
	if (this.conjunto.containsKey(fecha)) {
		encontrado=false;
	}else {
		encontrado=true;
		this.conjunto.put(fecha, c);
	}
	return encontrado;
	
}
public boolean actualizarSorteo(LocalDate fecha,Combinacion c) {
	boolean actualizado=false;
	//Miramos si está y si esta lo actualizamos y ya está
	if (this.conjunto.containsKey(fecha)) {
		this.conjunto.put(fecha, c);
		actualizado=true;
	}
	
	return actualizado;
}
public boolean borrarSorteo(LocalDate fecha) {
	boolean resultado=false;
	if (this.conjunto.containsKey(fecha)) {
		this.conjunto.remove(fecha);
		resultado=true;
	}
	return resultado;
}
public int comprobarAciertos(LocalDate fecha,Combinacion c) {
	int resultado=-1;
	Combinacion ganadora=this.conjunto.get(fecha);
	if (ganadora!=null) {
		resultado=ganadora.comprobarAciertos(c);
	}
	return resultado;
}

}
