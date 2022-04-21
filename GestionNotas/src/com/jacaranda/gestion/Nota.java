package com.jacaranda.gestion;

import java.time.LocalTime;
import java.util.Objects;

public class Nota {
private double nota;
private LocalTime fecha;
private Alumnado alumno;
private Modulo modulo;

public Nota(double nota, LocalTime fecha, Alumnado alumno, Modulo modulo) {
	super();
	this.nota = nota;
	this.fecha = fecha;
	this.alumno = alumno;
	this.modulo = modulo;
}

public double getNota() {
	return nota;
}

public void setNota(double nota) {
	this.nota = nota;
}

public LocalTime getFecha() {
	return fecha;
}

public void setFecha(LocalTime fecha) {
	this.fecha = fecha;
}

public String getAlumno() {
	return alumno.getDni();
}

public String getModulo() {
	return modulo.getNombre();
}

@Override
public int hashCode() {
	return Objects.hash(alumno, fecha, modulo, nota);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Nota other = (Nota) obj;
	return Objects.equals(alumno, other.alumno) && Objects.equals(fecha, other.fecha)
			&& Objects.equals(modulo, other.modulo)
			&& Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
}




}
