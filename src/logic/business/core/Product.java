package logic.business.core;

import logic.business.abstractions.IProduct;

public abstract class Product implements IProduct  {
	private String title;
	private String genre;
	private Integer duration;
	private String interpreter;
	private String collaborators;
	private Integer fileSize;
	private Integer id;
	
	//Builders
	public Product(String title, String genre, int duration,String interpreter, String collaborators, int fileSize, int id) {
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.interpreter = interpreter;
		this.collaborators = collaborators;
		this.fileSize = fileSize;
		this.id = id;
	}
	public Product(Product product){
		this.title = new String(product.getTitle());
		this.genre = new String(product.getGenre());
		this.duration = product.getDuration();
		this.interpreter = new String(product.getInterpreter());
		this.collaborators = new String(product.getCollaborators());
		this.fileSize = product.getFileSize();
	}
	public Product(int id){
		this.title = new String();
		this.genre = new String();
		this.interpreter = new String();
		this.collaborators = new String();
		this.id = id;
	}
	
	//Methods
	
	
	//Getters & Setters
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getGenre() {return genre;}
	public void setGenre(String genre) {this.genre = genre;}
	public Integer getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration;}
	public String getInterpreter() {return interpreter;}
	public void setInterpreter(String interpreter) {this.interpreter = interpreter;}
	public String getCollaborators() {return collaborators;}
	public void setCollaborators(String collaborators) {this.collaborators = collaborators;}
	public Integer getFileSize() {return fileSize;}
	public void setFileSize(int fileSize) {this.fileSize = fileSize;}
	public Integer getID(){return id;}
}
