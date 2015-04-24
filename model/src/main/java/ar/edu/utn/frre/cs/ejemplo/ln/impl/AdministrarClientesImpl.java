/**
 * 
 */
package ar.edu.utn.frre.cs.ejemplo.ln.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import ar.edu.utn.frre.cs.ejemplo.dao.ClienteDao;
import ar.edu.utn.frre.cs.ejemplo.ln.AdministrarCliente;
import ar.edu.utn.frre.cs.ejemplo.model.Cliente;

/**
 * @author jorge
 *
 */
@Stateless
@Local(AdministrarCliente.class)
public class AdministrarClientesImpl implements AdministrarCliente {
	@EJB
	private ClienteDao dao;
	
	public void darDeAltaUnCliente(Cliente cliente) {
		
		dao.save(cliente);
		
	}

}
