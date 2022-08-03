package eu.horasion.intermediate.records;

import java.util.ArrayList;

public class WebShopApp {

	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<>();

		Product lamp = new Product("lamp", "A green lamp.", (float)19.99);
		Product headphones = new Product("headphones", "Black wired headphones.", (float)9.90);
		Product headphones2 = new Product("headphones", "Black wired headphones.", (float)9.9);

		// This equality test returns `true` because a record is used!!
		// With a simple class it would return 'false', see module "superobject".
		// See also Product.java with more infos about records.
		System.out.printf("headphones == headphones2 ? %b\n", headphones.equals(headphones2));

		System.out.printf("Adding '%s' to the list\n", lamp.name());
		productList.add(lamp);

		productList.add(new Product("table", "A wooden table, brown colour.", (float)145));

		// Adding at a specifix index won't overwrite the content, but it will
		// be shifted to the next position.
		productList.add(1, headphones);
		// To add at a specific index and overwrite existing content, use .set()

		System.out.println(productList);
		System.out.println("\n---FOR EACH LOOP---");
		System.out.printf("There are %d products in the list:\n\n", productList.size());

		for(Product p : productList) {
			System.out.println(p);
		}
	}
}

/*

headphones == headphones2 ? true
Adding 'lamp' to the list
[Product[name=lamp, description=A green lamp., price=19.99], Product[name=headphones, description=Black wired headphones., price=9.9], Product[name=table, description=A wooden table, brown colour., price=145.0]]

---FOR EACH LOOP---
There are 3 products in the list:

Product[name=lamp, description=A green lamp., price=19.99]
Product[name=headphones, description=Black wired headphones., price=9.9]
Product[name=table, description=A wooden table, brown colour., price=145.0]

*/
