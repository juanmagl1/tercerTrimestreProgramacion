package Principal;

import java.util.LinkedList;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main2 {

	public static void main(String[] args) {
		Temporada t1=new Temporada("Primera");
		t1.annadirCapitulo("Capitulo1");
		t1.annadirCapitulo("Capitulo4");
		try {
			t1.anadirCapituloDespues("Capitulo2", "Capitulo1");
			
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
