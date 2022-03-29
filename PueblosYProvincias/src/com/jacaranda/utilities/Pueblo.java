package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;

	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		this.setCodigo(codigo);
		this.setNumeroHabitantes(numeroHabitantes);
		this.setRentaPerCapita(rentaPerCapita);
		this.setSuperficie(superficie);
	}

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		this.setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) throws PuebloException {
		if (codigo == null || (codigo.length() != 5 && !codigo.chars().allMatch(Character::isDigit))) {
			throw new PuebloException("Error no se puede crear el pueblo");
		}
		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (numeroHabitantes < 0) {
			throw new PuebloException("Error el número de habitantes no puede ser negativo");
		} else {
			this.numeroHabitantes = numeroHabitantes;
		}

	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita < 0) {
			throw new PuebloException("La renta per capita no puede ser negativa");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie < 0) {
			throw new PuebloException("El pueblo no puede ser negativo");
		} else {
			this.superficie = superficie;
		}

	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Pueblo o) {
		int resultado;
		if (o == null) {
			resultado = -1;
		} else {
			resultado = this.nombre.compareTo(o.nombre);
			if (resultado == 0) {
				resultado = this.nombre.compareTo(o.nombre);
			}
		}

		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

}
