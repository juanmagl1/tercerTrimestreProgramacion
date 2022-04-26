package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.List;

public class Diccionario {
	private List<PalabraEmpieza> listaLetras;

	public Diccionario() {
		super();
		this.listaLetras = new ArrayList<PalabraEmpieza>();
		this.annadirLetras();

	}

	private void annadirLetras() {
		for (int i = 65; i <= 90; i++) {
			String letraEmpieza = Character.toString(i);
			PalabraEmpieza p1 = new PalabraEmpieza(letraEmpieza.charAt(0));
			listaLetras.add(p1);
		}
	}

	public boolean annadirPalabra(String palabra,String significado) throws PalabraEmpiezaException, PalabraException, DiccionarioException {
		boolean resultado=false;
		Character c=palabra.toUpperCase().charAt(0);
		PalabraEmpieza p2= new PalabraEmpieza(c);
		int posicion=this.listaLetras.indexOf(p2);
		if (posicion<0) {
			throw new DiccionarioException("No está la letra");
		}else {
			this.listaLetras.get(posicion).addPalabra(palabra, significado);
			resultado=true;
		}
		return resultado;
		
	}
	public boolean borrarPalabra(String palabra) throws DiccionarioException, PalabraException {
		boolean resultado=false;
		PalabraEmpieza p1=new PalabraEmpieza(palabra.toUpperCase().charAt(0));
		int pos=this.listaLetras.indexOf(p1);
		if (pos<0) {
			throw new DiccionarioException("No está la letra");
		}else {
			this.listaLetras.get(pos).delPalabra(palabra);
			resultado=true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Diccionario [listaLetras=" + listaLetras + "]";
	}

}
