/**
 * 
 */
package ar.edu.frre.cs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.frre.cs.dao.ClienteDao;
import ar.edu.frre.cs.model.Cliente;

/**
 * @author Dr. Jorge E. Villaverde
 *
 */
@Repository
@Transactional
public class JpaClienteDaoImpl implements ClienteDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7520664641803844406L;

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	protected static final Logger logger = LoggerFactory.getLogger(JpaClienteDaoImpl.class);

	public void create(Cliente cliente) {
		if(logger.isTraceEnabled())
			logger.trace("Creating Cliente: " + cliente);
		entityManager.persist(cliente);
	}

	public Cliente findById(Long id) {
		if(logger.isTraceEnabled())
			logger.trace("Buscando Cliente por Id: " + id);
		return entityManager.find(Cliente.class, id);
	}

	public Cliente update(Cliente cliente) {
		if(logger.isTraceEnabled())
			logger.trace("Merging Cliente: " + cliente);
		Cliente mergeEntity = entityManager.merge(cliente);
		entityManager.flush();
		return mergeEntity; 
	}

	public boolean delete(Cliente cliente) {
		if(logger.isTraceEnabled())
			logger.trace("Eliminado Cliente con Id: " + cliente.getId());
		try {
			Cliente entity = entityManager.merge(cliente);
			entityManager.remove(entity);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	public List<Cliente> findByAll() {
		if(logger.isTraceEnabled())
			logger.trace("Devolviendo todos los Clientes.");
		TypedQuery<Cliente> query = entityManager.createNamedQuery(
				Cliente.FIND_ALL_QUERY_NAME, Cliente.class);		
		return query.getResultList();
	}
}