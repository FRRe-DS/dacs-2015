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
 * Sexos de Personas
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
public enum Sexo implements LabeledEnum {
	HOMBRE("sexo_hombre"),
	MUJER("sexo_mujer"),
	OTRO("sexo_otro");
	
	private final String label;
	
	private Sexo(final String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}