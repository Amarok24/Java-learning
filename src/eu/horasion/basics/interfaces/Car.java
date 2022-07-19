package eu.horasion.basics.interfaces;

/**
 * An interface in Java is a blueprint of a class. It has static constants and
 * abstract methods. If interface is defined as public, it must be placed in its
 * own file.
 */
interface IElectricMachine {

	// Interface *fields* can only be public, static or final.
	// short voltage = 0; // must be initialised (even when 'public')

	// Interface *methods* can only be:
	// public, private, abstract, default, static or strictfp.
	// Parameter names don't matter here, only the parameter types.
	// Methods are "abstract" by default, no need to write the modifier.
	void setVoltage(short v);

	short getVoltage();
}

// An abstract class cannot be instantiated, it must be extended.
public abstract class Car {
	// Convention: order of modifiers: public, then protected, then private.

	public String colour;
	protected String owner; // Inside of same package it will behave like public!
	private String manufacturer;

	// Constructor
	public Car(String manufacturer, String colour) {
		this.manufacturer = manufacturer;
		this.colour = colour;
	}

	public void startEngine() {
		System.out.println("Car engine started.");
	}

	abstract public void registerOwner(String ownerName);

	// Visibility of this method is "package only" because no modifier set.
	String getManufacturer() {
		return manufacturer;
	}
}
