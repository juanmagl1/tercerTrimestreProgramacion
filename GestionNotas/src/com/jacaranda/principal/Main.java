package com.jacaranda.principal;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {
	public static LinkedList<Alumnado> listaAlumnos=new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota=new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		do {
			muestraMenu();
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1: {
				System.out.println("Dime un nombre");
				String nombre=teclado.nextLine();
				System.out.println("Dime un dni");
				String dni=teclado.nextLine();
				Alumnado a1=new Alumnado(nombre,dni);
				if (listaAlumnos.contains(a1)) {
					System.out.println("El alumno ya está");
				}else {
					listaAlumnos.add(a1);
					System.out.println("Añadido el alumno correctamente");
				}
				break;
			}
			case 2: {
				System.out.println("Dime un nombre de asignatura");
				String nombre=teclado.nextLine();
				Modulo m1=new Modulo(nombre);
				if (listaModulos.contains(m1)) {
					System.out.println("El modulo ya está creado");
				}else {
					listaModulos.add(m1);
					System.out.println("Añadida la asignatura correctamente");
				}
				break;
			}
			case 3: {
				System.out.println("Dime la nota del examen");
				double nota=Double.parseDouble(teclado.nextLine());
				System.out.println("Dime un nombre de asignatura");
				String nombre=teclado.nextLine();
				Modulo m1=new Modulo(nombre);
				System.out.println("Dime un nombre");
				String nombreAlumno=teclado.nextLine();
				System.out.println("Dime un dni");
				String dni=teclado.nextLine();
				Alumnado a1=new Alumnado(nombreAlumno,dni);
				Nota n1=new Nota(nota,LocalTime.now(),a1,m1);
				listaNota.add(n1);
				break;
			}
			case 4: {
				for (Nota nota:listaNota) {
					System.out.println(nota);
				}
				break;
			}
			case 5: {
				for (Alumnado alu:listaAlumnos) {
					System.out.println(alu);
				}
				break;
			}
			case 6: {
				System.out.println("Saliendo");
				break;
			}
			default:
				System.out.println("Opcion no valida");
			}
		}while(opc!=6);
	
	}

	public static void muestraMenu() {
		System.out.println("1 Alta alumnado");
		System.out.println("2 Alta modulo");
		System.out.println("3 Registrar nota");
		System.out.println("4 Listar todas las notas de los alumnos");
		System.out.println("5 Listar los alumnos");
		System.out.println("6 Salir");
	}
}
