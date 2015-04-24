/**
 * 
 */
package ar.edu.utn.frre.cs.turismo.dao;

import ar.edu.utn.frre.cs.turismo.model.Cliente;

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
