package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;

public class Main {
public static Scanner teclado=new Scanner(System.in);

	public static void main(String[] args) {
		
		Series series = new Series();
		try {
			
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.DRAMA);
			series.annadirSerie("Dallas", 1970, Tema.DRAMA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niñatos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Casi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			System.out.println(series);
			series.listadoOrdenadoSeriesDeUnTema(Tema.DRAMA);
			System.out.println(series);
//			escribirEnFicheroSeries("ficheros\\FicherosSeries.csv", series);
//			series.escribeTemporada("ficheros\\ficheroTemporada.csv");
//			series.escribeCapitulo("ficheros\\ficheroCapitulos.csv");
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	private static void escribirEnFicheroSeries(String nombre,Series s) {
		try {
		FileWriter flujoEscritura=new FileWriter(nombre);
		PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
		filtroEscritura.println(s.escribeSerie());
		filtroEscritura.close();
		flujoEscritura.close();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
		}
	
	
}
