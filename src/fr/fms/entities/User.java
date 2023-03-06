package fr.fms.entities;

public class User {

	public String login;
	public String password;
	public int Id;
	
	public User(String login, String password) {
		this.login = login;
		this.password= password;
	}
	public User(int Id,String login, String password) {
		this.Id = Id;
		this.login = login;
		this.password= password;
	}

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
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

}
