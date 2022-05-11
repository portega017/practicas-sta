package pl.modelo;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dl.Producto;

@Named
@RequestScoped
public class ProductBean implements Serializable{
	
	private final Producto entity = new Producto();
	private static final long serialVersionUID = 1L;
	
	public Producto getEntity() {
		return entity;
	}

}