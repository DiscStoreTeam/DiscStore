package logic.main;

import logic.business.Worker;
import logic.business.controllers.HRController;
import logic.util.PositionValue;
import logic.util.ScholarDegreeValue;

public final class Main {

	public static void main(String[] args) {
		Worker worker3 = new Worker("Pepe", "Alvarez", "01090466805", 0, PositionValue.manager, ScholarDegreeValue.basic);

		HRController controller = new HRController(worker3);

		System.out.println("-------------");
		
		controller.hireWorker("Alberto", "Martinez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Carlos", "Robaina", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Manuel", "Perez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		controller.hireWorker("Alejandro", "Lopez", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		
		for(int i = 0; i < controller.getworkers().size(); i++){
			System.out.print(controller.getworkers().get(i).getName() + " ");
			System.out.println(controller.getworkers().get(i).getWorkerID());
		}
		controller.fireWorker(3);
		controller.fireWorker(4);
		controller.fireWorker(5);
		System.out.println("-------------");
		for(int i = 0; i < controller.getworkers().size(); i++){
			System.out.print(controller.getworkers().get(i).getName() + " ");
			System.out.println(controller.getworkers().get(i).getWorkerID());
		}
		
		controller.hireWorker("Roxana", "Iglesias", "01090466805", PositionValue.dependent, ScholarDegreeValue.basic);
		System.out.println("-------------");
		for(int i = 0; i < controller.getworkers().size(); i++){
			System.out.print(controller.getworkers().get(i).getName() + " ");
			System.out.println(controller.getworkers().get(i).getWorkerID());
		}
		
		System.out.println("-------------");
		System.out.println("Cambio de Manager: ");
		System.out.println("-------------");
		System.out.println(controller.getManagerName());
		controller.changeManager(3);
		System.out.println("Nuevo Manager : " + controller.getManagerName());
		
		System.out.println("-------------");
		for(int i = 0; i < controller.getworkers().size(); i++){
			System.out.print(controller.getworkers().get(i).getName() + " ");
			System.out.println(controller.getworkers().get(i).getWorkerID());
		}
	}
}
