package PlataformaOnline.jacaranda.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Serie {
	private static final int ANNO_MINIMO = 1900; // Sólo se almacenrará series posteriores a 1900
	private String nombreSerie; // Nombre de la serie
	private int anno; // Año de la primera temporada de la serie
	private Tema tema; // Tema de la serie
	private ArrayList<Temporada> temporadas; // Lista de las temporadas de las series.

	/**
	 * Constructor que recibe el nombre de la serie, el año de creación y el tema.
	 * Se crea la serie sin ninguna temporada
	 * 
	 * @param nombreSerie
	 * @param anno
	 * @param tema
	 * @throws SerieException: si el año es anterior a 1900 se lanzará una
	 *                         exception
	 */
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas = new ArrayList<Temporada>();
		// Hemos elegido el LinkedList, porque nos importa el orden
		// Y podemos tener valores repetidos y vamos a meter objetos en el medio

	}

	/**
	 * Añade una nueva temporada. Se le pasará el nombre de la nueva temporada y
	 * se añadirá al final. Debe comprobar que no existe un temporada con ese
	 * nombre en cuyo caso saltará la excepción.
	 * 
	 * @param nombreTemporada
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreTemporada) throws SerieException {
		Temporada t1 = new Temporada(nombreTemporada);
		int posicion = this.temporadas.indexOf(t1);
		if (posicion == -1) {
			this.temporadas.add(t1);
		} else {
			throw new SerieException("La temporada ya existe");
		}

	}

	/**
	 * Añade un nuevo capítulo a una temporada. Se le pasará el nombre de la
	 * temporada y si la temporada no existe se lanzará una exception
	 * 
	 * @param nombreTemporada
	 * @param nombreCapitulo
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreTemporada, String nombreCapitulo) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).annadirCapitulo(nombreCapitulo);
	}

	/**
	 * Valorar temporada. Si no exsite la temporada lanza una exception.
	 * 
	 * @param nombreTemporada
	 * @param valoracion
	 * @throws SerieException
	 */

	public void valorarTemporada(String nombreTemporada, int valoracion) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).valorar(valoracion);

	}

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de mayor a menor
	 * por nota media. De cada temporada se mostrará el nombre, número de
	 * capítulos y nota media
	 * 
	 * @return
	 */
	public String listadoTemporadasPorNotaMedia() {
		StringBuilder resultado = new StringBuilder();
		OrdenaMayorAMenor a = new OrdenaMayorAMenor();
		Collections.sort(this.temporadas, a);
		for (Temporada c : this.temporadas) {
			resultado.append(c.getNombreTemporada() + c.numeroCapitulos() + c.getNotaMedia() + "\n");
		}
		return resultado.toString();
	}

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor
	 * por número de capítulos. De cada temporada se mostrará el nombre, número
	 * de capítulos y nota media.
	 * 
	 * @return
	 */
	public String listadoTemporadasPorNumeroDeCapitulos() {
		StringBuilder resultado = new StringBuilder();
		OrdenaCapitulos c = new OrdenaCapitulos();
		Collections.sort(this.temporadas, c);
		for (Temporada siguiente : this.temporadas) {
			resultado.append(
					siguiente.getNombreTemporada() + siguiente.getNotaMedia() + siguiente.numeroCapitulos() + "\n");
		}
		return resultado.toString();
	}

	/**
	 * Devuelve el nombre de la Serie
	 * 
	 * @return
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}

	/**
	 * Asigna el nombre de la serie
	 * 
	 * @param nombreSerie
	 */
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	/**
	 * Devuelve el año
	 * 
	 * @return
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Asinga el año
	 * 
	 * @param anno
	 * @throws SerieException
	 */
	public void setAnno(int anno) throws SerieException {
		if (anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}

	/**
	 * Devuelve el tema
	 * 
	 * @return
	 */
	public Tema getTema() {
		return tema;
	}

	/**
	 * Asinga el tema
	 * 
	 * @param tema
	 * @throws SerieException
	 */
	public void setTema(Tema tema) throws SerieException {
		if (tema.equals(tema)) {
			throw new SerieException("El tema es el que tenia");
		}
		this.tema = tema;
	}

	/**
	 * Devuelve el número de temporadas que tiene la serie
	 * 
	 * @return
	 */
	public int numeroTemporadas() {
		return temporadas.size();
	}

	public String escribeFichero() {
		return this.nombreSerie + "," + this.anno + "," + this.tema;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "Serie " + nombreSerie + " Anno " + anno + " Tema " + tema + "Numero temporadadas " + numeroTemporadas();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}

	public String escribeFicheroTemporada() {
		StringBuilder resultado = new StringBuilder();
		resultado.append(nombreSerie);
		for (Temporada t : this.temporadas) {
			resultado.append(","+ t.escribeFichero());
		}
		return resultado.toString();
	}

	public String escribeFicheroCapitulos() {
		StringBuilder resultado = new StringBuilder();
		for (Temporada t : this.temporadas) {
			resultado.append(t.getNombreTemporada()+","+t.escribeCapitulos());
		}
		return resultado.toString();
	}

}
