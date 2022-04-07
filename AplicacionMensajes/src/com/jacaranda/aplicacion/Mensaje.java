package com.jacaranda.aplicacion;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje implements Comparable<Mensaje>{
	private int codigo;
	private static int codSiguiente = 1;
	private String remitente;
	private String destinatario;
	private String texto;
	private LocalDateTime fecha;

	public Mensaje(String remitente,String destinatario, String texto) throws MensajeException {
		super();
		this.setRemitente(remitente);
		this.destinatario=destinatario;
		this.setTexto(texto);
		this.fecha = LocalDateTime.now();
		this.codigo = codSiguiente++;
	}
	

	public Mensaje(String texto) throws MensajeException {
		super();
		this.setTexto(texto);
		this.fecha = LocalDateTime.now();
		this.codigo = codSiguiente++;
		this.remitente="";
	}


	public String getRemitente() {
		return remitente;
	}
	

	public String getDestinatario() {
		return destinatario;
	}


	public void setRemitente(String remitente) throws MensajeException {
		if (remitente == null) {
			throw new MensajeException("El remitente no puede ser nulo");
		} else {
			this.remitente = remitente;
		}

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) throws MensajeException {
		if (texto == null) {
			throw new MensajeException("El texto no puede ser nulo");
		}else {
			this.texto = texto;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public static int getCodSiguiente() {
		return codSiguiente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		
		return "Mensaje " + codigo + ":"+"De: " + remitente + " Texto: " + texto + ", Fecha y hora" + fecha;
	}

	@Override
	public int compareTo(Mensaje o) {
		int resultado=0;
		if (o==null) {
			resultado=-1;
		}else {
			resultado=this.fecha.compareTo(o.getFecha());
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fecha, remitente, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return codigo == other.codigo && Objects.equals(fecha, other.fecha)
				&& Objects.equals(remitente, other.remitente) && Objects.equals(texto, other.texto);
	}

}
