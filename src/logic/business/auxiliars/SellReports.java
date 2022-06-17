package logic.business.auxiliars;

import logic.business.abstractions.Disc;
import logic.business.core.Worker;

public class SellReports {
	private Disc disc;
	private int id;
	private String content;
	private double cost;
	private Worker worker;
	
	public SellReports(int id, String content, double cost, Worker worker, Disc disc){
		this.id = id;
		this.content = content;
		this.cost = cost;
		this.worker = worker;	
		this.disc = disc;
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
		return worker.getName();
	}
	public Disc getDisc(){
		return disc;
	}

}
