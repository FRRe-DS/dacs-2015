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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
@ManagedBean
@ViewScoped
public class ExampleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constants --------------------------------------------------------------
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ExampleBean.class);
	
	// Properties -------------------------------------------------------------
	
	@NotNull
	@Size(min = 1, max = 10)
	private String campo1;

	// Getters/Setters --------------------------------------------------------
	
	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	
	// Actios -----------------------------------------------------------------
	
	public String hacerAlgo() {
		logger.info("Hacer algo con campo1 = " + campo1);
		
		return "resultado?campo1=" + campo1 
				+ "&faces-redirect=true"
				+ "&includeViewParams=true" ;
	}

}
