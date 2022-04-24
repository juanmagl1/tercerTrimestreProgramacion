package com.jacaranda.gestion;

import java.util.Objects;

public class Alumnado {
private String nombre;
private String dni;
private String eMail;

public Alumnado(String nombre, String dni) {
	super();
	this.nombre = nombre;
	this.dni = dni;
}

public Alumnado(String nombre, String dni, String eMail) {
	super();
	this.nombre = nombre;
	this.dni = dni;
	this.eMail = eMail;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String geteMail() {
	return eMail;
}

public void seteMail(String eMail) {
	this.eMail = eMail;
}

public String getDni() {
	return dni;
}

@Override
public String toString() {
	return "Alumnado [nombre=" + nombre + ", dni=" + dni + ", eMail=" + eMail + "]";
}

@Override
public int hashCode() {
	return Objects.hash(dni);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Alumnado other = (Alumnado) obj;
	return Objects.equals(dni, other.dni);
}
public String escribeFichero() {
	return this.nombre+ "," + this.dni + "," + this.eMail;
}

}
