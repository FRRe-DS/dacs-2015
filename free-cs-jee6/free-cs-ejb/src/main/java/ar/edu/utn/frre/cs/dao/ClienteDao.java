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
package ar.edu.utn.frre.cs.dao;

import java.util.List;

import ar.edu.utn.frre.cs.model.Cliente;

/**
 * Representa un Repositorio de Clientes
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
public interface ClienteDao  {
	/**
	 * Busca un <code>Cliente</code> por su clave.
	 * @param id
	 * @return <code>null</code> si no se ha encontrado.
	 */
	Cliente findById(Long id);
	
	/**
	 * Devuelve la Lista de Clientes en el Repositorio.
	 * @return
	 */
	List<Cliente> findAll();
	
	/**
	 * Actualiza un <code>Cliente</code> en el Repositorio.
	 * @param cliente
	 * @return
	 */
	Cliente merge(Cliente cliente);
	
	/**
	 * Crea un <code>Cliente</code> en el Repositorio.
	 * @param cliente
	 */
	void persist(Cliente cliente);

	/**
	 * Actualiza un <code>Cliente</code> desde el Repositorio.
	 * @param cliente
	 */
	void refresh(Cliente cliente);
	
	/**
	 * Quita un <code>Cliente</code> del Repositorio.
	 * @param cliente
	 */
	void remove(Cliente cliente);
	
	/**
	 * @return N&uacute;mero de <code>Cliente</code> en el Repositorio.
	 */
	long count();
}
