package logic.util;

public class Resolution {
	private Integer height;
	private Integer width;
	
	//Builders
	public Resolution(int height, int width)
	{
		this.height = new Integer(height);
		this.width = new Integer(width);
	}
	public Resolution(Resolution resolution)
	{
		this.height = new Integer(resolution.getHeight());
		this.width = new Integer(resolution.getWidth());
	}
	
	//Methods
	@Override
	public String toString()
	{
		return width.toString() + "x" + height.toString();
	}
	
	//Getters & Setters
	public Integer getHeight(){return height;}
	public Integer getWidth(){return width;}
}
