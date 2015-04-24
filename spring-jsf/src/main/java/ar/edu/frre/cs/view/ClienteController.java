/**
 * 
 */
package ar.edu.frre.cs.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.frre.cs.dao.ClienteDao;
import ar.edu.frre.cs.model.Cliente;

/**
 * @author Dr. Jorge E. Villaverde
 *
 */
@Component
@ManagedBean
@RequestScoped
public class ClienteController {
	@Autowired
	private ClienteDao clienteDao;
	
	public List<Cliente> getListadoClientes(){
		return clienteDao.findByAll();
	}

}
