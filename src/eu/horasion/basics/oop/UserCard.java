package eu.horasion.basics.oop;

// 'public' not needed if only used in same package.
class UserCard {

	protected String firstName, lastName;
	protected short heightCm = 0;
	protected char gender = '?';

	// Access modifier not needed on constructor if used in the same package.
	UserCard(String firstName, String lastName, short heightCm, char gender) {
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.heightCm = heightCm;
		// The "this" keyword is only needed to distinguish same names.
	}

	// Method overloading, defined without a special decorator (like @Overload)
	UserCard(String name, String surname) {
		firstName = name;
		lastName = surname;
		// this.firstName and this.lastName not needed here, but they would work.
	}

	// Override annotation is a good practice, activates override check.
	// In TypeScript it's called "decorator" instead of "annotation".
	@Override
	public String toString() {
		// return super.toString();
		return String.format("First name: %s\nLast name: %s\nHeight in cm: %d\nGender: %s", this.firstName, this.lastName, this.heightCm, this.gender);
	}

}
