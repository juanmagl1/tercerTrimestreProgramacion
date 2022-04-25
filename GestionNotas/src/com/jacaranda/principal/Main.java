package com.jacaranda.principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {
	public static LinkedList<Alumnado> listaAlumnos = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		leerfichero("ficheros\\alumnado.txt");
		leerficheroModulo("ficheros\\modulos.txt");
		leerficheroNota("ficheros\\nota.txt");
		do {
			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1: {
				System.out.println("Dime un nombre");
				String nombre = teclado.nextLine();
				System.out.println("Dime un dni");
				String dni = teclado.nextLine();
				System.out.println("Dime un correo");
				String correo = teclado.nextLine();
				Alumnado a1 = new Alumnado(nombre, dni, correo);
				if (listaAlumnos.contains(a1)) {
					System.out.println("El alumno ya está");
				} else {
					listaAlumnos.add(a1);
					System.out.println("Añadido el alumno correctamente");
				}
				break;
			}
			case 2: {
				System.out.println("Dime un nombre de asignatura");
				String nombre = teclado.nextLine();
				Modulo m1 = new Modulo(nombre);
				if (listaModulos.contains(m1)) {
					System.out.println("El modulo ya está creado");
				} else {
					listaModulos.add(m1);
					System.out.println("Añadida la asignatura correctamente");
				}
				break;
			}
			case 3: {
				System.out.println("Dime la nota del examen");
				double nota = Double.parseDouble(teclado.nextLine());
				System.out.println("Dime un nombre de asignatura");
				String nombre = teclado.nextLine();
				Modulo m1 = new Modulo(nombre);
				if (!listaModulos.contains(m1)) {
					System.out.println("No está el modulo");
				}else {
					System.out.println("Dime un nombre");
					String nombreAlumno = teclado.nextLine();
					System.out.println("Dime un dni");
					String dni = teclado.nextLine();
					Alumnado a1 = new Alumnado(nombreAlumno, dni);
					if (listaAlumnos.contains(a1)) {
						Nota n1 = new Nota(nota, LocalDate.now(), a1, m1);
						listaNota.add(n1);
					}
				}
	
				break;
			}
			case 4: {
				for (Nota nota : listaNota) {
					System.out.println(nota);
				}
				break;
			}
			case 5: {
				for (Alumnado alu : listaAlumnos) {
					System.out.println(alu);
				}
				break;
			}
			case 6: {
				// Escribir los datos que hay en memoria en el fichero correspondiente
				escribirEnFicheroPorLineas("ficheros\\alumnado.txt");
				escribirEnFicheroPorLineasNota("ficheros\\nota.txt");
				escribirEnFicheroPorLineasModulo("ficheros\\modulos.txt");
				break;
			}
			default:
				System.out.println("Opcion no valida");
			}
		} while (opc != 6);

	}

	public static void muestraMenu() {
		System.out.println("1 Alta alumnado");
		System.out.println("2 Alta modulo");
		System.out.println("3 Registrar nota");
		System.out.println("4 Listar todas las notas de los alumnos");
		System.out.println("5 Listar los alumnos");
		System.out.println("6 Salir");
	}

	private static void leerfichero(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				Alumnado a2 = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnos.add(a2);
				// Leo otra línea
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

	private static void escribirEnFicheroPorLineas(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// Prceso el fichero
			for (Alumnado alu : listaAlumnos) {
				filtroEscritura.println(alu.escribeFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroPorLineasModulo(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// Prceso el fichero
			for (Modulo mod : listaModulos) {
				filtroEscritura.println(mod.escribeFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerficheroModulo(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				Modulo m2 = new Modulo(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]));
				listaModulos.add(m2);
				// Leo otra línea
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

	private static void escribirEnFicheroPorLineasNota(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// Prceso el fichero
			for (Nota nota : listaNota) {
				filtroEscritura.println(nota.escribeFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerficheroNota(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// System.out.println(linea);
				// proceso la linea que acabo de leer
				String[] campos = linea.split(",");
				
				String dni = campos[2];
				Alumnado alu = new Alumnado("kk",dni);
				int posicion = listaAlumnos.indexOf(alu);//consigo la posicion que esta el alumno
				alu = listaAlumnos.get(posicion);//Con el get consigo al alumno que tiene esa posición
				
				String nombreA = campos[3];
				
				boolean encontrado = false;
				Modulo resultado = null;
				Iterator<Modulo> siguiente = listaModulos.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Modulo m1 = siguiente.next();
					if (m1.getNombre().equals(nombreA)) {
						encontrado = true;
						resultado = m1;
						
					}
				}
				Nota n2 = new Nota(Double.parseDouble(campos[0]), LocalDate.parse(campos[1]),alu ,resultado);
				listaNota.add(n2);
				// Leo otra línea
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
}
