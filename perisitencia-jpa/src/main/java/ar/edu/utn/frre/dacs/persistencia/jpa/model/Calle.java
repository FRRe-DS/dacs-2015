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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
@Entity
@Table(name="calle", schema="dacs2015")
public class Calle extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Properties -------------------------------------------------------------
	
	@Size(max=45)
	@NotNull
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "calle",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Direccion> direcciones 
    	= new HashSet<Direccion>();	
	
	// Getters/Setters --------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

}
