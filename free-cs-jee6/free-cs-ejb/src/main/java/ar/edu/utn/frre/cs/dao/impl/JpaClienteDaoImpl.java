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
package ar.edu.utn.frre.cs.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;

import ar.edu.utn.frre.cs.dao.ClienteDao;
import ar.edu.utn.frre.cs.model.Cliente;

/**
 * 
 * @author Dr. Jorge Eduardo Villaverde
 * @version 1.0
 * @since 1.0
 */
@Stateful
@Local(ClienteDao.class)
public class JpaClienteDaoImpl implements ClienteDao {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;

	protected static final Logger logger = Logger.getLogger(JpaClienteDaoImpl.class);
	
	@Override
	public Cliente findById(Long id) {
		if(logger.isTraceEnabled())
			logger.trace(String.format("Buscando Cliente con id = %d", id));
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> findAll() {
		if(logger.isTraceEnabled())
			logger.trace("Buscando todos los Clientes");
		TypedQuery<Cliente> typedQuery = entityManager.createNamedQuery(Cliente.FIND_ALL_QUERY_NAME, Cliente.class);	
		
		return typedQuery.getResultList();
	}

	@Override
	public Cliente merge(Cliente cliente) {
		if(logger.isTraceEnabled())
			logger.trace(String.format("Actualizando Cliente con id = %d", cliente.getId()));
		
		Cliente mergeEntity = entityManager.merge(cliente);
		
		return mergeEntity; 
	}

	@Override
	public void persist(Cliente cliente) {
		if(logger.isTraceEnabled())
			logger.trace("Creando un nuevo Cliente");
		entityManager.persist(cliente);
	}

	@Override
	public void refresh(Cliente cliente) {
		entityManager.refresh(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		logger.info("Eliminando el Cliente con id: " + cliente.getId());
		
		Cliente entity = entityManager.merge(cliente);
		entityManager.remove(entity);
		entityManager.flush();
	}

	@Override
	public long count() {
		if(logger.isTraceEnabled())
			logger.trace("Contando los Clientes en el Repositorio");
		return (Long)entityManager.createNamedQuery(Cliente.COUNT_QUERY_NAME).getSingleResult();
	}
}
