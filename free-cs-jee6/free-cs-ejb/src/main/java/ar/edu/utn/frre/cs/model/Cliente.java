/**
 *    Copyright 2012 
 *    Facultad Regional Resistencia 
 *    Universidad Tecnológica Nacional
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package ar.edu.utn.frre.cs.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import ar.edu.utn.frre.cs.model.constraints.CUIT;
import ar.edu.utn.frre.cs.model.references.EstadoCivil;
import ar.edu.utn.frre.cs.model.references.Sexo;
import ar.edu.utn.frre.cs.model.references.TipoDocumento;

/**
 * Representa un Cliente en el sistema.
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="cliente")
@NamedQueries({
	@NamedQuery(name=Cliente.FIND_ALL_QUERY_NAME,
		query="SELECT a FROM Cliente a"),
	@NamedQuery(name=Cliente.COUNT_QUERY_NAME,
		query="SELECT COUNT(a) FROM Cliente a")
})
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2541706608503538401L;
	public static final String FIND_ALL_QUERY_NAME = "Cliente.findAll";
	public static final String COUNT_QUERY_NAME = "Cliente.count";
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	private long numeroDocumento;

	@CUIT
	private String cuip;
	
	@NotNull
    @Size(min = 1, max = 50)
    private String primerNombre;
	
    @Size(max = 50)
    private String segundoNombre;

    @NotNull
    @Size(min = 1, max = 50)
    private String apellido1;

    @NotNull
    @Size(max = 50)
    private String apellido2;
    
	/**
	 * Date of Birth (DoB) of the person.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

    @Size(max=15)
	private String telefono1;
	
	@Size(max=15)
	private String telefono2;	
    
	@Email
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public String getCuip() {
		return cuip;
	}

	public void setCuip(String cuip) {
		this.cuip = cuip;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	@Override
	public String toString() {
		return String.valueOf(id);
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
}
