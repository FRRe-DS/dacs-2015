/**
 * 
 */
package ar.edu.frre.cs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import ar.edu.frre.cs.model.references.TipoDocumento;

/**
 * @author Dr. Jorge E. Villaverde
 *
 */
@Entity
@Table(name="cliente")
@NamedQueries({
	@NamedQuery(name=Cliente.FIND_ALL_QUERY_NAME, query="SELECT c FROM Cliente c"),
})
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8857028879854544093L;
	public static final String FIND_ALL_QUERY_NAME = "Cliente.findAll";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_doc")
	private TipoDocumento tipoDocumento;
	
	@Min(0)
	@Column(name="nro_doc")
	private long nroDocumento;
	
	@Size(min=2, max=50)
	@Column(name="nombre1")
	private String primerNombre;
	
	@Column(name="nombre2")
	private String segundoNombre;
	
	@Size(min=2, max=50)
	@Column(name="apellido1")
	private String apellido1;
	
	@Column(name="apellido2")
	private String apellido2;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaNacimiento")
    @NotNull
    @Past
	private Date fechaNacimiento;
	
	@Size(min=2, max=50)
	@Column(name="direccion1")
	private String direccion1;
	
	@Column(name="direccion2")
	private String direccion2;
	
	@NotBlank
	@Email
	@Column(name="email1")
	private String email1;
	
	@Email
	@Column(name="email2")
	private String email2;
	
	@Column(name="tel1")
	private String telefono1;

	@Column(name="tel2")
	private String telefono2;
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public long getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion1() {
		return direccion1;
	}
	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}
	public String getDireccion2() {
		return direccion2;
	}
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
}
