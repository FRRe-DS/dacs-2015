/**
 * 
 */
package ar.edu.utn.frre.cs.ejemplo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jorge
 *
 */
@Entity
public class Cliente implements Serializable {
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
