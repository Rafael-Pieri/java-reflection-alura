package br.com.alura.reflection.model;

public class User {

	private String login;
	private String password;
	private String email;
	private String role;
	private Boolean active;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public boolean validaEmail() {
		return email.contains("@");
	}

	public boolean validaSenha() {
		return email.length() > 8;
	}

	public boolean validLogin() {
		return login.length() > 5 && login.length() < 10;
	}

}
