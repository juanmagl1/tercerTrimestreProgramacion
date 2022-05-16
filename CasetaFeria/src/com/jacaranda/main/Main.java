package com.jacaranda.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jacaranda.caseta.Calle;
import com.jacaranda.caseta.Caseta;

public class Main {
	public static ArrayList<Calle> casetas = new ArrayList<>();

	public static void main(String[] args) {
		cargarCasetas();
		for (Calle siguiente : casetas) {
			System.out.println(siguiente);
		}

	}

	public static void cargarCasetas() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("fichero//caseta.xml");
			// Normalizamos el documento
			doc.getDocumentElement().normalize();
			// Tenemos que obtener la lista de nodos
			NodeList listaCaseta = doc.getElementsByTagName("DatosLeidos");
			// Y recorrer los nodos
			for (int i = 0; i < listaCaseta.getLength(); i++) {
				// Cogemos el nodo coche
				Node hijo = listaCaseta.item(i);
				// Si el nodo es de tipo elemento, lo obtenemos
				if (hijo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) hijo;
					// Si queremos obtener un atributo del elemento.
					System.out.println("id: " + element.getAttribute("id"));
					String titulo = element.getElementsByTagName("TITULO").item(0).getTextContent();
					String calle = element.getElementsByTagName("CALLE").item(0).getTextContent();
					int numero = Integer.parseInt(element.getElementsByTagName("NUMERO").item(0).getTextContent());
					int modulo = Integer.parseInt(element.getElementsByTagName("MODULOS").item(0).getTextContent());
					String clase = element.getElementsByTagName("CLASE").item(0).getTextContent();
					int id = Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent());
					int id_Calle = Integer.parseInt(element.getElementsByTagName("ID_CALLE").item(0).getTextContent());
					Calle aux = new Calle(calle);
					Caseta c = new Caseta(titulo, calle, numero, modulo, clase, id, id_Calle);
					int posicion=casetas.indexOf(aux);
					if (posicion==-1) {
						casetas.add(aux);
					}else {
						Calle aux1=casetas.get(posicion);
						aux1.annadirCaseta(c);
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
