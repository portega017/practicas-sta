package pl.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import dl.Inventario;
import dl.Producto;
@Named
@ViewScoped
public class ShopBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Inventario inventario = new Inventario();
	private String altaProducto;
	private boolean render=false;
	private Consumidor cons= new Consumidor();
	
	
	public void add(Producto prod) {
		setAltaProducto(cons.altaProducto(prod));
		inventario=null;
		setRender(true);
	}
	public List<Producto> getProds(){
		if(inventario.getProductos().size()==0)
			inventario=cons.getInventario();
		return inventario.getProductos();
	}
	
	public HashSet<String> getTipos(){
		HashSet<String> hs = new HashSet<String>();
		
		
		hs.add("Electrónica");
		hs.add("Música");
		hs.add("Ropa");
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
