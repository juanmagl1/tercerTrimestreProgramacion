package PlataformaOnline.jacaranda.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Series {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	
	/** Añade una serie a la lista de series. Si existe una serie con el mismo nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	
	/** Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}
	
	
	/** Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}
	
	
	/** Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}
	
	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		Serie aux=this.mapSeries.get(nombreSerie);
		int numeroTemporadas=0;
		if (aux==null) {
			throw new SerieException("No se encuentra la serie");
		}else {
			numeroTemporadas=aux.numeroTemporadas();
		}
		return numeroTemporadas;
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		Serie aux=this.mapSeries.get(nombreSerie);
		aux.setTema(nuevoTema);
		
		
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		StringBuilder resultado=new StringBuilder();
		ArrayList<Serie> valores =new ArrayList<>();
		for (Serie c:this.mapSeries.values()) {
			if (c.getTema().equals(tema)) {
				valores.add(c);
			}else {
				throw new SerieException("No est� el tema");
			}
		}
		OrdenaAnno a=new OrdenaAnno();
		Collections.sort(valores, a);
		for (Serie i:valores) {
			resultado.append(i+" ");
		}
		return resultado.toString();
	}
	
	public String escribeSerie() {
		StringBuilder resultado=new StringBuilder();
		ArrayList<Serie> siguiente=new ArrayList<>(this.mapSeries.values());
	
		for (Serie s:siguiente){
			resultado.append(s.getNombreSerie()+","+s.getAnno()+","+s.getTema()+ "\n");
	}
	return resultado.toString();
}
	public String escribeTemporada(String fichero) {
		StringBuilder resultado=new StringBuilder();
		ArrayList<Serie> siguiente=new ArrayList<>(this.mapSeries.values());
		try {
			FileWriter flujoEscritura=new FileWriter(fichero);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			for (Serie s:siguiente) {
				filtroEscritura.println(s.escribeFicheroTemporada());
			}
			
			filtroEscritura.close();
			flujoEscritura.close();
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
	return resultado.toString();
}
	public String escribeCapitulo(String fichero) {
		StringBuilder resultado=new StringBuilder();
		ArrayList<Serie> siguiente=new ArrayList<>(this.mapSeries.values());
		try {
			FileWriter flujoEscritura=new FileWriter(fichero);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			for (Serie s:siguiente) {
				resultado.append(s.getNombreSerie()+","+s.escribeFicheroCapitulos()+"\n");
			}
			filtroEscritura.println(resultado.toString());
			filtroEscritura.close();
			flujoEscritura.close();
			} catch (IOException e) {
			System.out.println(e.getMessage());
			}
		for (Serie s:siguiente){
			resultado.append(s.escribeFicheroTemporada()+ "\n");
	}
	return resultado.toString();
}
}