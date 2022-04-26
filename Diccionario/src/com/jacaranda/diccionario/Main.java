package com.jacaranda.diccionario;

public class Main {

	public static void main(String[] args) {
		Diccionario d1 = new Diccionario();
		System.out.println(d1);
		try {
			d1.annadirPalabra("Hola", "Significado 1");
			System.out.println(d1);
			d1.borrarPalabra("Hola");
			System.out.println(d1);
		} catch (PalabraEmpiezaException | PalabraException | DiccionarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
