package eu.horasion.basics.interfaces;

public class HondaElectric extends Car implements IElectricMachine {

	private short engineVoltage;

	public HondaElectric(String colour, String newOwnerName,
	                     short engineVoltage) {
		super("Honda", colour);
		registerOwner(newOwnerName);
		setVoltage(engineVoltage);
	}

	@Override
	public void setVoltage(short newVoltage) {
		engineVoltage = newVoltage;
	}

	@Override
	public short getVoltage() {
		return engineVoltage;
	}

	@Override
	public void registerOwner(String ownerName) {
		owner = ownerName;
	}

	@Override
	public void startEngine() {
		super.startEngine();
		System.out.printf("Engine at full voltage (%dV) now.\n", getVoltage());
	}

	@Override
	public String toString() {
		return String.format("Honda\ncolour: %s\nengine voltage: %dV\nowner's name: %s\n", colour, getVoltage(), owner);
	}

}
