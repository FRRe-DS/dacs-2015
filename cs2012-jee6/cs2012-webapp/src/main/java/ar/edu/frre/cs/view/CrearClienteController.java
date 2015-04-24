package ar.edu.frre.cs.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ar.edu.frre.cs.dao.ClienteDao;
import ar.edu.frre.cs.model.Cliente;
import ar.edu.frre.cs.model.references.TipoDocumento;


/**
 * @author Dr. Jorge E. Villaverde
 *
 */
@ManagedBean
@SessionScoped
public class CrearClienteController {
	@EJB
	private ClienteDao clienteDao;
	
	private Cliente cliente;

	public String mostrarCrearCliente(){
		return "crearCliente.jsf";
	}
	
	public String crearCliente(){
		clienteDao.create(cliente);
		return "clientes.jsf";
	}
	
	@PostConstruct
	public void init(){
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Devuelve los tipos de Cuestionarios
	 * @return
	 */
	public SelectItem[] getTiposDocumentos() {
		SelectItem[] items = new SelectItem[TipoDocumento.values().length];
		int i = 0;
		for(TipoDocumento value: TipoDocumento.values()) {
			items[i++] = new SelectItem(value);
		}
		return items;
	}

	
}
