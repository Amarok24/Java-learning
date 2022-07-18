package eu.horasion.basics.interfaces;

public class InterfaceDemo {

	public static void main(String[] args) {
		startDemo();
	}

	static void startDemo() {
		Car myHonda;
		Ford myFord = new Ford("silver", "John Newman");
		System.out.println(myFord.toString());
		myFord.startEngine();
		System.out.println("changing colour to black");
		System.out.println("changing owner to Kim Young");
		System.out.println(myFord.toString());

		System.out.println("---NEXT CAR---");
		myHonda = new HondaElectric("blue", "James Electric", (short)40);
		myHonda.startEngine();
		myHonda.colour = "blue-metalic"; // colour is a public field

		// owner is a protected field, but public access works in the same package!
		myHonda.owner = "Kim Electric (changed in same package)";
		System.out.println(myHonda.toString());
	}

}

/*

A Ford with colour silver, owner's name John Newman
Car engine started.
changing colour to black
changing owner to Kim Young
A Ford with colour silver, owner's name John Newman
---NEXT CAR---
Car engine started.
Engine at full voltage (40V) now.
Honda
colour: blue-metalic
engine voltage: 40V
owner's name: Kim Electric (changed in same package)

*/
