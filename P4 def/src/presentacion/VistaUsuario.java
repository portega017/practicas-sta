package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import datos.Ficheros;
import datos.Inventario;
import datos.Producto;

public class VistaUsuario {

	public static void muestraUsuario(PrintWriter out) throws IOException {
		out.println(PresentacionHTML.DOCTYPE);
		out.println(PresentacionHTML.CabecerasConCss("Página de Usuario", "estilo.css"));

		//Inventario invent = Ficheros.JSONToArray();
		Inventario invent = Ficheros.XmlToArray();

		ArrayList<Producto> listaProd = invent.getProductos();
		int lineas = (listaProd.size());
		out.println(
				"<h1>Bienvenido a la tienda online</h1> <table border='1'><tr><th>Nº de Referencia</th><th>Tipo de Producto</th><th>Descripción</th><th>Precio</th></tr>");
		ArrayList<String> lista = Ficheros.pasarDatosToArray(listaProd);

		out.println(GeneraTabla.crearTabla(lista, lineas));
		

		out.println("</table>");
		out.println(PresentacionHTML.CIERRE);
	}
}
