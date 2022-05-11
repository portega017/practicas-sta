package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Ficheros;
import modelo.Producto;

public class VistaUsuario {

	public static void muestraUsuario(PrintWriter out) throws IOException {
		out.println(PresentacionHTML.DOCTYPE);
		out.println(PresentacionHTML.CabecerasConCss("Página de Usuario", "estilo.css"));
		
		

		int lineas = modelo.Ficheros.cuentaLineas();
		ArrayList<Producto> listaProd = Ficheros.obtenerDatos();
		out.println("<h1>Bienvenido a la tienda online</h1> <table border='1'><tr><th>Nº de Referencia</th><th>Tipo de Producto</th><th>Descripción</th><th>Precio</th></tr>");
		ArrayList<String> lista = Ficheros.pasarDatosToArray(listaProd);
		//lista = Ficheros.leeFich();
		out.println(GeneraTabla.crearTabla(lista,lineas));

		out.println("</table>");
		out.println(PresentacionHTML.CIERRE);
	}
}