package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Ficheros;
import datos.Inventario;
import datos.Producto;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		DarAlta.errorEnAlta(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Producto prod = new Producto();

		prod.setTipo(request.getParameter("tipo"));
		prod.setPrecio(request.getParameter("precio") + ".00 €");
		prod.setDescripcion(request.getParameter("descripcion"));

		DarAlta.printAlta(out, prod.getDescripcion(), prod.getTipo(), prod.getPrecio());

		Inventario invent2 = Ficheros.JSONToArray();
		Inventario invent = Ficheros.XmlToArray();

		ArrayList<Producto> listaProd2 = invent2.getProductos();
		ArrayList<Producto> listaProd = invent.getProductos();

		int num = listaProd.size() + 1;

		String referencia = generanumRef(request, num);
		prod.setReferencia(referencia);

		listaProd.add(prod);
		listaProd2.add(prod);

		invent.setProducto(listaProd);
		invent2.setProducto(listaProd2);

		Ficheros.ArrayToJSON(invent2);
		Ficheros.ArrayToXml(invent);

	}

	public static String generanumRef(HttpServletRequest request, int numElem) {
		String ref = "";
		String numRef = "";
		if (request.getParameter("tipo").equals("DVD")) {
			numRef = "01000";

		} else if (request.getParameter("tipo").equals("Música")) {
			numRef = "12200";
		} else if (request.getParameter("tipo").equals("Ropa")) {
			numRef = "23400";
		} else if (request.getParameter("tipo").equals("Electrónica")) {
			numRef = "34600";
		} else if (request.getParameter("tipo").equals("Libro")) {
			numRef = "45800";
		} else if (request.getParameter("tipo").equals("Muebles")) {
			numRef = "57000";
		}
		if (numElem > 9 && numElem < 100) {
			int reftmp;
			reftmp = Integer.parseInt(numRef);
			reftmp=reftmp/10;
			numRef = String.valueOf(reftmp);
		} /*
			 * if (numElem > 99 && numElem < 1000) { int reftmp; reftmp =
			 * Integer.parseInt(numRef); reftmp=reftmp/100; numRef = String.valueOf(reftmp);
			 * }
			 */
		ref = numRef + "0"+String.valueOf(numElem);
		return ref;

	}

}
