package com.jacaranda.country;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Country {
	private int country_id;
	private String country;
	private List<City> ciudades;

	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.ciudades = new LinkedList<>();
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public City getCiudad(int city_id) {
		City aux = new City(city_id, null);
		int posicion = this.ciudades.indexOf(aux);
		if (posicion==-1) {
			return null;
		}else {
			return this.ciudades.get(posicion);
		}
		
	}

	public void addCity(int city_id, String city) {
		City aux=new City(city_id,city);
		int posicion=this.ciudades.indexOf(aux);
		if (posicion==-1) {
			this.ciudades.add(aux);
		}
	}
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", ciudades=" + ciudades + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return country_id == other.country_id;
	}

	
	
}
