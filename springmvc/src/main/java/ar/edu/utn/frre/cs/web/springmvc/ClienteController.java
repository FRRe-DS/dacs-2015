/**
 * 
 */
package ar.edu.utn.frre.cs.web.springmvc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.utn.frre.cs.model.Cliente;

/**
 * @author Jorge Villaverde
 *
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {
	private static Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	private static List<Cliente> clientes;
	
	static{
        clientes = new ArrayList<Cliente>();
        
        Cliente homero = new Cliente();
        homero.setId(0);
        homero.setApellido("Simpson");
        homero.setNombre("Homer J.");
        homero.setDomicilio("Av. Siempre Viva 742");
        
        Cliente marge = new Cliente();
        marge.setId(1);
        marge.setApellido("Bouvier");
        marge.setNombre("Marjorie");
        marge.setDomicilio("Av. Siempre Viva 742");
        
        clientes.add(homero);
        clientes.add(marge);
	}
	
	
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

		cliente.setId(clientes.size());
		//Guardamos el cliente
		clientes.add(cliente);
		//Lo mostramos
        return "redirect:/clientes/" + cliente.getId().toString();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Integer id, Model model) {
		logger.info("Mostrando el Cliente con id: " + id);
        model.addAttribute("cliente", clientes.get(id));
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
            
            model.addAttribute("clientes", clientes.subList(inicio, fin));
            
            float nrOfPages = (float) clientes.size() / sizeNo;
            model.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
    		logger.info("Listando Clientes: " + clientes.size());
            model.addAttribute("clientes", clientes);
        }
        return "clientes/list";
    }

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("Mostrando el Formulario de Modificacion del Cliente con id:" +id);
        model.addAttribute("cliente", clientes.get(id));
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
		clientes.set(cliente.getId(), cliente);
        return "redirect:/clientes/" + cliente.getId().toString();
    }

	@RequestMapping(value = "/{id}", params = "del", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
		logger.info("Eliminando el Cliente:" + clientes.get(id));
		clientes.set(id, new Cliente());
        return "redirect:/clientes";
    }
}