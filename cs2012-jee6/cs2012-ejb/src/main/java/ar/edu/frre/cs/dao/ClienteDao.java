package ar.edu.frre.cs.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import ar.edu.frre.cs.model.Cliente;

/**
 * CRUD de Cliente
 * Create
 * Read
 * Update
 * Delete
 * @author Dr. Jorge E. Villaverde
 *
 */
@Local
public interface ClienteDao extends Serializable {
	/**
	 * Crea un nuevo <code>Cliente</code> en el Repositorio de datos.
	 * @param cliente
	 */
	void create(Cliente cliente);
	
	/**
	 * Busca un <code>Cliente</code> en el Repositorio por su id.
	 * @param id
	 * @return
	 */
	Cliente findById(Long id);
	
	/**
	 * Actualiza el estado del <code>Cliente</code> en el respositorio
	 * @param cliente
	 * @return <code>cliente</code> actualizado
	 */
	Cliente update(Cliente cliente);
	
	/**
	 * Elimina el <code>Cliente</code> del Repositorio.
	 * @param cliente
	 * @return <code>true</code> si fue eliminado.
	 */
	boolean delete(Cliente cliente);

	/**
	 * Devuelve todos los <code>Cliente</code> del Repositorio.
	 * @return
	 */
	List<Cliente> findByAll();
}
