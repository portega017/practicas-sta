package dl;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;


public class Database {

	private final String fichName = "/home/839844/Productos.xml";
	private File fichero = new File(fichName);
	private final String protocoloAlmacenamiento = MediaType.APPLICATION_XML;
	
	public void escribir(Producto d) throws JAXBException, IOException {
	
		Productos p = new Productos();
		JAXBContext jaxbContext = JAXBContext.newInstance(Productos.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,protocoloAlmacenamiento);
		if(fichero.createNewFile()) {
			d.setReferencia("1");
		}else {
			p = (Productos) unmarshaller.unmarshal(fichero);
			d.setReferencia(String.valueOf(p.getProductos().size()+1));
		}
		p.getProductos().add(d);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, protocoloAlmacenamiento);
		marshaller.marshal(p, fichero);
	}
	
	public Productos cargaDatos() throws JAXBException {
		Productos p = new Productos();
		JAXBContext	jaxbContext = JAXBContext.newInstance(Productos.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, protocoloAlmacenamiento);
		if(fichero.exists()) {
			p =  (Productos) unmarshaller.unmarshal(fichero);	
		}else {
			p = new Productos();
		}
		
		return p;
	}

	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public String getFichname() {
		return fichName;
	}
	
	
}

