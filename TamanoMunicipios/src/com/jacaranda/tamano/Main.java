package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	public static TamanoMunicipioComunidad siguiente = new TamanoMunicipioComunidad();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// Primero pasamos el JSON a String
		String fichero = leerJson("tamanoMunicipioComunidad.json");
		// Nos importamos la libreria gson
		siguiente.cargarDatos(fichero);
		int opc = 0;
		do {
			System.out.println(menu());
			System.out.println("Introduce una opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				System.out.println("Escriba un año");
				int anno=Integer.parseInt(teclado.nextLine());
				System.out.println(siguiente.mostrarComunidad(anno));
				break;
			case 2:
				System.out.println("Escriba una comunidad");
				String comunidad=teclado.nextLine();
				System.out.println("Escriba un año");
				int ano=Integer.parseInt(teclado.nextLine());
				System.out.println(siguiente.mostrarComunidadAno(ano, comunidad));
				break;
			case 3:
				System.out.println("Introduce una comunidad");
				String comunidad1=teclado.nextLine();
				System.out.println("INtroduce una descripcion");
				String descripcion=teclado.nextLine();
				System.out.println("INtroduce un año");
				int annno=Integer.parseInt(teclado.nextLine());
				System.out.println("INtroduce un dato");
				int dato=Integer.parseInt(teclado.nextLine());
				try {
					siguiente.addDato(comunidad1, descripcion, annno, dato);
				} catch (ComunidadException | TamanoMunicipioComunidadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Introduce una comunidad");
				String comunidad2=teclado.nextLine();
				System.out.println("INtroduce un año");
				int annno1=Integer.parseInt(teclado.nextLine());
				siguiente.compara(comunidad2, annno1);
				break;
			case 5:
				siguiente.salvarDatos("fichero.json");
				break;

			default:
				System.out.println("Error");
				break;
			}
		} while (opc != 6);

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

	public static String menu() {
		return ("Mostrar todos los datos de un año " + "\n" + " Mostrar todos los datos de un año y una comunidad"
				+ "\n" + "Añadir dato " + "\n" + "Comprobar totales " + "\n" + "Salir " + "\n");
	}
}
