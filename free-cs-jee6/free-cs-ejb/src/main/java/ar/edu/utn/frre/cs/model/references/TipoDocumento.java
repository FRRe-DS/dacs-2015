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
package ar.edu.utn.frre.cs.model.references;

/**
 * Tipos de Documentos Utilizados
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
public enum TipoDocumento implements LabeledEnum {
	DNI("td_dni"),
	LC("td_lc"),
	LE("td_le"),
	PASAPORTE("td_pass");

	private final String label;

	private TipoDocumento(String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}	
}
