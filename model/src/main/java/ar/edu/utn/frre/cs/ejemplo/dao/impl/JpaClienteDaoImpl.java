/**
 * 
 */
package ar.edu.utn.frre.cs.ejemplo.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ar.edu.utn.frre.cs.ejemplo.dao.ClienteDao;
import ar.edu.utn.frre.cs.ejemplo.model.Cliente;

/**
 * @author jorge
 *
 */
@Stateless
@Local(ClienteDao.class)
public class JpaClienteDaoImpl implements ClienteDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Cliente findById(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

}
