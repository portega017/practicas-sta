package pl.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBException;

import bl.LogicaNegocio;
import dl.Producto;
import dl.Productos;

@Named
@ViewScoped
public class ShopBean implements Serializable {

	@EJB
	private LogicaNegocio ln = new LogicaNegocio();
	private Productos productos = new Productos();
	private String altaProducto;
	private Boolean render = false;
	private static final long serialVersionUID = 1L;
	
	@RolesAllowed("admin")
	public void add(Producto p) {
		try {
			setAltaProducto(ln.altaProducto(p));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		productos=null;
		setRender(true);
	}
	
	public List<Producto> getProds() {
		if(productos.getProductos().size() == 0)
			productos = ln.getProductos();
		return productos.getProductos();	
	}
	
	public HashSet<String> getTipos(){
		HashSet<String> hs = new HashSet<String>();
		/*
		List<String> tipos = new ArrayList<String>();
		List<Producto> lp = getProds();
		
		for(int i=0;i<lp.size();i++) {
			tipos.add(lp.get(i).getTipo());
		}
		
		return new HashSet<String>(tipos);
		*/
		
		hs.add("Electrónica");
		hs.add("Motor");
		hs.add("Libros");
		
		
		return hs;
	}

	public String getAltaProducto() {
		return altaProducto;
	}

	public void setAltaProducto(String altaProducto) {
		this.altaProducto = altaProducto;
	}

	public boolean getRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}
	
}
