package eu.horasion.basics.oop.array;

import java.util.ArrayList;
import java.util.List; // List is an interface for various dynamic lists.

public class OopArrayDemo {

	static private Person[] employees = new Person[100];

	// The following is completely fine, but using the List interface is better.
	// static private ArrayList<Person> dynamicEmployees = new ArrayList<>();
	static private List<Person> dynamicEmployees = new ArrayList<>();

	public static void main(String[] args) {
		Person guy = new Person("John Doe", (byte)33);
		employees[0] = guy;
		employees[1] = new Person("Dagmar Best", (byte)40);

		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				// Trying to access properties of a null object would throw an error.
				System.out.println("The list of employees ends here.\n");
				break;
			}

			System.out.printf("[%d] Name: %s, age: %d\n", i, employees[i].getName(), employees[i].getAge());
		}

		System.out.println("---------\nNow listing dynamic employees:");

		dynamicEmployees.add(guy);
		dynamicEmployees.add(new Person("David Dynamo", (byte)58));

		int i = 0;
		for(Person p : dynamicEmployees) {
			System.out.printf("[%d] Name: %s, age: %d\n", i, p.getName(), p.getAge());
			i++;
		}
	}
}

/*

[0] Name: John Doe, age: 33
[1] Name: Dagmar Best, age: 40
The list of employees ends here.

---------
Now listing dynamic employees:
[0] Name: John Doe, age: 33
[1] Name: David Dynamo, age: 58

*/
