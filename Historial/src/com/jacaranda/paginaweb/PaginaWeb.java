package com.jacaranda.paginaweb;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
private String url;
private LocalDateTime hora;

public PaginaWeb(String url) throws PaginaWebException {
	super();
	this.setUrl(url);
	this.hora=LocalDateTime.now();
}

public String getUrl() {
	return url;
}

public void setUrl(String url) throws PaginaWebException {
	if (url==null) {
		throw new PaginaWebException("Error la pagina web no puede ser nula");
	}
	this.url = url;
}

public LocalDateTime getHora() {
	return hora;
}



@Override
public int hashCode() {
	return Objects.hash(hora, url);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PaginaWeb other = (PaginaWeb) obj;
	return Objects.equals(hora, other.hora) && Objects.equals(url, other.url);
}

@Override
public String toString() {
	return "PaginaWeb [url=" + url + ", hora=" + hora + "]";
}

}
