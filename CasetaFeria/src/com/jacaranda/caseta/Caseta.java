package com.jacaranda.caseta;

import java.util.Objects;

public class Caseta {
private String titulo;
private String calle;
private int numero;
private int modulos;
private String clase;
private int id;
private int id_calle;
public Caseta(String titulo, String calle, int numero, int modulo, String clase, int id, int id_calle) {
	super();
	this.titulo = titulo;
	this.calle = calle;
	this.numero = numero;
	this.modulos = modulo;
	this.clase = clase;
	this.id = id;
	this.id_calle = id_calle;
}



public Caseta(String titulo) {
	super();
	this.titulo = titulo;
}



public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public int getModulos() {
	return modulos;
}
public void setModulos(int modulos) {
	this.modulos = modulos;
}
public String getClase() {
	return clase;
}
public void setClase(String clase) {
	this.clase = clase;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_calle() {
	return id_calle;
}
public void setId_calle(int id_calle) {
	this.id_calle = id_calle;
}




@Override
public int hashCode() {
	return Objects.hash(titulo);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Caseta other = (Caseta) obj;
	return Objects.equals(titulo, other.titulo);
}



@Override
public String toString() {
	return "Caseta [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", modulos=" + modulos + ", clase="
			+ clase + ", id=" + id + ", id_calle=" + id_calle + "]"+"\n";
}

}
