package presentacion;

import java.io.IOException;
import java.util.ArrayList;


public class GeneraTabla {
	private static String abrirCol = "<td>";
	private static String cerrarCol = "</td>";
	private static String abrirFil = "<tr>";
	private static String cerrarFil = "</tr>";

	public GeneraTabla() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static String crearTabla(ArrayList<String> lista, int lineas) throws IOException {

		String s = "";
	

		for (int i = 0; i < lineas; i++) {
			s += abrirFil;
			String temp = lista.get(i);
			String[] temp2 = temp.split(",");

			for (int j = 0; j < 4; j++) {

				s += abrirCol;
				s += temp2[j];
				s += cerrarCol;
			}
			s += cerrarFil;
		}
		return s;
	}
}
