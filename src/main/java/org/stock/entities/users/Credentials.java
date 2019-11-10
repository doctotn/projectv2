package org.stock.entities.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Credentials {
	@Column(name="login")
	private String login  ;
	@Column(name="mdp")
	private String mdp  ;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
