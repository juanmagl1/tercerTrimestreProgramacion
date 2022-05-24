package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenaCapitulos implements Comparator<Temporada> {
//Esta clase se crea para ordenar por numero de capitulos
	@Override
	public int compare(Temporada o1, Temporada o2) {
		int numero=o1.numeroCapitulos()-o2.numeroCapitulos();
		return numero;
	}

}
