package com.jacaranda.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jacaranda.caseta.Calle;
import com.jacaranda.caseta.CalleException;
import com.jacaranda.caseta.Caseta;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static ArrayList<Calle> casetas = new ArrayList<>();

	public static void main(String[] args) throws CalleException {
		cargarCasetas();
		for (Calle s:casetas) {
			System.out.println(s);
		}

		int opc = 0;
		do {
			System.out.println(menu());
			System.out.println("Introduzca una opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1: {
				System.out.println("Dime el nombre de la calle");
				String calle =teclado.nextLine();
				boolean encontrado=false;
				Iterator <Calle> siguiente=casetas.iterator();
				while (siguiente.hasNext()&&!encontrado) {
					Calle aux=siguiente.next();
					if (aux.getCalle().equals(calle)) {
						encontrado=true;
						System.out.println(aux.mostrarCasetasCalle(calle));
					}
				}
				break;
			}
			case 2: {
				for (Calle c:casetas) {
					System.out.println(c.mostrarFamiliar());
				}
				break;
			}
			case 3: {
				for (Calle c:casetas) {
					System.out.println(c.mostrarDistrito());
				}
				break;
			}
			case 4: {
				for (Calle c:casetas) {
					System.out.println(c.mostrarDistintoFamiliarYDistrito());
				}
				break;
			}
			case 5: {
				for (Calle c:casetas) {
					System.out.println(c.mostrarFamiliar());
				}
				break;
			}
			case 6: {
				for (Calle c:casetas) {
					System.out.println(c.mostrarDistrito());
				}
				break;
			}
			case 7: {
				
				System.out.println("Introduce el nombre de la caseta");
				String caseta=teclado.nextLine();
				System.out.println("Introduce el nombre de la calle");
				String calle=teclado.nextLine();
				boolean encontrado=false;
				Iterator <Calle> s=casetas.iterator();
				while (s.hasNext()&&!encontrado) {
					Calle aux=s.next();
					if (aux.getCalle().equals(calle)) {
						encontrado=true;
						aux.eliminarCaseta(caseta);
					}
				}
				break;
			}
			case 8: {
				System.out.println("Saliendo");
				break;
			}

			default:
				throw new IllegalArgumentException("Error");
			}
		} while (opc != 8);
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
					int posicion = casetas.indexOf(aux);
					if (posicion == -1) {
						casetas.add(aux);
					} else {
						Calle aux1 = casetas.get(posicion);
						aux1.annadirCaseta(c);
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String menu() {
		return ("1. Mostrar todas las casetas existentes en una calle. \r\n" + "\r\n"
				+ "2. Mostrar todas las casetas de tipo familiar. \r\n" + "\r\n"
				+ "3. Mostrar todas las casetas de tipo Distrito \r\n" + "\r\n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \r\n" + "\r\n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen. \r\n"
				+ "\r\n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen. \r\n"
				+ "\r\n" + "7. Eliminar una caseta.\r\n" + "\r\n" + "8. Salir.");
	}
}
