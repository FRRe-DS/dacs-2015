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
package ar.edu.utn.frre.dacs.persistencia.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.edu.utn.frre.dacs.persistencia.jpa.model.Provincia;

/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
public class JpaDemo {

	private static final Logger logger = 
			LoggerFactory.getLogger(JpaDemo.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "DACSPU";
	
	private static EntityManagerFactory factory;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Paso 1: Obtener el Entity Manager Factory 
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		logger.info("Paso 1: OK, tengo el EM Factory");
		
		// Paso 2: Obtener el Entity Manager
		EntityManager entityManager = factory.createEntityManager();
		
		logger.info("Paso 2: OK, tengo el Entity Manager");
		
		// Paso 3: Ejecutar consultas
		
		ejecutarConsultasProvincias(entityManager);
		
		logger.info("Paso 3: OK, consultas ejecutadas");
		
		// Paso 4: cierro el Entity Manager
		entityManager.close();
		
		logger.info("Paso 4: OK, Entity Manager cerrado");
		
		// Paso 5: cierro el EM Factory
		factory.close();
		
		logger.info("Paso 5: OK, cierro el EM Factory");
	}

	private static void ejecutarConsultasProvincias(EntityManager entityManager) {
		
		Provincia provincia = insertarRegistros(entityManager);
		
		leerRegistros(entityManager);
		
		actualizarRegistros(entityManager, provincia);
		
		borrarRegistros(entityManager, provincia);
		
		leerRegistros(entityManager);
	}

	@SuppressWarnings("unchecked")
	private static void leerRegistros(EntityManager entityManager) {
		logger.info("Paso 3: leer las provincias.");
		
		Query q = entityManager.createQuery("select p from Provincia p");
	    
		List<Provincia> provincias = q.getResultList();
		
	    for (Provincia provincia : provincias) {
	    	logger.info("Provincia: id = " 
	    			+ provincia.getId()
	    			+ ", nombre = "
	    			+ provincia.getNombre());
	    }
	}

	private static void borrarRegistros(EntityManager entityManager, Provincia provincia) {
		logger.info("Paso 3: borrar la provincia: id = " 
	    			+ provincia.getId()
	    			+ ", nombre = "
	    			+ provincia.getNombre());
		
		entityManager.getTransaction().begin();
		entityManager.remove(provincia);
		entityManager.getTransaction().commit();
		
		logger.info("Paso 3: se ha borrado la provincia: " + provincia.getNombre());
	}

	private static void actualizarRegistros(EntityManager entityManager, Provincia provincia) {
		logger.info("Paso 3: actualizar una provincia.");
		
		provincia.setNombre("La Pampa");
		
		entityManager.getTransaction().begin();
		entityManager.merge(provincia);
		entityManager.getTransaction().commit();
		
		logger.info("Paso 3: se ha actualizar la provincia: " + provincia.getNombre());
	}

	private static Provincia insertarRegistros(EntityManager entityManager) {
		logger.info("Paso 3: insertar una provincia.");
		
		Provincia provincia = new Provincia();
		
		provincia.setNombre("Buenos Aires");
		
		entityManager.getTransaction().begin();
		entityManager.persist(provincia);
		entityManager.getTransaction().commit();	
		
		logger.info("Paso 3: se ha creado la provincia: " + provincia.getNombre());
		
		return provincia;
	}

}
