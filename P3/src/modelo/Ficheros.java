package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Ficheros {
	private static String nomFich = "datos.csv";
	public static ArrayList<Producto> productos = new ArrayList<>();

	public static void escribeFich(String descripcion, String tipo, String precio) throws IOException {
		File f = new File(nomFich);
		if (!f.exists()) {
			f.createNewFile();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true)); PrintWriter pw = new PrintWriter(bw);) {

			int num = cuentaLineas() + 1;

			String referencia = "0" + String.valueOf(num);

			// String referencia = GenerarRef(tipo);
			pw.println(referencia + "," + tipo + "," + descripcion + "," + precio);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static ArrayList<String> leeFich() throws IOException {
		ArrayList<String> lista = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomFich));) {
			String line;
			while ((line = br.readLine()) != null) {
				lista.add(line);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return lista;

	}

	public static void cargarFich() {
		try (BufferedReader br = new BufferedReader(new FileReader(nomFich))) {
			String line;
			String[] temp;
			while ((line = br.readLine()) != null) {
				temp = line.split(",");
				Producto product = new Producto();
				product.setReferencia(temp[0]);
				product.setTipo(temp[1]);
				product.setDescripcion(temp[2]);
				product.setPrecio(temp[3]);
				productos.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static int cuentaLineas() throws IOException {
		int numLineas = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(nomFich));) {
			@SuppressWarnings("unused")
			String line;
			while ((line = br.readLine()) != null) {
				numLineas++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return numLineas;
	}

	public static ArrayList<Producto> obtenerDatos() {
		cargarFich();
		return productos;
	}

	public static ArrayList<String> pasarDatosToArray(ArrayList<Producto> productos) throws IOException {
		ArrayList<String> datos = new ArrayList<String>();
		int numLineas = cuentaLineas();
		for (int i = 0; i < numLineas; i++) {
			datos.add(productos.get(i).getReferencia() + "," + productos.get(i).getTipo() + ","
					+ productos.get(i).getDescripcion() + "," + productos.get(i).getPrecio());

		}
		return datos;
	}

}