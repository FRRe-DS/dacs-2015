/**
 * 
 */
package ar.edu.utn.frre.cs.web.struts2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Jorge Villaverde
 *
 */
public class WelcomeUser extends ActionSupport {
	private String userName;
	private String message;
	
	public String execute() {
		message = "Welcome " + userName;
		return SUCCESS;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}
}