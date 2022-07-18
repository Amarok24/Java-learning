package eu.horasion.basics.interfaces;

public class Ford extends Car {

	/**
	 * @param manufacturer
	 *          Car manufacter
	 * @param colour
	 *          Dominant colour of the car
	 * @param ownerName
	 *          Full name of car owner
	 */
	public Ford(String colour, String newOwnerName) {
		super("Ford", colour);
		registerOwner(newOwnerName);
	}

	// There is no @Implement in Java,
	// although we say that an abstract method must be "implemented".
	// Visibility cannot be reduced, but it can be widened as shown here.
	@Override
	public void registerOwner(String ownerName) {
		owner = ownerName;
	}

	@Override
	public String toString() {
		return String.format("A Ford with colour %s, owner's name %s", colour, owner);
	}

}
