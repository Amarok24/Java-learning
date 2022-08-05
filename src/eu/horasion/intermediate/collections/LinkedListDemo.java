package eu.horasion.intermediate.collections;

import java.util.LinkedList;

/*
 *       [ interface Collection ]
 *            /          \
 *          /             \
 *   [interface List]   [interface Queue]
 *     |        |         |
 *     |    [ CLASS LinkedList ]
 *     |
 *     |
 *   [CLASS ArrayList] [CLASS Vector]
 */

// https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/LinkedList.html
public class LinkedListDemo {

	public static void main(String[] args) {
		var myList = new LinkedList<String>();
		var fifoList = new LinkedList<Integer>();
		Integer number;

		myList.add("one");
		myList.add("two");
		myList.addFirst("zero");
		myList.addLast("three"); // addLast() == add()

		if(!myList.isEmpty()) {
			// `get` methods throw an exception if list is empty
			System.out.println(myList.getFirst());
		}

		// `peek` methods return `null` if no element found
		System.out.printf("peekFirst: %s\n", myList.peekFirst());
		System.out.println(myList);

		if(!myList.isEmpty()) {
			// `remove` methods throw an exception if list is empty
			System.out.print("Removing first element. It's value is: ");
			System.out.println(myList.removeFirst()); // removeFirst() == pop()
		}

		System.out.println(myList);

		// A FIFO list can be easily used with push() and pop() methods.
		fifoList.push(1);
		fifoList.push(2);
		fifoList.push(3);
		fifoList.push(4);

		System.out.println("FIFO list:");
		System.out.println(fifoList);

		number = fifoList.pop(); // 4

		System.out.printf("Popped number from FIFO list is %d\n", number);
		System.out.println(fifoList); // [3,2,1]
	}

}

/*

zero
peekFirst: zero
[zero, one, two, three]
Removing first element. It's value is: zero
[one, two, three]
FIFO list:
[4, 3, 2, 1]
Popped number from FIFO list is 4
[3, 2, 1]

*/
