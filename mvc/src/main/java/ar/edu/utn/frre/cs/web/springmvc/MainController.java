/**
 * 
 */
package ar.edu.utn.frre.cs.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jorge Villaverde
 *
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method=RequestMethod.GET)
    public String setUp() {
		return "index";
    }	

}
