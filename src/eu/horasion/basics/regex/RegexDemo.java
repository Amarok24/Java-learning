package eu.horasion.basics.regex;

import java.util.regex.*;

/**
 * RegexDemo
 */
public class RegexDemo {

	public static void main(String[] args) {
		clearConsole();
		TestSuite1.run();
		System.out.println("------");
		TestSuite2.run();
		System.out.println("Finished.");
	}

	static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}


class TestSuite1 {

	static void run() {
		final String regex = "w(..)";
		final String source = "Visit W3Schools on the web!";

		// Regex flags can be set via arguments to the `compile` method.
		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(source);

		// An if-condition runs just once, therefore no "global" regex search.
		if(matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));

			for(int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
	}

}

class TestSuite2 {

	static void run() {
		// Regex flags in Java can also be set via an "embedded flag expression",
		// which is simply another name for "inline regex modifiers".
		final String regex = "(?mi)w(..)"; // flags "m" and "i" enabled
		final String source = "Visit W3Schools on the web!";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);

		// There is no "g" (global) regex flag in Java, just use a while-loop.
		while(matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));

			for(int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
	}

}

/*

Full match: W3S
Group 1: 3S
------
Full match: W3S
Group 1: 3S
Full match: web
Group 1: eb
Finished.

*/
