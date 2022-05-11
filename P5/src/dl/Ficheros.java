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

public class Ficheros {
	private final String nomFich = "/home/pibol/Inventario.xml";
	private File fich = new File(nomFich);
	private final String protocoloAlmacenamiento = MediaType.APPLICATION_XML;

	public void guardar(Producto prod) throws JAXBException, IOException {
		Inventario inv = new Inventario();
		JAXBContext jaxbContext = JAXBContext.newInstance(Inventario.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, protocoloAlmacenamiento);

		if (fich.createNewFile()) {
			prod.setReferencia("1");
		} else {
			inv = (Inventario) unmarshaller.unmarshal(fich);
			prod.setReferencia(String.valueOf(inv.getProductos().size() + 1));
		}
		inv.getProductos().add(prod);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, protocoloAlmacenamiento);
		marshaller.marshal(inv, fich);
	}

	public Inventario cargaData() throws JAXBException {
		Inventario inv = new Inventario();
		JAXBContext jaxbContext = JAXBContext.newInstance(Inventario.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, protocoloAlmacenamiento);
		if (fich.exists()) {
			inv = (Inventario) unmarshaller.unmarshal(fich);

		} else {
			inv = new Inventario();

		}
		return inv;
	}

	public File getFichero() {
		return fich;
	}

	public void setFichero(File fich) {
		this.fich = fich;
	}

	public String getFichname() {
		return nomFich;
	}

}