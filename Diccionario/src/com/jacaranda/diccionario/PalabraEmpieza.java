package com.jacaranda.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PalabraEmpieza {
	private char palabra;
	private List<Palabra> palabras;

	public PalabraEmpieza(char palabra) {
		super();
		this.palabra = palabra;
		this.palabras = new LinkedList<>();
	}

	public char getPalabra() {
		return palabra;
	}

	@Override
	public String toString() {
		return "PalabraEmpieza [palabra=" + palabra + ", palabras=" + palabras + "]";
	}

	public void addPalabra(String palabra, String significado) throws PalabraEmpiezaException, PalabraException {
		if (palabra == null || significado == null) {
			throw new PalabraEmpiezaException("No puede ser nulo");
		} else {
			Iterator<Palabra> siguiente = this.palabras.iterator();
			boolean encontrado = false;
			while (siguiente.hasNext() && !encontrado) {
				Palabra p1 = siguiente.next();
				if (p1.getPalabra().equalsIgnoreCase(palabra)) {
					p1.addSignificado(significado);
					encontrado=true;
				}else {
					int posicion=encuentraSitio(palabra);
					Palabra aux=new Palabra(palabra,significado);
					this.palabras.add(posicion,aux);
				}
			}
		}

	}

	private int encuentraSitio(String nuevo) {
		int posicion = 0;
		boolean encontrado = false;
		Iterator<Palabra> siguiente = this.palabras.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Palabra elemento = siguiente.next();
			if (nuevo.compareTo(elemento.getPalabra()) < 0) {
				encontrado=true;
			}else {
				posicion++;
			}
		}
		return posicion;
	}
	private int buscaPosicion(String palabra) {
		Palabra aux = new Palabra(palabra);
		return this.palabras.indexOf(aux);
	}

	public void delPalabra(String palabra) throws PalabraEmpiezaException {
		int posicion=buscaPosicion(palabra);
		if (posicion==-1) {
			throw new PalabraEmpiezaException("La palabra no está");
		}else {
			this.palabras.remove(posicion);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabraEmpieza other = (PalabraEmpieza) obj;
		return palabra == other.palabra;
	}
	
}
