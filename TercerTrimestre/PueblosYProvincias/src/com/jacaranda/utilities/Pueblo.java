package com.jacaranda.utilities;

public class Pueblo {
private String nombre;
private String codigo;
private int numeroHabitantes;
private double rentaPerCapita;
private double superficie;

public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) {
	super();
	this.nombre = nombre.toUpperCase();
	this.codigo = codigo;
	this.numeroHabitantes = numeroHabitantes;
	this.rentaPerCapita = rentaPerCapita;
	this.superficie = superficie;
}

public Pueblo(String nombre, String codigo) {
	super();
	this.nombre = nombre.toUpperCase();
	this.codigo = codigo;
}

public String getCodigo() {
	return codigo;
}

private void setCodigo(String codigo) {
	if (codigo.length()!=5) {
		throw new PuebloException("Error no se puede crear el pueblo");
	}
	this.codigo = codigo;
}

public int getNumeroHabitantes() {
	return numeroHabitantes;
}

public void setNumeroHabitantes(int numeroHabitantes) {
	this.numeroHabitantes = numeroHabitantes;
}

public double getRentaPerCapita() {
	return rentaPerCapita;
}

public void setRentaPerCapita(double rentaPerCapita) {
	this.rentaPerCapita = rentaPerCapita;
}

public double getSuperficie() {
	return superficie;
}

public void setSuperficie(double superficie) {
	this.superficie = superficie;
}

public String getNombre() {
	return nombre;
}



}
