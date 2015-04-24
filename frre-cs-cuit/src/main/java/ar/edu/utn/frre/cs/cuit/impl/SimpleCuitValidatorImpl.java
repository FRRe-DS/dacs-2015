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
package ar.edu.utn.frre.cs.cuit.impl;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;

import ar.edu.utn.frre.cs.cuit.CuitValidationService;

/**
 * Valida un CUIT. 
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@Stateless
@WebService(endpointInterface="ar.edu.utn.frre.cs.cuit.CuitValidationService")
//@WebContext(contextRoot="/cuitValidator")
public class SimpleCuitValidatorImpl implements CuitValidationService {
	private static final Logger logger = Logger.getLogger(SimpleCuitValidatorImpl.class); 
	
	@Override
	public boolean validarCuit(String value) {
		if(value == null)
			return false;
		logger.info("Validando el CUIT: " + value);
		
		boolean isValid = false;
		
		if(value.length() == 11){
			String type = value.substring(0, 2);
			String dni = value.substring(2, 10);
			String dv = value.substring(10, 11);			
			try{
				Integer nType = Integer.parseInt(type);
				if((nType == 20 || nType == 23 || nType == 27 || nType == 30)){
					Long lDni = Long.parseLong(dni);
					if(lDni > 0 && lDni.toString().equals(dni)){
						Integer nDV = Integer.parseInt(dv);
						int digitoVerificador = CUITVerificationDigitCalulator.calculateVerificationDigit(value); 
						if(nDV.equals(digitoVerificador))
							isValid = true;
					}
				}
			}catch (NumberFormatException ne){
				logger.error(ne.getMessage());
			}		
		}

		return isValid;
	}

}
