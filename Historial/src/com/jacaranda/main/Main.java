package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.paginaweb.Historial;
import com.jacaranda.paginaweb.HistorialException;
import com.jacaranda.paginaweb.PaginaWebException;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	static Historial h1 = new Historial();

	public static void main(String[] args) {
		// TODO document why this method is empty
		System.out.println("Nuestro historial");
		int opc;
		
		do {
			System.out.println(menu());
			System.out.println("Introduzca una opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1: {
				System.out.println("Introduce el nombre de la pagina");
				String pagina=teclado.nextLine();
				try {
					h1.addPagina(pagina);
					System.out.println(h1);
				} catch (PaginaWebException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HistorialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				System.out.println(h1.toString());
				break;
			}
			case 4: {
				h1.delHistorial();
				System.out.println("Historial borrado");
				System.out.println(h1);
				break;
			}
			case 5: {
				System.out.println("Saliendo");
				break;
			}
			default:
				System.out.println("Error");
			}

		} while (opc != 5);
	}

	public static String menu() {
		return ("1. Nueva página consultada: Se solicitará el nombre de la página y se tomará la\r\n"
				+ "fecha y hora del sistema insertándola en el historial. No se permitirá introducir\r\n"
				+ "una fecha y hora anterior a la última almacenada.\r\n" + "2. Consultar historial completo.\r\n"
				+ "3. Consultar historial de un día.\r\n" + "4. Borrar");
	}
}
