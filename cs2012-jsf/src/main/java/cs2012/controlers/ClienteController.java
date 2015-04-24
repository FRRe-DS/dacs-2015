/**
 *    Copyright 2012 Neurowork Consulting S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package cs2012.controlers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cs2012.model.Cliente;

/**
 * @author Jorge E. Villaverde
 * @version 1.0.0
 * @since 11/05/2012	
 */
@ManagedBean
@RequestScoped
public class ClienteController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Cliente> getClientes(){
		List<Cliente> ret = new ArrayList<Cliente>();
		
		Cliente cliente = new Cliente("Jorge", "Villaverde");
		ret.add(cliente);
		
		return ret;
	}
}
