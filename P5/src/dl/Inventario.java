package dl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventario implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Producto> productos;

	@XmlElement
	public List<Producto> getProductos() {
		if (productos == null) {
			productos = new ArrayList<Producto>();
		}
		return productos;
	}

	public void setProducto(List<Producto> prod) {
		productos = prod;
	}

}

