package eu.horasion.basics.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;


interface ByteCalcFunction {
	// Type `byte` in Java is a signed byte!!! range -128..127
	byte run(byte input);
}

/**
 * LambdaDemo
 */
public class LambdaDemo {

	public static void main(String[] args) {
		clearConsole();
		System.out.println("DEMO1:");
		demo1();
		System.out.println("DEMO2:");
		demo2();
	}

	static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	static void demo1() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		numbers.add(5);
		numbers.add(9);
		numbers.add(8);

		Consumer<Integer> method = (n) -> {
			System.out.println(n);
		};

		numbers.forEach(method);
	}

	static void demo2() {
		byte[] numbers = { 2, 0, 2, 6 };
		ByteCalcFunction increase = (n) -> ++n;
		ByteCalcFunction decrease = (n) -> --n;
		// ALTERNATIVELY (SAME) ByteCalcFunction decrease = (n) -> (byte)(n - 1);

		for(byte b : numbers) {
			System.out.println(changeValue(b, increase)); // 3,1,3,7  correct!
		}

		// Numbers entered directly (literal values) are of type integer in Java.

		System.out.println(changeValue((byte)24, decrease)); // 23  correct!
		System.out.println(changeValue(127, increase)); // -128  correct!
		System.out.println(changeValue((byte)-127, decrease)); // -128  correct!
		System.out.println(changeValue(-128, decrease)); // 127  correct!
	}

	static byte changeValue(byte value, ByteCalcFunction fn) {
		System.out.println("byte version here, returning:");
		return fn.run(value);
	}

	static byte changeValue(int value, ByteCalcFunction fn) {
		System.out.println("int version here, returning:");
		return fn.run((byte)value);
	}

}

/*

DEMO1:
5
9
8
DEMO2:
byte version here, returning:
3
byte version here, returning:
1
byte version here, returning:
3
byte version here, returning:
7
byte version here, returning:
23
int version here, returning: 
-128
byte version here, returning:
-128
int version here, returning: 
127

*/
