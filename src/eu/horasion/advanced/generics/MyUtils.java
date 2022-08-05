package eu.horasion.advanced.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyUtils {

	// `List` is a raw type (a generic type List<E>), if we want to use it,
	// we always have to "parameterise" it.
	// Because we don't know the parameter and we are checking for it later
	// with `instanceof`, there is a special wildcard parameter `?`.
	public static void displayList(List<?> list) {
		if(list instanceof ArrayList) {
			System.out.println("It's an ArrayList, printing content:");
			System.out.println(list);
		}
		else if(list instanceof LinkedList) {
			System.out.println("It's a LinkedList, printing content:");
			System.out.println(list);
		}
		else {
			System.err.println("This type of list is not supported!");
		}
	}

	public static <T> void displayToString(T anyData) {
		System.out.println(anyData.toString());
	}

}
