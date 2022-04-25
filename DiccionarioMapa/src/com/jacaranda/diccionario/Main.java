package com.jacaranda.diccionario;

public class Main {
 public static void main(String args[]) {
	 Diccionario d1=new Diccionario();
	 d1.annadirPalabra("Hola","significado 1");
	 d1.annadirPalabra("Hoios","significado 1");
	 System.out.println(d1);
	 d1.annadirPalabra("Hola", "Significado 4");
	 System.out.println(d1);
	 d1.borrarPalabraYSignificado("Hola", "Significado 4");
	 System.out.println(d1);
	 System.out.println(d1.palabraEmpieza("Ho"));
 }
}
