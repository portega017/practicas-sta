package datos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producto {
private String precio;
private String tipo;
private String descripcion;
private String referencia;
/*
public  Producto(String referencia,String tipo,String descripcion,String precio) {
	super();
	this.referencia=referencia;
	this.tipo=tipo;
	this.descripcion=descripcion;
	this.precio=precio;
}*/

@XmlElement(name="precio")
public String getPrecio() {
	return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
@XmlElement(name="tipo")
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
@XmlElement(name="descripcion")
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
@XmlElement(name="referencia")
public String getReferencia() {
	return referencia;
}
public void setReferencia(String referencia) {
	this.referencia = referencia;
}



}
