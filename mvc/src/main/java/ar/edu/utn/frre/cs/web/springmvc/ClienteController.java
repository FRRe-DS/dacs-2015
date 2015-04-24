/**
 * 
 */
package ar.edu.utn.frre.cs.web.springmvc;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.utn.frre.cs.dao.ClienteDao;
import ar.edu.utn.frre.cs.model.Cliente;

/**
 * @author Jorge Villaverde
 *
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {
	private static Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteDao clienteDao;
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
		logger.info("Mostrando el Formulario de Alta un nuevo Cliente");
		
        model.addAttribute("cliente", new Cliente());
		return "clientes/create";
	}

	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Cliente cliente, 
    		BindingResult result, 
    		Model model) {
		logger.info("Se envió el Formulario de Alta un nuevo Cliente");
        
		if (result.hasErrors()) {
			logger.info("El Cliente tiene errores");
            model.addAttribute("cliente", cliente);
            return "clientes/create";
        }

		logger.info("Se guarda el Cliente");

		//Guardamos el cliente
		cliente = clienteDao.saveCliente(cliente);
		//Lo mostramos
        return "redirect:/clientes/" + cliente.getId().toString();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
		logger.info("Mostrando el Cliente con id: " + id);
        model.addAttribute("cliente", clienteDao.findById(id));
        model.addAttribute("itemId", id);
        return "clientes/show";
    }
		
	@RequestMapping(method = RequestMethod.GET)
    public String list(
    		@RequestParam(value = "page", required = false) Integer page, 
    		@RequestParam(value = "size", required = false) Integer size, 
    		Model model) {
		
	
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            int inicio = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            int fin = inicio + sizeNo;
            
//            model.addAttribute("clientes", clientes.subList(inicio, fin));
//            
//            float nrOfPages = (float) clientes.size() / sizeNo;
//            model.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            model.addAttribute("clientes", clienteDao.getClientes());
        }
        return "clientes/list";
    }

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
		logger.info("Mostrando el Formulario de Modificacion del Cliente con id:" +id);
        model.addAttribute("cliente", clienteDao.findById(id));
        return "clientes/update";
    }

	@RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Cliente cliente, 
    		BindingResult result, 
    		Model model) {
        
		logger.info("Actualizando el Cliente: " + cliente);
		
		if (result.hasErrors()) {
			logger.info("El Cliente tiene errores");
			model.addAttribute("cliente", cliente);
            return "cliente/update";
        }
		clienteDao.saveCliente(cliente);
        return "redirect:/clientes/" + cliente.getId().toString();
    }

	@RequestMapping(value = "/{id}", params = "del", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
		Cliente cliente = clienteDao.findById(id);
		logger.info("Eliminando el Cliente:" + cliente);
		clienteDao.deleteCliente(cliente);
        return "redirect:/clientes";
    }
}