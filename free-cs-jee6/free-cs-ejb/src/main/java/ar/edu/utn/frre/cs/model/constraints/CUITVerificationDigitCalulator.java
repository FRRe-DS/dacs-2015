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

import ar.edu.utn.frre.cs.model.references.Sexo;
import ar.edu.utn.frre.cs.model.references.TipoDocumento;

/**
 * @author Jorge E. Villaverde
 *
 */
public abstract class CUITVerificationDigitCalulator {
	
	private static final String CUIP_OTRO_TYPE = "23";
	private static final String CUIP_MUJER_TYPE = "27";
	private static final String CUIP_HOMBRE_TYPE = "20";

	public static int calculateVerificationDigitPersonaFisica(TipoDocumento tipoDocumento, long nroDocumento, Sexo sexo) {
		String type = "";
		String dni = String.format("%08d", nroDocumento);
		
		switch (tipoDocumento) {
		case DNI:
			switch (sexo) {
			case HOMBRE:
				type = CUIP_HOMBRE_TYPE;
				break;
			case MUJER:
				type = CUIP_MUJER_TYPE;
				break;
			case OTRO:
				type = CUIP_OTRO_TYPE;
				break;
			}			
			break;
		case LE:
			type = CUIP_HOMBRE_TYPE;
			break;
		case LC:
			type = CUIP_MUJER_TYPE;
			break;
		default:
			break;
		}
		StringBuilder cuip = new StringBuilder();
		cuip.append(type);
		cuip.append(dni);
		return calculateVerificationDigit(cuip.toString());
	}
	
	public static int calculateVerificationDigit(String cuit) {
		int multiplicador = 2;
		int acumulado = 0;
		for(int i=9; i >= 0; i--){
			int posValue = Integer.parseInt(cuit.substring(i, i+1));
			acumulado += posValue*multiplicador;
			multiplicador++;
			if(multiplicador > 7)
				multiplicador = 2;
		}		
		int suma11 = 11 - (acumulado % 11);
		if(suma11 == 11)
			return 0;
		if(suma11 == 10)
			return 9;
		return suma11;
	}

	public static String calculateCuip(TipoDocumento tipoDocumento, long numeroDocumento, Sexo sexo) {
		if(tipoDocumento == null)
			return null;
		if(sexo == null)
			return null;
		
		String type = "";
		String dni = String.format("%08d", numeroDocumento);
		
		switch (tipoDocumento) {
		case DNI:
			switch (sexo) {
			case HOMBRE:
				type = CUIP_HOMBRE_TYPE;
				break;
			case MUJER:
				type = CUIP_MUJER_TYPE;
				break;
			case OTRO:
				type = CUIP_OTRO_TYPE;
				break;
			}			
			break;
		case LE:
			type = CUIP_HOMBRE_TYPE;
			break;
		case LC:
			type = CUIP_MUJER_TYPE;
			break;
		default:
			break;
		}
		StringBuilder cuip = new StringBuilder();
		cuip.append(type);
		cuip.append(dni);
		int dv = calculateVerificationDigit(cuip.toString());
		cuip.append(dv);
		return cuip.toString();
	}

	public static boolean isValidCuip(String value) {
		if(value == null)
			return false;

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
						int digitoVerificador = calculateVerificationDigit(value); 
						if(nDV.equals(digitoVerificador))
							isValid = true;
					}
				}
			}catch (NumberFormatException ne){}		
		}	
		return isValid;
	}
}
