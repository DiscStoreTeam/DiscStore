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
	
	public Credential(Credential auxiliar)
	{
		this.username = new String(auxiliar.getUsername());
		this.password = new String(auxiliar.getPassword());
		this.firstLogin = auxiliar.getFirstLogin();
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
	public String getPassword() {return password;}
	public boolean getFirstLogin(){return firstLogin;}
}
