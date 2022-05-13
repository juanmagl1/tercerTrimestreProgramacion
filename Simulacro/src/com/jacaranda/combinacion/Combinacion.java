package com.jacaranda.combinacion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Combinacion {
	private Set<Integer> numeros;
	private Set<Integer> estrellas;

//He elegido ArrayList porque se pueden meter valores repetidos, y en el hash set no se 
//puede meter ninguno
	public Combinacion(Integer n1, Integer n2, Integer n3, Integer n4, Integer n5, Integer e1, Integer e2) throws CombinacionException {
		super();
		this.numeros = new HashSet<>();
		if (n1>0 && n1<=50 && n2>0 && n2<=50 && n3>0 && n3<=50 && n4>0 && n4<=50 && n5>0 && n5<=50) {
			numeros.add(n1);
			numeros.add(n2);
			numeros.add(n3);
			numeros.add(n4);
			numeros.add(n5);
		}else {
			throw new CombinacionException("Tiene que ser entre 1 y 50");
		}
		
		this.estrellas = new HashSet<>();
		if (e1>0 && e1<13 && e2>0 && e2<13 ) {
			estrellas.add(e1);
			estrellas.add(e2);
		}else {
			throw new CombinacionException("Las estrellas tiene que estar entre 1 y 12");
		}
		
	}
	public String toStringNumeros() {
		StringBuilder nuevo=new StringBuilder();
		for (Integer siguiente:this.numeros) {
			nuevo.append(siguiente + "-");
		}
		return nuevo.toString();
	}
	public String toStringEstrellas() {
		StringBuilder resultado=new StringBuilder();
		for (Integer siguiente:this.estrellas) {
			resultado.append(siguiente + "-");
		}
		return resultado.toString();
	}
	@Override
	public String toString() {
		return toStringNumeros() + " Estrellas:" + toStringEstrellas();
	}
	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}
	
	public int comprobarAciertos(Combinacion c) {
		int resultado=0;
		boolean encontrado=false;
		Iterator<Integer> siguiente=c.numeros.iterator();
		while (siguiente.hasNext()) {
			Integer c1=siguiente.next();
			if (this.numeros.contains(c1)) {
				resultado++;
			}
		}
		Iterator<Integer> siguienteEstrella=c.estrellas.iterator();
		while (siguienteEstrella.hasNext()) {
			Integer c1=siguiente.next();
			if (this.estrellas.contains(c1)) {
				resultado++;
			}
		}
		return resultado;
	}

}
