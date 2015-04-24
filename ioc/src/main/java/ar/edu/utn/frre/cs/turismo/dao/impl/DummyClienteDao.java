/**
 * 
 */
package ar.edu.utn.frre.cs.turismo.dao.impl;

import ar.edu.utn.frre.cs.turismo.dao.ClienteDao;
import ar.edu.utn.frre.cs.turismo.model.Cliente;

/**
 * Implementación de un repositorio de Clientes de juguete.
 * 
 * @author Jorge Villaverde
 * @version 1.0
 */
public class DummyClienteDao implements ClienteDao {

	@Override
	public Cliente findById(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setApellido("Villaverde");
		return cliente;
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return cliente;
	}

}
