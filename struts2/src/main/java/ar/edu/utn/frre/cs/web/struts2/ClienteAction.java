/**
 * 
 */
package ar.edu.utn.frre.cs.web.struts2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Jorge Villaverde
 *
 */
public class ClienteAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9086394205128147838L;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String sexo;
	private String message;
	
	public String execute() {
		if(!apellido.isEmpty())
			return "SUCCESS";
		
		message = "El Apellido del Cliente no puede ser vacio";		
		return "ERROR";
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}