package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.jacaranda.alumno.Alumno;

public class Equipo {
	private String nombre;
	private Set<Alumno> listado;

	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado = new HashSet<Alumno>();
	}

	public void addAlumno(Alumno a) throws EquipoException {
		if (listado.contains(a) || a == null) {
			throw new EquipoException("No se puede crear el alumno, porque existe, o es nulo");
		}
		listado.add(a);
	}

	// Como el add devuelve true o false pues si da false se va a la excepcion
	// sino lo añade
	public void addAlumno2(Alumno a) throws EquipoException {
		if (a == null || listado.add(a) == false) {
			throw new EquipoException("No se puede crear el alumno, porque existe, o es nulo");
		}
	}

	public void borrarAlumno(Alumno a) throws EquipoException {
		if (a == null || listado.remove(a) == false) {
			throw new EquipoException("No se puede borrar al alumno");
		}
	}

	public Alumno contieneAlumno(Alumno a) throws EquipoException {
		Alumno alu = null;
		if (listado.contains(a)) {
			alu = new Alumno(a.getNombre(), a.getDni());
		} 

		return alu;
	}
	private boolean delUnAlumno(String nombre) {
		Iterator<Alumno> siguiente=this.listado.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {//!Significa que encontrado es falso
			Alumno a = siguiente.next();
			if (a.getNombre().equalsIgnoreCase(nombre)) {
				this.listado.remove(a);
				encontrado=true;
			}
		}
		return encontrado;
	}
	public void delAlumno(String nombre) {
		while (delUnAlumno(nombre));
	}

	public Equipo unionEquipos(Equipo e) {
		Equipo auxiliar = new Equipo("");
		for (Alumno a:this.listado) {
				try {
					auxiliar.addAlumno2(a);
				} catch (EquipoException e1) {
					e1.printStackTrace();
				}
			}
		//Recorremos los 2 equipos pero no uno dentro de otro y para que no se repitan
		for (Alumno a: e.listado) {
			try {
				auxiliar.addAlumno2(a);
			} catch (EquipoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return auxiliar;
	}
public Equipo insercionEquipo(Equipo e) {
	Equipo auxiliar=new Equipo("");
	for (Alumno a:this.listado) {
		//Tengo que recorrerlo para ver los elementos que tengo en la lista
		if (e.listado.contains(a)) {
			try {
				auxiliar.addAlumno2(a);
			} catch (EquipoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	return auxiliar;
}
	public int listadoAlumnos() {
		return this.listado.size();
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}

}
