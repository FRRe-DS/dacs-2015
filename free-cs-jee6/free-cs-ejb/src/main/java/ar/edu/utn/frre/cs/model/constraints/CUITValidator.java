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
package ar.edu.utn.frre.cs.model.constraints;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jorge E. Villaverde
 * @version 1.0.0
 * @date 21/06/2011  
 */
public class CUITValidator implements ConstraintValidator<CUIT, String>{

	@SuppressWarnings("unused")
	private CUIT cuit;

	@Override
	public void initialize(CUIT cuit) {
		this.cuit = cuit;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null)
			return true;

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
			}catch (NumberFormatException ne){}		
		}

        if(!isValid) {
        	context.disableDefaultConstraintViolation();
        	context.buildConstraintViolationWithTemplate("{ar.edu.utn.frre.cs.model.constraints.CUIT.message}" ).addConstraintViolation();
        }
        
		return isValid;
	}
}
