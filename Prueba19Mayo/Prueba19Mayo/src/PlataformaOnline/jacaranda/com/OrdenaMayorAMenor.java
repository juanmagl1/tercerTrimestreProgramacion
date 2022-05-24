package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenaMayorAMenor implements Comparator<Temporada> {
//Me he creado la clase para ordenar de mayor a menor
	@Override
	public int compare(Temporada o1, Temporada o2) {
		int numero= (int)( o1.getNotaMedia()-o2.getNotaMedia());
		return - numero;
	}

}
