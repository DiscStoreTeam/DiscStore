package logic.business.abstractions;


public abstract class Disc implements IProduct, ProductContainer{
	private int id;
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
}
