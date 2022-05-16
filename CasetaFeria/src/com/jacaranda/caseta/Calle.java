package com.jacaranda.caseta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calle {
private String calle;
private List<Caseta>casetas;
public Calle(String calle) {
	super();
	this.calle = calle;
	this.casetas=new ArrayList<>();
}
public void annadirCaseta(Caseta c) {
	this.casetas.add(c);
}
public String getNumeroCalle() {
	return calle;
}
public void setNumeroCalle(String calle) {
	this.calle = calle;
}
public Caseta getCasetas(String calle) {
	Caseta aux=new Caseta(calle);
	int posicion=this.casetas.indexOf(aux);
	if (posicion==-1) {
		return null;
	}else {
		return this.casetas.get(posicion);
	}
	
}
public void setCasetas(List<Caseta> casetas) {
	this.casetas = casetas;
}
@Override
public String toString() {
	return "Calle [numeroCalle=" + calle + ", casetas=" + casetas + "]";
}
public String mostrarCasetasCalle(String calle) {
	StringBuilder resultado=new StringBuilder();
	for (Caseta siguiente:this.casetas) {
		if (siguiente.getCalle().equals(calle)) {
			resultado.append(siguiente);
		}
	}
	return resultado.toString();
}
public String mostrarFamiliar() {
	StringBuilder aux=new StringBuilder();
	for (Caseta siguiente:this.casetas) {
		if (siguiente.getClase().toUpperCase().equals("FAMILIAR")) {
			aux.append(siguiente);
		}
	}
	return aux.toString();
}
public String mostrarDistrito() {
	StringBuilder aux=new StringBuilder();
	for (Caseta siguiente:this.casetas) {
		if (siguiente.getClase().toUpperCase().equals("DISTRITO")) {
			aux.append(siguiente);
		}
	}
	return aux.toString();
}
public String mostrarDistintoFamiliarYDistrito() {
	StringBuilder aux=new StringBuilder();
	for (Caseta siguiente:this.casetas) {
		if (!"DISTRITO".equalsIgnoreCase(siguiente.getClase().toUpperCase())&&!"FAMILIAR".equalsIgnoreCase(siguiente.getClase().toUpperCase())) {
			aux.append(siguiente);
		}
	}
	return aux.toString();
}
public boolean eliminarCaseta(String idCaseta) throws CalleException {
	boolean eliminado=false;
	Caseta aux=new Caseta(idCaseta);
	int posicion=this.casetas.indexOf(aux);
	if (posicion!=-1) {
		this.casetas.remove(posicion);
		eliminado=true;
	}else {
		throw new CalleException("Error, no se encuentra la caseta");
	}
	return eliminado;
	
}
@Override
public int hashCode() {
	return Objects.hash(calle);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Calle other = (Calle) obj;
	return Objects.equals(calle, other.calle);
}

}
