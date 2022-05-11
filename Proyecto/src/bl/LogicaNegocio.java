package bl;


import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import dl.Database;
import dl.Producto;
import dl.Productos;


@Stateless
@LocalBean
public class LogicaNegocio {

	private final String protocoloProveedor = MediaType.APPLICATION_JSON;	

	public Productos getProductos() {
		Database db = new Database();
		try {
			return db.cargaDatos();
		}catch (JAXBException e) {
			return new Productos();
		}
	}
	
	public String altaProducto(Producto p) throws JAXBException {
		Database db = new Database();
		try {
			if(p != null) {
				db.escribir(p);
				return "El producto " + p.getNombre() + " con precio " + p.getPrecio() + "€" + " ha sido dado de alta en la categoria " + p.getTipo();
			}else {
				return "No hay producto para dar de alta";
			}
			
		}catch (JAXBException e){
			return "No se ha podido dar de alta el producto";
		}catch (IOException e) {
			return "IOException";
		}
	}

	public String getProtocoloProveedor() {
		return protocoloProveedor;
	}
}
