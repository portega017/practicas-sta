package datos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class Ficheros {
	public static ArrayList<Producto> productos = new ArrayList<>();
	private static String nomFichXml = "/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 final/productos.xml";
	private static String nomFichJSON = "/home/pibol/Documentos/UNI/STA/practicas-portega017/P4 final/productos.json";

	public static void ArrayToXml(Inventario inventario) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Inventario.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(inventario, new File(nomFichXml));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Inventario XmlToArray() {
		Inventario inventario = new Inventario();
		// Deserializar
		File f = new File(nomFichXml);
		if (f.exists()) {
			try {
				JAXBContext jaxbcontext = JAXBContext.newInstance(Inventario.class);
				Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
				inventario = (Inventario) unmarshaller.unmarshal(f);

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return inventario;

	}

	// Función práctica 4
	public static Inventario JSONToArray() {
		Inventario inventario = new Inventario();
		// Deserializar
		File f = new File(nomFichJSON);
		if (f.exists()) {
			try {
				JAXBContext jaxbcontext = JAXBContext.newInstance(Inventario.class);
				Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
				unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
				inventario = (Inventario) unmarshaller.unmarshal(f);

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return inventario;
	}

	public static void ArrayToJSON(Inventario inventario) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Inventario.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");// apartado 1.3 JSON
			marshaller.marshal(inventario, new File(nomFichJSON));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static ArrayList<String> pasarDatosToArray(ArrayList<Producto> productos) throws IOException {
		ArrayList<String> datos = new ArrayList<String>();
		int numLineas = productos.size();
		for (int i = 0; i < numLineas; i++) {
			datos.add(productos.get(i).getReferencia() + "," + productos.get(i).getTipo() + ","
					+ productos.get(i).getDescripcion() + "," + productos.get(i).getPrecio());

		}
		return datos;
	}

}
