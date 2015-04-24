package ar.edu.utn.frre.cs.web.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -230461428217013922L;
	String greetings = null;
	
	public String execute() throws Exception {
		setGreetings("Hello World");
		return SUCCESS;
	}

	/**
	* @return the greetings
	*/
	public String getGreetings() {
		return greetings;
	}

	/**
	* @param greetings the greetings to set
	*/
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
}
