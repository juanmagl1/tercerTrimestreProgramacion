package com.jacaranda.diccionario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Palabra {
	private String palabra;
	private Set<String> significado;

	public Palabra(String palabra) {
		super();
		this.palabra = palabra;
		significado = new HashSet<>();
	}

	public Palabra(String palabra, String significados) {
		super();
		this.palabra = palabra;
		this.significado = new HashSet<>();
		this.significado.add(significados);
	}

	public void addSignificado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("El significado no puede ser nulo");
		} else {
			this.significado.add(significado);
			if (!(this.significado.add(significado))) {
				throw new PalabraException ("El significado ya está en la lista");
			}
		}
	}

	public String getPalabra() {
		return palabra;
	}

	public void delSignficado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("El significado no puede ser nulo");
		} else {
			Iterator<String> siguiente = this.significado.iterator();
			boolean encontrado = false;
			while (siguiente.hasNext() && !encontrado) {
				String s1 = siguiente.next();
				if (!(s1.equalsIgnoreCase(significado))) {
					throw new PalabraException("El significado no está en la lista");
				} else {
					this.significado.remove(significado);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", significado=" + significado + "]";
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
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}
	public Character getInicialPalabra() {
		return this.getPalabra().charAt(0);
	}
}
