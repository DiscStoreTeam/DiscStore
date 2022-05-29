package logic.main;

import logic.business.Worker;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public final class Main {

	public static void main(String[] args) {
		Worker worker = new Worker("Carlos", "Robaina", "01090466805", 0, PositionValue.shiftManager, ScholarDegreeValue.superior);
		
		System.out.println(worker.getPosition() + " " + worker.getScholarDegree());
	}
}
