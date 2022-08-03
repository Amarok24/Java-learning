package eu.horasion.intermediate.superobject;

import java.util.Objects;

// See class IdCard first for some information.

// To make objects correctly comparable we need to override the default
// 'equals' method and implement the logic. Modern IDEs do that automatically.

public class VisitCard implements Cloneable {

	String name;
	long cardNumber;
	short yearPrinted;

	public VisitCard(String name, long cardNumber, short yearPrinted) {
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

	// This is an automatically generated 'equals' method by RedHat + Microsoft
	// Java language support for VS Code IDE.
	/*
	@Override
		public boolean equals(Object obj) {
			if(this == obj)
				return true;
			if(obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;
			VisitCard other = (VisitCard)obj;
			if(cardNumber != other.cardNumber)
				return false;
			if(name == null) {
				if(other.name != null)
					return false;
			}
			else if(!name.equals(other.name))
				return false;
			if(yearPrinted != other.yearPrinted)
				return false;
			return true;
		}
	 */

	// This is a manually written 'equals' method.
	// Convention: class which overrides `equals` should also override `hashCode`
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof VisitCard))
			return false;
		// Now we can be sure that `obj` is a VisitCard, so we use type casting,
		// so we can then access all the fields from VisitCard.
		VisitCard other = (VisitCard)obj;
		// name.equals(other.name) could return a NullPointerException
		// in case `name` would be null, so we use Objects.equals instead.
		return Objects.equals(name, other.name) && (cardNumber == other.cardNumber) && (yearPrinted == other.yearPrinted);
	}

	// Returns a hash code value for the object. This method is for the benefit
	// of hash tables such as those provided by java.util.HashMap
	@Override
	public int hashCode() {
		// return super.hashCode();

		// The built-in hashCode method returns different numbers for each
		// instantiation of the class, even if all the fields are the same!

		// It is better to make this kind of solution which makes sure that
		// hash codes of objects with same fields will be equal.
		return Objects.hash(name, cardNumber, yearPrinted);
	}

}
