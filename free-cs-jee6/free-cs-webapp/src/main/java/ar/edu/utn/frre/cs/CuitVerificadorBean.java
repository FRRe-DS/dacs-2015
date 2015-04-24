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

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ar.edu.utn.frre.cs.cuit.CuitValidationService;
import ar.edu.utn.frre.cs.cuit.SimpleCuitValidatorImplService;

/**
 * 
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@ManagedBean
@RequestScoped
@Named
public class CuitVerificadorBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3024775842583897250L;
	
	private String cuit;
	
	private String cuitEstado;
	
	@PostConstruct
	public void init(){
		cuitEstado = "";
	}
	
	public void verificar(){
		SimpleCuitValidatorImplService service = new SimpleCuitValidatorImplService();
		CuitValidationService cuitService = service.getSimpleCuitValidatorImplPort();
		
		boolean cuitValido = cuitService.validarCuit(cuit);
		
		if(!cuitValido){
			cuitEstado = "El CUIT " + cuit +" NO es válido.";
		}else{
			cuitEstado = "El CUIT " + cuit +" es válido.";
		}
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCuitEstado() {
		return cuitEstado;
	}

	public void setCuitEstado(String cuitEstado) {
		this.cuitEstado = cuitEstado;
	}
}