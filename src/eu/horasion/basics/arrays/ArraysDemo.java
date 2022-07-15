package eu.horasion.basics.arrays;

import java.util.Random;

public class ArraysDemo {

	public static void main(String[] args) {
		ArraysDemo demo = new ArraysDemo();
		demo.demo1();
	}

	void demo1() {
		int[] field = new int[4]; // new arrays are initialised automatically
		// default value for new integers in Java is 0
		int[] randomField;

		for(int i : field) {
			System.out.println(i); // will print all zeros
		}

		randomField = new int[3];

		for(int i = 0; i < randomField.length; i++) {
			randomField[i] = new Random().nextInt(100); // 0..99
			System.out.println(randomField[i]);
		}
	}

}
