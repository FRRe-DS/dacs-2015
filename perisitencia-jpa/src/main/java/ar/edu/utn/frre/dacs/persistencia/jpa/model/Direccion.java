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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
@Entity
@Table(name="direccion", schema="dacs2015")
public class Direccion extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Properties -------------------------------------------------------------
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
    	name = "id_calle", 
    	nullable = false)
    private Calle calle;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
    	name = "id_provincia", 
    	nullable = false)
    private Provincia provincia;
	
    @NotNull
    @Column(name = "altura", nullable = false)
    private Integer altura;

    @Column(name = "piso", nullable = false)
    private Integer piso;

    @Size(max = 4)
    @Column(name = "departamento", nullable = true)
    @Pattern(regexp = "[a-z \\s A-Z 0-9 ñ Ñ]{0,4}", message = "El departamento no puede contener caracteres no válidos")
    private String departamento;

    @Size(max = 30)
    @Column(name = "barrio", nullable = true)
    @Pattern(regexp = "[a-z \\s A-Z 0-9 ñ Ñ]{0,30}", message = "El barrio no puede contener caracteres no válidos")
    private String barrio;

    @NotNull
    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal;

    @ManyToMany(mappedBy="direcciones")
    private List<Cliente> clientes;
    
	// Getters/Setters --------------------------------------------------------
	
	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	// Overrides --------------------------------------------------------------

}
