package pl.modelo;

import dl.Producto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dl.Inventario;

public class Consumidor {
	private final String altaProdUrl = "http://localhost:8080/pract5/rest/apiRest/altaprod";
	private final String getProdUrl = "http://localhost:8080/pract5/rest/apiRest/getprods";
	private final String protocoloConsumidor = MediaType.APPLICATION_JSON;

	
	@POST
	@Produces(protocoloConsumidor)
	public String altaProducto(Producto prod) {
		String cad;
		Response respuesta=ClientBuilder.newClient().target(altaProdUrl).request().post(Entity.entity(prod,protocoloConsumidor));
		if(respuesta.getStatus()==200) {
			cad=respuesta.readEntity(String.class);
			
		}else {
			cad="No se ha podido dar de alta el producto";
		}
		return cad;
	}
	
	@GET
	@Consumes(protocoloConsumidor)
	public Inventario getInventario() {
		return ClientBuilder.newClient().target(getProdUrl).request(protocoloConsumidor).get(Inventario.class);
	}
	public String getAltaProdURL() {
		return altaProdUrl;
	}
	
	public String getGetProdUrl() {
		return getProdUrl;
	}
	public String getProtocoloConsumidor() {
		return protocoloConsumidor;
	}
	
	
	
	
}
