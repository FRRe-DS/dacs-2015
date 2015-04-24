/**
 * 
 */
package ar.edu.utn.frre.cs.dao;

import java.util.List;

import ar.edu.utn.frre.cs.model.Cliente;

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
	
	/**
	 * Retorna la Lista de Clientes
	 * @return
	 */
	List<Cliente> getClientes();

	/**
	 * Elimina un Cliente
	 * @param cliente
	 */
	void deleteCliente(Cliente cliente);
}