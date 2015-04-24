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


import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import ar.edu.utn.frre.cs.model.references.EstadoCivil;
import ar.edu.utn.frre.cs.model.references.Sexo;
import ar.edu.utn.frre.cs.model.references.TipoDocumento;

/**
 * 
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@ManagedBean
@RequestScoped
@Named
public class EnumsBeans {

	@Produces
	@Named
	public SelectItem[] getTiposDNI(){
		SelectItem[] tipos = new SelectItem[TipoDocumento.values().length];

		tipos[0] = new SelectItem(TipoDocumento.DNI, "DNI");
		tipos[1] = new SelectItem(TipoDocumento.LC, "Libreta Cívica");
		tipos[2] = new SelectItem(TipoDocumento.LE, "Libreta Enrolamiento");
		tipos[3] = new SelectItem(TipoDocumento.PASAPORTE, "Pasaporte");
		
		return tipos;
	}

	@Produces
	@Named
	public SelectItem[] getEstadosCiviles(){
		SelectItem[] ret = new SelectItem[EstadoCivil.values().length];

		ret[0] = new SelectItem(EstadoCivil.SOLTERO, "Soltero");
		ret[1] = new SelectItem(EstadoCivil.CASADO, "Casado");
		ret[2] = new SelectItem(EstadoCivil.DIVORCIADO, "Divorciado");
		ret[3] = new SelectItem(EstadoCivil.VIUDO, "Viudo");
		
		return ret;
	}

	@Produces
	@Named
	public SelectItem[] getSexos(){
		SelectItem[] ret = new SelectItem[Sexo.values().length];

		ret[0] = new SelectItem(Sexo.HOMBRE, "Hombre");
		ret[1] = new SelectItem(Sexo.MUJER, "Mujer");
		ret[2] = new SelectItem(Sexo.OTRO, "Otro");
		
		return ret;
	}
}
