package eu.horasion.basics.userinput;

import java.util.Scanner;

public class UserInputDemo {

	public static void main(String[] args) {
		System.out.println("Type in something. To quit just press Enter.");

		// The following is surrounded by a try-with-resources block, if not done
		// then warning: "Resource leak: 'userInput' is never closed".

		try (Scanner userInput = new Scanner(System.in, "utf8")) {
			String text = "dummy";

			while(!text.isEmpty()) {
				text = userInput.nextLine();
				System.out.println(text.toUpperCase());
			}
		}

	}
}
