package eu.horasion.advanced.generics;

import java.util.Collection;

public class DetectionBox<T> {

	private T data;
	private int length = -1;

	public DetectionBox(T data) {
		this.data = data;

		// String implements interface CharSequence
		if(data instanceof CharSequence) {
			System.out.println("Generic parameter is a CharSequence");
			CharSequence s = (CharSequence)data;
			length = s.length();
		}
		else if(data instanceof Collection) {
			System.out.println("Generic parameter is a Collection");
			length = ((Collection<?>)data).size();
		}
	}

	public int getLength() { return length; }

	public void validate() {
		if(data instanceof Integer) {
			if((Integer)data >= 100) {
				System.out.println("It is a big number, >= 100");
			}
			else {
				System.out.println("It is a small Integer, < 100");
			}
			return;
		}
		else if(data instanceof CharSequence) {
			System.out.println("It is a CharSequence, calling toString()");
			System.out.println(data.toString());
		}
		else {
			System.out.println("It's neither an Integer or a CharSequence.");
		}
	}

}
