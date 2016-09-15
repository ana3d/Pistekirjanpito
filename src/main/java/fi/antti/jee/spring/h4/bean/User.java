package fi.antti.jee.spring.h4.bean;

public class User {

	private String name, login, password;
	private int id, accessLevel;
	public User(String name, String login, String password, int id,
			int accessLevel) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.id = id;
		this.accessLevel = accessLevel;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", login=" + login + ", password="
				+ password + ", id=" + id + ", accessLevel=" + accessLevel
				+ "]";
	}
	
}
