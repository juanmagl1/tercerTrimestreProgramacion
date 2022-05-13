package com.jacaranda.combinacion;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparadorDesc implements Comparator<LocalDate> {
	//Para que sea descendente comparamos el 2 alumno con el primero 
	//Ascendente el primero con el segundo
	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		return -o1.compareTo(o2);
	}



}
