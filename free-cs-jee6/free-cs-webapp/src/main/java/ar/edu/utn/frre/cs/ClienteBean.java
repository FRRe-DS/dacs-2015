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
package ar.edu.utn.frre.cs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.jboss.logging.Logger;

import ar.edu.utn.frre.cs.cuit.CuitValidationService;
import ar.edu.utn.frre.cs.cuit.SimpleCuitValidatorImplService;
import ar.edu.utn.frre.cs.dao.ClienteDao;
import ar.edu.utn.frre.cs.model.Cliente;

/**
 * 
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@ManagedBean
@RequestScoped
@Named
public class ClienteBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3024775842583897250L;

	private static final Logger logger = Logger.getLogger(ClienteBean.class);
	
	@EJB
	private ClienteDao clienteDao;
	
	private Cliente cliente;
	
	@Produces
	public List<Cliente> getListaClientes(){
		return clienteDao.findAll();
	}
	
	@Produces
	public Cliente getNuevoCliente(){
		cliente = new Cliente();
		return cliente;
	}
	
	public String mostrarCrearNuevoCliente(){
		return "nuevoCliente.jsf";
	}
	
	public String crearCliente(){
		SimpleCuitValidatorImplService service = new SimpleCuitValidatorImplService();
		CuitValidationService cuitService = service.getSimpleCuitValidatorImplPort();
		
		cliente.setCuip("20284435215");
		
		boolean cuitValido = cuitService.validarCuit(cliente.getCuip());
		
		if(!cuitValido){
			logger.error("El CUIT del Cliente no es válido: " + cliente.getCuip());
			return "nuevoCliente.jsf";
		}else{
			clienteDao.persist(cliente);
			return "home.jsf";
		}
	}
}