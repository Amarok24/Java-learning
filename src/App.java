import eu.horasion.basics.oop.carfactory.CarFactoryDemo;

public class App {

	public static void main(String[] args) throws Exception {

		if(args.length != 0) {
			System.out.println("Arguments detected, listing:");
			for(String a : args) {
				System.out.println(a);
			}
		}

		System.out.println("Starting the car factory demo...");
		CarFactoryDemo.main(args);
	}
}
