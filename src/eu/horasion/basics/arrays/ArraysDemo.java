package eu.horasion.basics.arrays;

import java.util.Random;

public class ArraysDemo {

	public static void main(String[] args) {
		ArraysDemo demo = new ArraysDemo();
		demo.demo1();
	}

	void demo1() {
		int[] field = new int[4]; // New arrays are initialised automatically,
		// default value for new integers in Java is 0
		char[] prefilledField = { 'a', 'x', 'z' };
		int[] randomField; // Not initialised, primitive types are NOT nullable!
		// int nonNullable = 3; // primitive int can never be null
		// Integer[] nullIntegerAr = null;//Wrappers of primitive types are nullable
		Integer nullableInteger = null; // Nullable objects have no default value
		                                // null, they still have to be set to null
		                                // in order to test for null.

		for(int i : field) {
			System.out.println(i); // will print all zeros
		}

		if(nullableInteger == null) {
			System.out.println("nullableInteger is null");
		}

		randomField = new int[3];

		for(int i = 0; i < randomField.length; i++) {
			randomField[i] = new Random().nextInt(100); // 0..99
			System.out.println(randomField[i]);
		}

		System.out.printf("length of prefilledField is %d", prefilledField.length); // 3
	}

}

/*

0
0
0
0
nullableInteger is null
85
15
98
length of prefilledField is 3

*/
