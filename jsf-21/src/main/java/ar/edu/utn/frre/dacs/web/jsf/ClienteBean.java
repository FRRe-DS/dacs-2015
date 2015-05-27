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
package ar.edu.utn.frre.dacs.web.jsf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.utn.frre.dacs.web.model.Cliente;

/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ClienteBean.class);
	
	// Constants --------------------------------------------------------------

	/**
	 * Usamos esto para simular la capa de acceso a datos
	 */
	private static final Set<Cliente> clientes;

	private static final String USER_ID_EXISTS = "El id de usuario ya existe";

	private static final String USER_NOT_EXIST = "El usuario no existe";
	
	static {
		clientes = new HashSet<Cliente>();
		
		Calendar cal = Calendar.getInstance();
		cal.set(1980, Calendar.OCTOBER, 1);
		
		clientes.add(
			new Cliente(
					Long.valueOf(1), 
					Long.valueOf(28443521), 
					"Jorge Eduardo", 
					"Villaverde",  
					cal.getTime()));
	}
	
	// Properties -------------------------------------------------------------
	
	private Cliente cliente;
	
	private Long id;
	
	// Actions ----------------------------------------------------------------
	
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(!context.isPostback()) {
			
			if(id == null) {
				logger.info("Se crea el cliente vacio");
				this.cliente = new Cliente();
			} else {
				logger.info("Buscar el cliente con id = " + id);
				
				for(Cliente cliente : clientes) {
					if (id.equals(cliente.getId())) {
						this.cliente = cliente;
						return;
					}
				}
				logger.warn("No se ha encontrado el cliente con id = " + id);
				throw new FacesException("No se ha encontrado el cliente con id = " + id);
			}
		}
	}
	
	public String crearCliente() {
		if(cliente == null) {
			return null;
		}
		
		if(clientes.contains(cliente)) {
			FacesContext context = FacesContext.getCurrentInstance();
			
			context.addMessage("myForm:id", 
					new FacesMessage(USER_ID_EXISTS, USER_ID_EXISTS));
			return null;
		}
		
		logger.info("Se guarda el cliente");
		
		clientes.add(cliente);
		return "listado?faces-redirect=true";
	}

	public String modificarCliente() {
		if(cliente == null) {
			return null;
		}
		
		if(!clientes.contains(cliente)) {
			FacesContext context = FacesContext.getCurrentInstance();
			
			context.addMessage("myForm:id", 
					new FacesMessage(USER_NOT_EXIST, USER_NOT_EXIST));
			return null;
		}
		
		logger.info("Se guarda el cliente");

		return "listado?faces-redirect=true";
	}
	
	public void borrarCliente(Cliente cliente) {
		if(cliente != null) {
			logger.info("Se borra el cliente con id = " + cliente.getId());
			
			clientes.remove(cliente);
		}		
	}
	
	// Getters/Setters --------------------------------------------------------
	
	public List<Cliente> getClientes() {
		return Arrays.asList(clientes.toArray(new Cliente[1]));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
