/**
 * 
 */
package ar.edu.frre.cs.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ar.edu.frre.cs.dao.ClienteDao;
import ar.edu.frre.cs.model.Cliente;

/**
 * @author Dr. Jorge E. Villaverde
 *
 */
@ManagedBean
@RequestScoped
public class ClienteController {
	@EJB
	private ClienteDao clienteDao;
	
	public List<Cliente> getListadoClientes(){
		return clienteDao.findByAll();
	}

}
