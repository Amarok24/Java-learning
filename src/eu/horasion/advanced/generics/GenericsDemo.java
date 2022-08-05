package eu.horasion.advanced.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		// Generics cannot be instantiated with a primitive type,
		// for example `new ArrayList<int>();` is an error.
		var numberList = new ArrayList<Integer>();
		var fifoList = new LinkedList<String>() {

			{
				push("hello");
				push("world");
			}

		};

		numberList.add(5);
		numberList.add(10);
		numberList.add(15);

		System.out.println("numberList details:");
		MyUtils.displayList(numberList);

		System.out.println("-------------------");

		System.out.println("fifoList details:");
		MyUtils.displayList(fifoList);

		System.out.println("-------------------");

		System.out.println("fifoList toString via MyUtils:");
		MyUtils.displayToString(fifoList);

		System.out.println("\n------DETECTIONBOX---------");

		DetectionBox<String> testString = new DetectionBox<>("Hello world");
		testString.validate();
		System.out.printf("length of testString is %d\n", testString.getLength());

		// .....
	}

}

/*

numberList details:
It's an ArrayList, printing content:
[5, 10, 15]
-------------------
fifoList details:
It's a LinkedList, printing content:
[world, hello]
-------------------
fifoList toString via MyUtils:
[world, hello]

------DETECTIONBOX---------
Generic parameter is a CharSequence
It is a CharSequence, calling toString()
Hello world
length of testString is 11

*/
