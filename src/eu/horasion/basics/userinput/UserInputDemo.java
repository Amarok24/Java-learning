package eu.horasion.basics.userinput;

import java.util.Scanner;

public class UserInputDemo {

	public static void main(String[] args) {
		demo1();
		demo2();
	}

	static void demo1() {
		System.out.println("Type in something. To quit just press Enter.");

		Scanner userInput = new Scanner(System.in, "utf8");
		String text = "dummy";

		while(!text.isEmpty() && userInput.hasNextLine()) {
			text = userInput.nextLine();
			System.out.println(text.toUpperCase());
		}

		// If not closed Java warns: "Resource leak: 'userInput' is never closed",
		// but if I close it here then the demo2() will not work correctly, error:
		// java.util.NoSuchElementException: No line found
		// Research: it has to do with static methods, won't happen w/out static.

		// userInput.close();
	}

	static void demo2() {
		Scanner userInput2 = new Scanner(System.in);
		String race;

		System.out.println("Race (human or orc): ");

		while(!userInput2.hasNext("human") && !userInput2.hasNext("orc")) {
			System.err.println("Invalid input, you need to type in human or orc.");
			userInput2.nextLine();
		}
		race = userInput2.nextLine();

		System.out.println("Hello, brave " + race.toUpperCase());

		userInput2.close();
	}
}

/*

Type in something. To quit just press Enter.
blabla test
BLABLA TEST
second entry
SECOND ENTRY


Race (human or orc):
dddd
Invalid input, you need to type in human or orc.
human
Hello, brave HUMAN

*/
