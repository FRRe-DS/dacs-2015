/**
 * 
 */
package ar.edu.utn.frre.cs.ejemplo.dao;

import ar.edu.utn.frre.cs.ejemplo.model.Cliente;

/**
 * @author jorge
 *
 */
public interface ClienteDao {
	Cliente findById(Long id);
	void save(Cliente cliente);
}
