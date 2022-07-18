package eu.horasion.basics.oop.carfactory;

import eu.horasion.basics.interfaces.HondaElectric;

public class HondaFactory extends HondaElectric {

	public HondaFactory(String colour, String newOwnerName, short engineVoltage) {
		super(colour, newOwnerName, engineVoltage);
	}

	static HondaElectric createHonda(String colour, short voltage) {
		return new HondaFactory(colour, "no owner", voltage);
	}
}
