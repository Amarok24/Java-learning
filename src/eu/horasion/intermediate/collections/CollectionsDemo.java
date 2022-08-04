package eu.horasion.intermediate.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		arrayListDemo();
		randomSequenceDemo();
		intListDemo();
	}

	static void arrayListDemo() {
		ArrayList<String> todoList = new ArrayList<>() {

			{
				add("clean the windows");
				add("wash the car");
				add("listen to music");
			}

		};

		todoList.add("buy a toothpaste");

		System.out.println("Tasks in to-do list:");
		for(String task : todoList) {
			System.out.println(task);
		}

		Collections.sort(todoList);

		if(!todoList.isEmpty())
			System.out.println("\nAlphabetically sorted to-do list, listing first 2 entries:");

		for(String task : todoList.subList(0, 2)) {
			System.out.println(task);
		}
	}

	static void randomSequenceDemo() {
		// `List.of` returns a fixed-size *unmodifiable* List, see also
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#of(E...)
		List<Integer> immutableList = List.of(5, 10, 15);

		// `Arrays.asList` creates a fixed-size *modifiable* list, see also
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#asList(T...)
		List<Integer> mutableList = Arrays.asList(4, 10, 15, 20, 25);

		// immutableList.set(0, 33); // throws UnsupportedOperationException
		// immutableList.add(4); // also throws UnsupportedOperationException

		mutableList.set(0, 5); // list is fixed-size, but modifiable
		//mutableList.add(30); // throws UnsupportedOperationException

		Collections.shuffle(mutableList);

		System.out.println("\nimmutableList content:");
		for(Integer i : immutableList) {
			System.out.printf("%d;", i);
		}

		System.out.printf("\nimmutableList contains 10 ? %b", immutableList.contains(10));

		System.out.println("\n------\nshuffled mutableList content:");
		System.out.println(mutableList);
	}

	static void intListDemo() {
		Integer[] arr = { 1, 2, 3, 4 };
		// When using Arrays.asList both the array and the list will be connected.
		// Changes made to one of them will affect the other.
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#asList(T...)
		List<Integer> intView = Arrays.asList(arr);

		// The `Integer` class does not have a `toString()` method, so this will
		// only list the memory address:
		// System.out.println(arr);

		System.out.println("\n\narr content for-each:");
		for(int i : arr) {
			System.out.printf("%d;", i);
		}

		System.out.println("\nintView content for-each:");
		for(int i : intView) {
			System.out.printf("%d;", i);
		}

		System.out.println("\n\nNow changing first index of `arr` and last index of `intView`");

		arr[0] = 99;
		intView.set(intView.size() - 1, 77);

		System.out.println("\narr content for-each:");
		for(int i : arr) {
			System.out.printf("%d;", i); // 99;2;3;77;
		}

		System.out.println("\nintView content println:");
		System.out.println(intView); // [99, 2, 3, 77]
	}

}

/*

Tasks in to-do list:
clean the windows
wash the car
listen to music
buy a toothpaste

Alphabetically sorted to-do list, listing first 2 entries:
buy a toothpaste
clean the windows

immutableList content:
5;10;15;
immutableList contains 10 ? true
------
shuffled mutableList content:
[10, 25, 5, 15, 20]


arr content for-each:
1;2;3;4;
intView content for-each:
1;2;3;4;

Now changing first index of `arr` and last index of `intView`

arr content for-each:
99;2;3;77;
intView content println:
[99, 2, 3, 77]

*/
