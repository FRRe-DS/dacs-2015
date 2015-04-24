/**
 * 
 */
package ar.edu.utn.frre.cs.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ar.edu.utn.frre.cs.dao.ClienteDao;
import ar.edu.utn.frre.cs.model.Cliente;

/**
 * Implementación de un repositorio de Clientes de usando un archivo xml.
 * 
 * @author Jorge Villaverde
 * @version 1.0
 *
 */
public class XmlClienteDao implements ClienteDao {
	private static Logger logger = LoggerFactory.getLogger(XmlClienteDao.class);

	private static final String CLIENTE_TAG = "cliente";

	private String fileName;
	
	private List<Cliente> clientes;
	private Map<Long, Cliente> clientesMap;
	
	@Override
	public Cliente findById(Long id) {
		if(clientes == null)
			readClientesFromXml();
		return clientesMap.get(id);
	}

	private void readClientesFromXml() {
		logger.info("Leyendo Clientes desde xml: " + fileName);
		
		clientes = new ArrayList<Cliente>();
		clientesMap = new HashMap<Long, Cliente>();
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			Document doc = docBuilder.parse (is); 
			doc.getDocumentElement ().normalize ();
			
			NodeList listOfClientes = doc.getElementsByTagName(CLIENTE_TAG);
			int totalPersons = listOfClientes.getLength();
			for(int s=0; s<totalPersons ; s++){
				Node clienteNode = listOfClientes.item(s);
				if(clienteNode.getNodeType() == Node.ELEMENT_NODE){
					Cliente cliente = new Cliente();
					
					Element clienteElement = (Element)clienteNode; 
					
					String id = getNodeString(clienteElement.getElementsByTagName("id"));
					String nombre = getNodeString(clienteElement.getElementsByTagName("nombre"));
					String apellido = getNodeString(clienteElement.getElementsByTagName("apellido"));
					String dni = getNodeString(clienteElement.getElementsByTagName("dni"));
					String telefono = getNodeString(clienteElement.getElementsByTagName("telefono"));
					String domicilio = getNodeString(clienteElement.getElementsByTagName("domicilio"));
					
					cliente.setId(Long.valueOf(id));
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setDni(Long.valueOf(dni));
					cliente.setTelefono(telefono);
					cliente.setDomicilio(domicilio);
					
					clientes.add(cliente);
					clientesMap.put(cliente.getId(), cliente);
				}
			}
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private static String getNodeString(NodeList firstNameList){
		Element firstNameElement = (Element)firstNameList.item(0); 
		NodeList textFNList = firstNameElement.getChildNodes();	
		return ((Node)textFNList.item(0)).getNodeValue().trim();
	}
	
	@Override
	public Cliente saveCliente(Cliente cliente) {
		if(clientes == null)
			readClientesFromXml();
		clientes.add(cliente);
		return cliente;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		readClientesFromXml();
	}

	@Override
	public List<Cliente> getClientes() {
		if(clientes == null)
			readClientesFromXml();
		return clientes;
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		if(clientes == null)
			readClientesFromXml();
		clientes.remove(cliente);		
	}
}
