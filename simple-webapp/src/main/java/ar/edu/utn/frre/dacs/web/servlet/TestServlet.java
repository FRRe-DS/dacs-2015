/*
 * Copyright (C) 2015 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.edu.utn.frre.dacs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ejemplo de Servlet con anotaciones
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
@WebServlet(
	description = "Este es un Servlet de ejemplo", 
	urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(TestServlet.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Se ejecutó el Servlet.");

		StringBuilder builder = new StringBuilder();
		builder.append("<html><head><title>Desarrollo de Aplicaciones Cliente-Servidor</title></head><body>");
		
		for(String key: request.getParameterMap().keySet()) {
			String value = request.getParameter(key);
			
			logger.info(
				String.format("Se encontró el parámetro %s con el valor %s.",
				key, value));
			builder.append("<p>Campo: ");
			builder.append(key);
			builder.append(" Valor: ");
			builder.append(value);
			builder.append("</p>");
		}
		builder.append("</body></html>");
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(builder.toString());
		response.getWriter().flush();
		response.getWriter().close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
