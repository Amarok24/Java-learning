package eu.horasion.basics.oop.carfactory;

import eu.horasion.basics.interfaces.Car;
import eu.horasion.basics.interfaces.HondaElectric;

public class CarFactoryDemo {

	public static void main(String[] args) {
		Car redHonda, redHonda2, refToRedHonda;
		HondaElectric silverHonda;

		// An object of type 'Car' can hold a new instance of 'HondaFactory' (or
		// 'HondaElectric'), but it then loses access to fields/methods of that
		// class. It will be an electric car without possibility to change voltage!
		// Only fields and methods defined in class Car are accessible, see below.
		redHonda = HondaFactory.createHonda("red", (short)70);
		redHonda2 = HondaFactory.createHonda("red", (short)70);
		refToRedHonda = redHonda;

		// false, they are not equal although having same content
		System.out.printf("\nredHonda == redHonda2 ? %b\n", redHonda.equals(redHonda2));

		// true, it's a reference (not a copy)
		System.out.printf("redHonda == refToRedHonda ? %b\n\n", redHonda.equals(refToRedHonda));

		// The following works, because Car defines it,
		// and it runs the (overriden) method set by class HondaElectric!!
		refToRedHonda.startEngine();
		// refToRedHonda.setVoltage((short)20); // Error!! undefined for type Car

		// This will effectively change both refToRedHonda and redHonda.
		refToRedHonda.registerOwner("Martin Redman");
		System.out.println(redHonda.toString());

		silverHonda = HondaFactory.createHonda("silver", (short)90);
		silverHonda.registerOwner("Paul Silverman");
		silverHonda.setVoltage((short)100);
		silverHonda.colour = "silver-metalic";
		// silverHonda.owner = "Don Bosco"; // The field Car.owner is not visible
		System.out.println(silverHonda.toString());
	}
}


/*

redHonda == redHonda2 ? false
redHonda == refToRedHonda ? true

Car engine started.
Engine at full voltage (70V) now.
Honda
colour: red
engine voltage: 70V
owner's name: Martin Redman

Honda
colour: silver-metalic
engine voltage: 100V
owner's name: Paul Silverman

*/
