package com.jacaranda.aplicacion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Persona {

	protected int edad;
	protected String nombre;
	protected List<Mensaje> mensajesRecibido;
	protected List<Mensaje> mensajesEnviado;

	public Persona(int edad, String nombre) throws PersonaException, AlumnoException {
		super();
		this.setEdad(edad);
		this.nombre = nombre;
		this.mensajesRecibido = new LinkedList<>();
		this.mensajesEnviado = new LinkedList<>();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad < 0) {
			throw new PersonaException("La edad de la persona no puede ser negativa");
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean sendMessage(Persona destinatario, String texto)
			throws PersonaException, MensajeException, AlumnoException, ProfesorException {
		boolean mandado = false;
		if (destinatario == null || texto == null) {
			throw new PersonaException("no puede tener valores nulos");
		} else {
			Mensaje m1 = new Mensaje(this.nombre, destinatario.nombre, texto);
			destinatario.mensajesRecibido.add(m1);
			this.mensajesEnviado.add(m1);
			mandado = true;
		}
		return mandado;
	}

	public String readMessageRecibido() throws PersonaException {
		if (this.mensajesRecibido.isEmpty()) {
			throw new PersonaException("La lista está vacía");
		} else {
			return this.mensajesRecibido.toString();
		}
	}

	public String readMessageEnviado() throws PersonaException {
		if (this.mensajesEnviado.isEmpty()) {
			throw new PersonaException("La lista está vacía");
		} else {
			return this.mensajesEnviado.toString();
		}
	}

	public boolean delMessageRecibido(int codigo) throws PersonaException {
		boolean encontrado = false;
		Iterator<Mensaje> siguiente = this.mensajesRecibido.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1 = siguiente.next();
			if (m1.getCodigo() == codigo) {
				this.mensajesRecibido.remove(codigo);
				encontrado = true;
			}
		}
		if (!encontrado) {
			throw new PersonaException("Mensaje no encontrado");
		}
		return encontrado;
	}

	public boolean delMessageEnviado(int codigo) throws PersonaException {
		boolean encontrado = false;
		Iterator<Mensaje> siguiente = this.mensajesEnviado.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1 = siguiente.next();
			if (m1.getCodigo() == codigo) {
				this.mensajesEnviado.remove(codigo);
				encontrado = true;
			}
		}
		if (!encontrado) {
			throw new PersonaException("Mensaje no encontrado");
		}
		return encontrado;
	}

	public String encontrarMensaje(String frase) throws PersonaException {
		StringBuilder cadena = new StringBuilder("");
		for (Mensaje m : this.mensajesRecibido) {
			if (m.getTexto().contains(frase)) {
				cadena.append(frase + "\n");
			} else {
				throw new PersonaException("No contiene la palabra");
			}
		}
		return cadena.toString();
	}
}
