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
package ar.edu.utn.frre.dacs.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Muestra como ejecutar consultas JDBC.
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
public class JdbcQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		// Ejecutar el paso 1, Cargar el Driver
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    
		    System.out.println("Paso 1: OK, tengo el Driver");
		    
		    // Paso 2, definir la URL del conexion 
		    String url = createDatabaseUrl();
		    System.out.println("Paso 2: OK, tengo la URL: " + url);
		    
			// Paso 3, establecer la conexion
		    String user = "dacs2015";
			String password = "dacs2015";
			
		    try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Paso 3: OK, la conexión a la BBDD.");
				
				// Paso 4, crear un Statement
				stm = con.createStatement();
				System.out.println("Paso 4: OK, tengo el Statement");
				
				// Paso 5 Ejecutar un query
				String query = "SELECT id, nombre FROM provincia";
										
				rs = stm.executeQuery(query);  
				System.out.println("Paso 5: OK, ejecuté el query: " + query);
				
				// Paso 6, procesar los resultados
				System.out.println("Paso 6: Provincia");
				System.out.println("|id\t|Nombre");
				System.out.println("----------------");
				int resultadosCount = 0;
				while(rs.next()){
					resultadosCount++;
				    int id = rs.getInt("id");
				    String nombre = rs.getString(2);
				    System.out.println(
				    	String.format("|%d\t|%s", id, nombre));
				}
				System.out.println("----------------");
				
				System.out.println(String.format("Paso 6: OK, procesé %d resultados.", resultadosCount));
			} catch (SQLException e) {
				System.err.println(
					String.format(	
						"Ocurrió un error [%d]: %s", 
						e.getErrorCode(),
						e.getMessage())
					);
			}		    
		} catch (ClassNotFoundException e) {
		   System.err.println("No existe el Driver para MySQL");
		} finally{
			// Paso 7, cierro la conexion
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(con != null) {
				try {
					con.close();
					System.out.println("Paso 7: OK, cerré la conexión");
				} catch (SQLException e) {}
			}
		}
	}

	private static String createDatabaseUrl() {
		return "jdbc:mysql://localhost/dacs2015";
	}

}
