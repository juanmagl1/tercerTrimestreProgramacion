package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Main {
	public static TamanoMunicipioComunidad siguiente = new TamanoMunicipioComunidad();

	public static void main(String[] args) {
		// Primero pasamos el JSON a String
		String fichero = leerJson("tamanoMunicipioComunidad.json");
		// Nos importamos la libreria gson
		siguiente.cargarDatos(fichero);
		System.out.println(siguiente.mostrarComunidad(2010));
		//System.out.println(siguiente.mostrarComunidadAno(2010,"Andalucía"));
	}

	private static String leerJson(String nombreFichero) {
		StringBuilder resultado = new StringBuilder();
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resultado.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}
}
