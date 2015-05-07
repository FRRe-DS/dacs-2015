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
package ar.edu.utn.frre.dacs.ioc.dao;

import ar.edu.utn.frre.dacs.ioc.model.Cliente;

/**
 * Data Access Object para Clientes del <b>Sistem Integral de Turismo</b>
 * @author Jorge Villaverde
 * @version 1.0
 * @see <a href="http://java.sun.com/blueprints/corej2eepatterns/Patterns/DataAccessObject.html">Core J2EE Patterns - Data Access Object</a>
 */
public interface ClienteDao {
	/**
	 * Busca un <code>Cliente</code> por su Id.
	 * @param id
	 * @return
	 */
	Cliente findById(Long id);
	
	/**
	 * Almacen un <code>Cliente</code> en el repositorio de datos
	 * @param cliente
	 * @return
	 */
	Cliente saveCliente(Cliente cliente);
}
