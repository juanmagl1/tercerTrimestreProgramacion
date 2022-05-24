import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void main(String[] args) {
		String fichero = leerFicheroPorLineas("jsons\\prueba2.json");
		System.out.println(fichero);
		Gson gson = new Gson();
		// Para obtener cada una de las propiedad del objeto
		// Recordad que no funcionario si tenemos un array.
//		Properties properties = gson.fromJson(fichero, Properties.class);
//		// Mostrarmos cada una de las propiedades.
//		System.out.println(properties.get("nombre"));
//		System.out.println(properties.get("apellidos"));
//		System.out.println(properties.get("edad"));

		// Con una clase
//		Persona p1=gson.fromJson(fichero, Persona.class);
//		System.out.println((p1));
		// Con un arrayList
		ArrayList<Persona> personas = gson.fromJson(fichero, new TypeToken<ArrayList<Persona>>() {
		}.getType());
		for (Persona p : personas) {
			System.out.println(p.toString());
		}
		Persona p1 = new Persona("Pepe", "perez", 33);
		personas.add(p1);
		personas.remove(0);
		// Para escribir en ficheros
//		String salida = gson.toJson(personas);
//		System.out.println(salida);
		//Para ponerlo de forma bonita
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String salida= prettyGson.toJson(personas);
		escribirEnFicheroJson("jsons\\prueba3.json", salida);
	}

	// leemos el fichero por una linea y despues lo añado en un stringbuilder
	private static String leerFicheroPorLineas(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				System.out.println(linea);
				resultado.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}

	private static void escribirEnFicheroJson(String nombre, String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
