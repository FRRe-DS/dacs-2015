/*
 * Copyright (C) 2015 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.edu.utn.frre.dacs.persistencia.jpa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ar.edu.utn.frre.dacs.persistencia.jpa.model.constraints.CUIT;

/**
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name="cliente", schema="dacs2015")
public class Cliente extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Properties -------------------------------------------------------------
	
    @NotNull
    @Min(1)
    @Max(999999999999999L)
    @Column(name = "numero_documento", nullable = false)
    private Long numeroDocumento;

    @NotNull
    @Min(1)
    @Max(999999999999999L)
    @Column(name = "cuit_cuil", nullable = false)
    @CUIT
    private Long cuitCuil;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primer_nombre", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,50}", message = "El nombre no puede contener caracteres no válidos")
    private String primerNombre;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido", nullable = false)
    @Pattern(regexp = "[a-z \\s A-Z ñ Ñ]{1,50}", message = "El apellido no puede contener caracteres no válidos")
    private String apellido;
    
    @NotNull
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimeinto debe ser menor a la fecha actual")
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @ManyToMany(
    	fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JoinTable(
        name="direccion_cliente",
        joinColumns = {
        	@JoinColumn(
        		name = "id_cliente", 
        		referencedColumnName = "id")
        },
        inverseJoinColumns={
        	@JoinColumn(
        		name = "id_direccion", 
        		referencedColumnName = "id")
        })
    private List<Direccion> direcciones;
    
	// Getters/Setters --------------------------------------------------------
	
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Long getCuitCuil() {
		return cuitCuil;
	}

	public void setCuitCuil(Long cuitCuil) {
		this.cuitCuil = cuitCuil;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
