package logic.business.abstractions;


public abstract class Disc implements IProduct, IProductContainer{
	private int id;
	private String name;
	private String type;
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
}
