package logic.business.auxiliars;

public class SellReports {
	private int id;
	private String content;
	private double cost;
	private String workerName;
	
	public SellReports(int id, String content, double cost, String workerName){
		this.id = id;
		this.content = content;
		this.cost = cost;
		this.workerName = workerName;	
	}

	public int getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public double getCost() {
		return cost;
	}
	public String getWorkerName() {
		return workerName;
	}

}
