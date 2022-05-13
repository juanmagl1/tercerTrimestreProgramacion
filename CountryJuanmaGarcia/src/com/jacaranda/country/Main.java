package com.jacaranda.country;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static ArrayList<Country> paises = new ArrayList<>();

	public static void main(String[] args) {
		leerCountry("ficheros//country.txt");
		leerCity("ficheros//city.txt");
		leerAddress("ficheros//address2.txt");
		escribirEnFichero("ficheros//terminado.txt");
//		for (Country siguiente : paises) {
//			System.out.println(siguiente);
//		}
		
	}

	private static void leerCountry(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Country c1 = new Country(Integer.parseInt(campos[0]), campos[1]);
				paises.add(c1);
				// Leer otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerCity(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// Creo la ciudad y después la añado
				String[] campos = linea.split(",");
				Country c1 = new Country(Integer.parseInt(campos[2]), null);
				int posicion = paises.indexOf(c1);
				// cuando consigo la posicion escribo un punto porque esta
				// ya del tipo country
				paises.get(posicion).addCity(Integer.parseInt(campos[0]), campos[1]);
				// leo otra linea
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerAddress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				// Saco el id de la ciudad
				int city_id = (Integer.parseInt(campos[4]));
				// Recorro los paises para ver en que pais introduzco la ciudad
				// Lo hago con el for para probar que funcione
				for (Country siguiente : paises) {
					Country aux = siguiente;
					City c = aux.getCiudad(city_id);
					if (c != null) {
						c.addAddress(Integer.parseInt(campos[0]), campos[1]);
					}

				}
				// A siguiente le hago el get Ciudad, para que me devuelva la ciudad
				// Cuando el get ciudad me devuelva la ciudad, le añado la direccion
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFichero(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			for (Country siguiente:paises) {				
				filtroEscritura.println(siguiente);
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
