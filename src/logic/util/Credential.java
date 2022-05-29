package logic.util;

public class Credential {
	private String username;
	private String password;
	private boolean firstLogin;
	
	//Builders
	public Credential(String username, String password)
	{
		this.username = new String(username);
		this.password = new String(password);
		this.firstLogin = true;
	}
	
	//Methods
	public void updateCredentials(String username, String password)
	{
		this.username = username;
		this.password = password;
		if(firstLogin){
			firstLogin = false;
		}
	}

	//Getters & Setters
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public boolean getFirstLogin(){return firstLogin;}
}
