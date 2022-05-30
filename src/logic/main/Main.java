package logic.main;

import java.util.ArrayList;

import logic.business.Worker;
import logic.business.controllers.HRController;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public final class Main {

	public static void main(String[] args) {
		Worker worker2 = new Worker("Amauri", "Alvarez", "01090466805", 8, PositionValue.dependent, ScholarDegreeValue.basic);
		Worker worker3 = new Worker("Pepe", "Alvarez", "01090466805", 0, PositionValue.manager, ScholarDegreeValue.basic);
		Worker worker1 = new Worker("Maria", "Alvarez", "01090466805", 2, PositionValue.dependent, ScholarDegreeValue.basic);
		Worker worker4 = new Worker("Ana", "Saldivar", "01090466805", 38, PositionValue.dependent, ScholarDegreeValue.basic);
		
		ArrayList<Worker> workers = new ArrayList<Worker>();
		workers.add(worker3);
		workers.add(worker1);
		workers.add(worker2);
		workers.add(worker4);

		HRController controller = new HRController(workers, worker3);
		
		for(int i = 0; i < workers.size(); i++){
			System.out.print(workers.get(i).getName() + " ");
			System.out.println(workers.get(i).getWorkerID());
		}
		
		System.out.println("-------------");
		
		controller.hireWorker("Alberto", "Martinez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Carlos", "Robaina", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Manuel", "Perez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Alejandro", "Lopez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		
		/*
		 * for(int i = 0; i < 10; i++)
		{
			controller.hireWorker("Alberto", "Martinez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
			controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.shiftManager, ScholarDegreeValue.basic);
		}
		*/
		
		//controller.updatePositions();
		
		for(int i = 0; i < workers.size(); i++){
			System.out.print(workers.get(i).getName() + " ");
			System.out.println(workers.get(i).getWorkerID());
		}
	}
}
