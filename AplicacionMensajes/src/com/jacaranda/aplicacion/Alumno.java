package com.jacaranda.aplicacion;

public class Alumno extends Persona {

	public Alumno(int edad, String nombre) throws PersonaException, AlumnoException{
		super(edad, nombre);
	}
	@Override
	public boolean sendMessage(Persona remitente,String texto) throws MensajeException, AlumnoException {
		boolean mandado=false;
		if (remitente instanceof Alumno && edad<18) {
			throw new AlumnoException("No se puede enviar el mensaje");
		}else {
			Mensaje m1=new Mensaje(super.getNombre(),remitente.getNombre(),texto);
			remitente.mensajesRecibido.add(m1);
			super.mensajesEnviado.add(m1);
			mandado=true;
		}
		return mandado;
	}
	
}
