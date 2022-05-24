package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenaAnno implements Comparator<Serie> {

	@Override
	public int compare(Serie o1, Serie o2) {
		int numero=o1.getAnno()-o2.getAnno();
		return numero;
	}



}
