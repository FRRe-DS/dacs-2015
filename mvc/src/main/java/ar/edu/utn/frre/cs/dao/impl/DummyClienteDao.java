/**
 * 
 */
package ar.edu.utn.frre.cs.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.utn.frre.cs.dao.ClienteDao;
import ar.edu.utn.frre.cs.model.Cliente;

/**
 * Implementación de un repositorio de Clientes de juguete.
 * 
 * @author Jorge Villaverde
 * @version 1.0
 */
public class DummyClienteDao implements ClienteDao {
	private List<Cliente> clientes;
	private Map<Long, Cliente> clientesMap;

	public DummyClienteDao(){
		super();
        clientes = new ArrayList<Cliente>();
        clientesMap = new HashMap<Long, Cliente>();
        
        Cliente homero = new Cliente();
        homero.setApellido("Simpson");
        homero.setNombre("Homer J.");
        homero.setDomicilio("Av. Siempre Viva 742");

        Cliente marge = new Cliente();
        marge.setApellido("Bouvier");
        marge.setNombre("Marjorie");
        marge.setDomicilio("Av. Siempre Viva 742");
        
        saveCliente(homero);
        saveCliente(marge);
	}
        
	@Override
	public Cliente findById(Long id) {
		return clientesMap.get(id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		if(cliente.getId() == null){
			cliente.setId((long)clientes.size());
			clientes.add(cliente);
			clientesMap.put(cliente.getId(), cliente);
		}
		return cliente;
	}

	@Override
	public List<Cliente> getClientes() {
		return clientes;
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		clientes.remove(cliente);		
	}

}
