package logic.main;

import java.util.ArrayList;

import logic.business.Worker;
import logic.business.controllers.HRController;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public final class Main {

	public static void main(String[] args) {
		Worker worker3 = new Worker("Pepe", "Alvarez", "01090466805", "00", PositionValue.manager, ScholarDegreeValue.basic);
		ArrayList<Worker> workers = new ArrayList<Worker>();
		workers.add(worker3);

		HRController controller = new HRController(workers, worker3);
		
		controller.hireWorker("Alberto", "Martinez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Carlos", "Robaina", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.shiftManager, ScholarDegreeValue.basic);
		controller.hireWorker("Manuel", "Perez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Alejandro", "Lopez", "01090466805", PositionValue.shiftManager, ScholarDegreeValue.basic);
		
		for(int i = 0; i < 10; i++)
		{
			controller.hireWorker("Alberto", "Martinez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
			controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.shiftManager, ScholarDegreeValue.basic);
		}
		
		//controller.updatePositions();
		
		for(int i = 0; i < workers.size(); i++){
			System.out.print(workers.get(i).getName() + " ");
			System.out.println(workers.get(i).getWorkerID());
		}
		
		System.out.println("Cambiando Administrador");
		//controller.changeManager(5, PositionValue.dependent);
		
		for(int i = 0; i < workers.size(); i++){
			System.out.print(workers.get(i).getName() + " ");
			System.out.println(workers.get(i).getWorkerID());
		}
		
	}
}
