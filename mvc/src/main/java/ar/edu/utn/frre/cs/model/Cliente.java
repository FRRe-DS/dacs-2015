/**
 * 
 */
package ar.edu.utn.frre.cs.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * Representa un Cliente del <b>Sistema Integral de Turismo</b>
 * 
 * @author Jorge Villaverde 
 * @version 1.0
 */
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
 
	private Long id;
	
	@Length(min=2, max=50)
	private String nombre;
	
	@Length(min=2, max=60)
	private String apellido;
	
	@NotNull
	@Range(min=1, max=99999999)
	private long dni;
	
	@Length(max=11)
    @Pattern(regexp="[0-9]+")
    @NotNull
	private String telefono;
	
	private String domicilio;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String nombreCompleto(){
		return getApellido() + ", " + getNombre();
	}
	
	public String toString(){
		return nombreCompleto();
	}
}
