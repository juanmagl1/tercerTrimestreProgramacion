package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Provincia {
	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private List<Pueblo> pueblos;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		if (nombre == null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
		this.setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
		this.pueblos = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws ProvinciaException {
		if (codigo==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		if (codigo.length() == 2 && codigo.chars().allMatch(Character::isDigit)) {
			this.codigo = codigo;
		} else {
			throw new ProvinciaException("El código no es correcto");
		}

	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String nombre, int numeroHabitantes) throws ProvinciaException, PuebloException {
		boolean resultado=false;
		if (numeroHabitantes<0) {
			throw new ProvinciaException("Los números de habitantes debe de ser positiva");
		}
		int diferencia=0;
		if (existePueblo(nombre)) {
			Iterator <Pueblo> p = this.pueblos.iterator();
			while (p.hasNext()) {
				Pueblo p2=p.next();
				if (p2.getNombre().equalsIgnoreCase(nombre)) {
					diferencia=numeroHabitantes-p2.getNumeroHabitantes();
					p2.setNumeroHabitantes(numeroHabitantes);
				}
			}
			this.superficie+=diferencia;
			resultado=true;
		} else {
			throw new ProvinciaException("No existe el pueblo");
		}
		return resultado;

	}
	public int numPueblos() {
		return this.pueblos.size();
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

	public boolean setSuperficie(String pueblo, double superficie) throws ProvinciaException, PuebloException {
		double diferencia = 0;
		if (superficie<0) {
			throw new ProvinciaException("La superficie debe de ser positiva");
		}
		boolean resultado=false;
		if (existePueblo(pueblo)) {
			Iterator <Pueblo> p = this.pueblos.iterator();
			while (p.hasNext()) {
				Pueblo p2=p.next();
				if (p2.getNombre().equalsIgnoreCase(pueblo)) {
					diferencia=superficie-p2.getSuperficie();
					p2.setSuperficie(superficie);
				}
			}
			this.superficie+=diferencia;
			resultado=true;
		} else {
			throw new ProvinciaException("No existe el pueblo");
		}
		return resultado;

	}

	public String getProvincia() {
		return nombre;
	}

	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean resultado = false;
		if (nombre==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		for (Pueblo p : this.pueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				resultado = true;
			}

		}
		return resultado;
	}

	public boolean addPueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita,
			double superficie) throws ProvinciaException, PuebloException {
		boolean resultado = false;
		String codigoNuevo = this.codigo + codigo;
		if (nombre == null) {
			throw new ProvinciaException("El codigo no puede ser nulo");
		}
		if (existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo ya existe");
		} else {
			Pueblo p1 = new Pueblo(nombre, codigoNuevo, numeroHabitantes, rentaPerCapita, superficie);
			pueblos.add(p1);
			resultado = true;
			this.superficie += superficie;
			this.numeroHabitantes += numeroHabitantes;
			this.rentaPerCapita += rentaPerCapita;
		}
		return resultado;
	}

	public String listadoNombrePueblo() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p.getNombre() + "\n");
		}
		return cadenaNueva.toString();
	}

	public String listadoPueblos() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p);
		}
		return cadenaNueva.toString();
	}

	public boolean delPueblo(String nombre) {
		boolean eliminado = false;
		Iterator<Pueblo> siguiente = this.pueblos.iterator();
		while (siguiente.hasNext()) {
			Pueblo p = siguiente.next();
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.pueblos.remove(p);
				this.superficie -= p.getSuperficie();
				this.rentaPerCapita -= p.getRentaPerCapita();
				this.numeroHabitantes -= p.getNumeroHabitantes();
			}
		}
		return eliminado;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", pueblos=" + pueblos + "]";
	}
	public String getInformacionPueblo(String nombre) throws ProvinciaException {
		String resultado="";
		if (!existePueblo(nombre) || nombre==null) {
			resultado=null;
		}else {
			for (Pueblo p:this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					resultado=p.toString();
				}
			}
		}
		return resultado;
	}

}
