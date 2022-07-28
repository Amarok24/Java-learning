package eu.horasion.intermediate.superobject;

/**
 * Any class which should be cloneable MUST implement the Cloneable interface
 * and also override the clone method in the way shown below.
 * Furthermore the usage of .clone() then must be done with type casting
 * to this class, see the main method in SuperObjectDemo.java
 */
public class IdCard implements Cloneable {

	String name;
	long cardNumber;
	short yearPrinted;

	public IdCard(String name, long cardNumber, short yearPrinted) {
		this.name					= name;
		this.cardNumber		= cardNumber;
		this.yearPrinted	= yearPrinted;
	}

	public String getName() {
		return name;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public short getYearPrinted() {
		return yearPrinted;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
