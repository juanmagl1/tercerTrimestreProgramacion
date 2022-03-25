package com.jacaranda.main;

import com.jacaranda.alumno.Alumno;
import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno a = new Alumno("Zari", "1651");

		Equipo e = new Equipo("La cuadrilla");

		try {
			e.addAlumno(a);
			System.out.println("Alumno Añadido");
			System.out.println(e);
			System.out.println(e.contieneAlumno(a));
			System.out.println("Contiene alumno");
			System.out.println(e);
		} catch (EquipoException e1) {
			System.out.println(e1.getMessage());
		}
	}

}
