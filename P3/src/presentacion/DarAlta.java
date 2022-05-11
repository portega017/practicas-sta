package presentacion;

import java.io.PrintWriter;

public class DarAlta {

	public static void printAlta(PrintWriter out, String descripcion, String tipo, String precio) {
		out.println(PresentacionHTML.DOCTYPE);
		out.println(
				PresentacionHTML.CabecerasConCssYCuerpo("Nuevo Producto", "estilo.css", "<h1 class=\"Alta\">Artículo "
						+ descripcion + " dado de alta en " + tipo + " con precio " + precio + "</h1>"));
		out.println(PresentacionHTML.CIERRE);
		out.close();
	}

	public static void errorEnAlta(PrintWriter out) {
		out.println(PresentacionHTML.DOCTYPE);
		out.println(PresentacionHTML.CabecerasConCssYCuerpo("ERROR","estilo.css","<h1 class=\"Alta\">Error, la página debe accederse por POST</h1>"));
		out.println(PresentacionHTML.CIERRE);
		out.close();

	}
}