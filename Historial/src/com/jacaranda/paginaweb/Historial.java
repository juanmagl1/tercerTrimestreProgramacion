package com.jacaranda.paginaweb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jacaranda.utilities.Pueblo;

public class Historial {
	private List<PaginaWeb> paginas;

	public Historial() {
		super();
		this.paginas = new ArrayList<>();
	}

	public boolean addPagina(String url) throws PaginaWebException, HistorialException {
		boolean resultado = false;
		if (url == null) {
			throw new HistorialException("La url no puede ser negativa");
		} else {
			PaginaWeb p1 = new PaginaWeb(url);
			this.paginas.add(p1);
			resultado = true;
		}
		return resultado;

	}

	@Override
	public String toString() {
		StringBuilder cadena=new StringBuilder("");
		if (this.paginas.isEmpty()) {
			cadena.append("Vacio");
		}
		for (PaginaWeb p : this.paginas) {
			cadena.append(p);
		}
		return cadena.toString();
	}

	public void delHistorial() {
		this.paginas.removeAll(paginas);
	}

	public String consultarHistorial(LocalDateTime dia) {
		boolean salir = false;
		PaginaWeb p;
		StringBuilder cadena = new StringBuilder("");
		Iterator<PaginaWeb> siguiente = this.paginas.iterator();
		while (siguiente.hasNext()&& !salir) {
			p = siguiente.next();
			//Si ponemos este if lo que hacemos es que cuando el dia sea mas tarde que 
			//se salga del bucle
			if (p.getHora().isAfter(dia)) {
				salir=true;
			}
			if (p.getHora().getYear() == dia.getYear() && p.getHora().getMonth() == dia.getMonth()
					&& p.getHora().getDayOfMonth() == dia.getDayOfMonth()) {
				cadena.append(p);
			}
		}
		return cadena.toString();
	}
}
