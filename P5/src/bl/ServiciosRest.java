package bl;


import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import dl.Ficheros;
import dl.Inventario;
import dl.Producto;

@Path("/apiRest")
public class ServiciosRest {
	private final String protocoloProveedor = MediaType.APPLICATION_JSON;

	@GET
	@Produces(protocoloProveedor)
	@Path("/getprods")
	public Inventario getInventario() {
		Ficheros db = new Ficheros();
		try {
			return db.cargaData();
		} catch (JAXBException e) {
			return new Inventario();
			// TODO: handle exception
		}

	}

	@POST
	@Consumes(protocoloProveedor)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/altaprod")
	public String darAlta(Producto prod) throws JAXBException {
		Ficheros db = new Ficheros();
		try {
			if (prod != null) {
				db.guardar(prod);
				return "El producto " + prod.getNombre() + " con precio " + prod.getPrecio()
						+ "€ ha sido dado de alta en la categoria " + prod.getTipo();
			} else {
				return "No hay producto para dar de alta";
			}
		} catch (JAXBException e) {
			return "No se ha podido dar de alta el producto";
		} catch (IOException e) {
			return "IOException";
		}
	}
	
	public String getProtocoloProveedor() {
		return protocoloProveedor;
	}

}
