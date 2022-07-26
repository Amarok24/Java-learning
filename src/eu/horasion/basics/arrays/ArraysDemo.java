package eu.horasion.basics.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysDemo {

	public static void main(String[] args) {
		ArraysDemo demo = new ArraysDemo();
		int[] mainArray = new int[10];
		demo.demo1();

		// The static "fill" method returns void, so it manipulates given array.
		Arrays.fill(mainArray, 9);
		// Because arrays are passed by reference, the mainArray will be
		// changed inside of demo2 function.
		demo2(mainArray);

		System.out.printf("mainArray in main: %s\n", Arrays.toString(mainArray));
	}

	void demo1() {
		int[] field = new int[4]; // New arrays are initialised automatically,
		// default value for new integers in Java is 0
		char[] prefilledField = { 'a', 'x', 'z' };
		int[] randomField; // Not initialised, primitive types are NOT nullable!
		// int nonNullable = 3; // primitive int can never be null
		// Integer[] nullIntegerAr = null;//Wrappers of primitive types are nullable
		Integer nullableInteger = null;	// // All objects are nullable!
		// Local variables are not given default initial values. They must be initialized explicitly before they are used. Only instance + class variables and array components have default initial values.

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

		System.out.printf("length of prefilledField is %d\n\n", prefilledField.length); // 3
	}


	// Non-primitive arguments (arrays and objects) in Java are passed
	// by reference! This means that no copy is being created.
	// Only primitive types (a number, a char ...) are passed by value (copy).
	static void demo2(int[] userArray) {
		int[] localArray = new int[10]; // default values will be all 0's

		System.out.printf("localArray: %s\n", Arrays.toString(localArray));

		// The toString method returns the memory address.
		System.out.printf("userArray memory address: %s\n", userArray.toString());
		// To print the content of an array we must use Arrays.toString
		System.out.printf("userArray : %s\n", Arrays.toString(userArray));

		userArray[0] = 150;
		userArray[1] = 120;

		System.out.printf("userArray changed: %s\n", Arrays.toString(userArray));
 		Arrays.sort(userArray);
		System.out.printf("userArray sorted: %s\n", Arrays.toString(userArray));

		System.out.println(Arrays.equals(localArray, userArray)); // false
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

localArray: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
userArray memory address: [I@41629346
userArray : [9, 9, 9, 9, 9, 9, 9, 9, 9, 9]
userArray changed: [150, 120, 9, 9, 9, 9, 9, 9, 9, 9]
userArray sorted: [9, 9, 9, 9, 9, 9, 9, 9, 120, 150]
false
mainArray in main: [9, 9, 9, 9, 9, 9, 9, 9, 120, 150]

*/
