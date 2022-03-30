package com.jacaranda.paginaweb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Historial {
	private List<PaginaWeb> paginas;

	public Historial() {
		super();
		this.paginas = new ArrayList();
	}

	private boolean existePagina(String url) {
		boolean resultado = false;
		Iterator<PaginaWeb> siguiente = paginas.iterator();
		while (siguiente.hasNext() && !resultado) {
			PaginaWeb p1 = siguiente.next();
			if (p1.getUrl().equalsIgnoreCase(url)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean addPagina(String url) throws PaginaWebException, HistorialException {
		boolean resultado = false;
		if (url == null) {
			throw new HistorialException("La url no puede ser negativa");
		}
		if (!existePagina(url)) {
			PaginaWeb p1 = new PaginaWeb(url);
			this.paginas.add(p1);
			resultado = true;
		} else {
			throw new HistorialException("La pagina ya existe");
		}
		return resultado;

	}

	@Override
	public String toString() {
		return "Historial [paginas=" + paginas + "]";
	}

	public void delHistorial() {
		this.paginas.removeAll(paginas);
	}
	public String consultarHistorial(LocalDateTime dia) {
		boolean resultado=false;
		StringBuilder cadena = new StringBuilder("");
		Iterator<PaginaWeb> siguiente = paginas.iterator();
		while (siguiente.hasNext() && !resultado) {
			PaginaWeb p1 = siguiente.next();
			if (p1.getHora().equals(dia)) {
				cadena.append(p1);
				resultado = true;
			}
		}
		return cadena.toString();
	}
}
