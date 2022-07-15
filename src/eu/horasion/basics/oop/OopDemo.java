package eu.horasion.basics.oop;

public class OopDemo {

	public static void main(String[] args) {
		UserCard person1 = new UserCard("John", "Doe", (short)164, 'm');
		UserCard person2 = new UserCard("Paula", "Bright");

		UserCard[] people = new UserCard[2];

		people[0] = person1;
		people[1] = person2;

		// System.out.println(person1.toString());
		// System.out.println(person2.toString());

		for(UserCard p : people) {
			System.out.println(p.toString());
		}

	}
}

/*

First name: John
Last name: Doe
Height in cm: 164
Gender: m
First name: Paula
Last name: Bright
Height in cm: 0
Gender: ?

*/
