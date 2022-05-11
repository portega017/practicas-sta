package negocio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import datos.Ficheros;
import datos.Inventario;
import datos.Producto;



@Path("/serviciosRest")
public class ServiciosRest{ 

@GET
@Path("/proveedor/listadoJSON")
@Produces(MediaType.APPLICATION_JSON)
public Response listar1(){
	String path="/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 def/productos.json";	
	Inventario inventario= new Inventario();
	inventario=Ficheros.JSONToArray();
	ResponseBuilder response=Response.ok(inventario);
	//response.header("Content-Disposition","attachment;filename=Inventario.json");
	//Si pongo response.header me descargar un fichero con los datos
	return response.build();
}

@GET
@Path("/proveedor/listadoXML")
@Produces(MediaType.APPLICATION_XML)
public Response listar2(){
	String path="/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 def/productos.xml";	
	Inventario inventario= new Inventario();
	inventario=Ficheros.XmlToArray();
	ResponseBuilder response=Response.ok(inventario);
	//response.header("Content-Disposition","attachment;filename=Inventario.json");
	//Si pongo response.header me descargar un fichero con los datos
	return response.build();
}

@POST
@Path("/consumidor/formularioJSON")
@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
public void guardarFicheroJSON(Producto p){	
	String path="/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 def/productos.json";
	Inventario inventario= Ficheros.JSONToArray();
	inventario.getProductos().add(p);
	Ficheros.ArrayToJSON(inventario);		
	
}

@POST
@Path("/consumidor/formularioXML")
@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
public void guardarFicheroXML(Producto p){	
	String path="/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 def/productos.xml";
	Inventario inventario= Ficheros.XmlToArray();
	inventario.getProductos().add(p);
	Ficheros.ArrayToXml( inventario);		
	
}



}