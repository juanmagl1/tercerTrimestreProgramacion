package com.jacaranda.main;

import com.jacaranda.aplicacion.Alumno;
import com.jacaranda.aplicacion.AlumnoException;
import com.jacaranda.aplicacion.MensajeException;
import com.jacaranda.aplicacion.PersonaException;
import com.jacaranda.aplicacion.Profesor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Alumno a1=new Alumno(18,"Juanma");
			Alumno a2=new Alumno(17,"Pepe");
			Profesor p1=new Profesor(54,"Antonio");
			a2.sendMessage(p1, "Deberes");
			a1.sendMessage(a2, "Mañana a que hora");
			//a2.sendMessage(a1, "Loco");
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(p1);
			System.out.println(p1.encontrarMensaje("Deberes"));
		} catch (PersonaException | AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MensajeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
