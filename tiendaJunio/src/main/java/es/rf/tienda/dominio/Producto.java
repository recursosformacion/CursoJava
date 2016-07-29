package es.rf.tienda.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.rf.tienda.exception.DomainException;

@SuppressWarnings("serial")
@Entity
@Table(schema = "ALUMNO")
public class Producto implements Serializable {

	@Id
	private String codigo;
	private String descripcion;
	private String descripcionLarga;
	private double precio;
	private int disponibilidad;
	private Date fecReposicion;
	private Date fecActivacion;
	private Date fecDesactivacion;

	@ManyToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	private int idCategoria;

	private int cantidadStock;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Date getFecReposicion() {
		return fecReposicion;
	}

	public void setFecReposicion(Date fecReposicion) throws DomainException {
		this.fecReposicion = fecReposicion;
	}

	public Date getFecActivacion() {
		return fecActivacion;
	}

	public void setFecActivacion(Date fecActivacion) {
		this.fecActivacion = fecActivacion;
	}

	public Date getFecDesactivacion() {
		return fecDesactivacion;
	}

	public void setFecDesactivacion(Date fecDesactivacion) {
		this.fecDesactivacion = fecDesactivacion;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

}
