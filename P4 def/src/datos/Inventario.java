package datos;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventario {

	private ArrayList<Producto> productos;

	@XmlElement(name = "Producto")
	public ArrayList<Producto> getProductos() {
		if (productos == null) {
			productos = new ArrayList<Producto>();
		}
		return productos;
	}

	public void setProducto(ArrayList<Producto> prod) {
		productos = prod;
	}

}
