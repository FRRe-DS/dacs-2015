/**
 * 
 */
package ar.edu.utn.frre.cs.turismo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.utn.frre.cs.turismo.dao.ClienteDao;
import ar.edu.utn.frre.cs.turismo.model.Cliente;

/**
 * @author Jorge Villaverde
 *
 */
public class DaoClient {

	private static final String CONTEXT = "applicationContext.xml";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] contextPaths = new String[] { CONTEXT };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(contextPaths);
		
		ClienteDao dao = (ClienteDao)ctx.getBean("clienteDao");
		
		Cliente cliente1 = dao.findById(1L);
		
		System.out.println("Cliente: " + cliente1.nombreCompleto());
	}

}
