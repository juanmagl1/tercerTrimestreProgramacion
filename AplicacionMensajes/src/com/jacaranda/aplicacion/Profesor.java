package com.jacaranda.aplicacion;

public class Profesor extends Persona {

	public Profesor(int edad, String nombre) throws PersonaException, AlumnoException {
		super(edad, nombre);
	}
	public boolean sendMessage(Persona destinatario,String texto) throws PersonaException, MensajeException, ProfesorException, AlumnoException {
		boolean resultado=true;
		super.sendMessage(destinatario, texto);
		return resultado;
	}

}
