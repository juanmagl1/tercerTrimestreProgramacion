package com.jacaranda.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PalabraEmpieza {
private char palabra;
private List<Palabra> palabras;
public PalabraEmpieza(char palabra) {
	super();
	this.palabra = palabra;
	this.palabras=new LinkedList<>();
}
public char getPalabra() {
	return palabra;
}
@Override
public String toString() {
	return "PalabraEmpieza [palabra=" + palabra + ", palabras=" + palabras + "]";
}

public void addPalabra(String palabra,String significado) throws PalabraException {
	Iterator<Palabra> siguiente=this.palabras.iterator();
	boolean encontrado=false;
	while (siguiente.hasNext() && !encontrado) {
		Palabra p1=siguiente.next();
		if (p1.getPalabra().equalsIgnoreCase(palabra)) {
			p1.addSignificado(significado);
		}
	}
}

}
