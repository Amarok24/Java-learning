package eu.horasion.intermediate.innerclasses2;

// This is a refactored innerclasses demo called innerclasses2.
// It avoids duplication of class fields.

public class InnerDemo {

	public static void main(String[] args) {
		// Remember the inner class BusTicket.Builder is a static class!
		BusTicket myTicket = new BusTicket.Builder("Prague", "Berlin")
			.wantedCatering(true)
			//.wantedTV(false)  If false then it would be redundand to specify.
			.build(); // build method returns the new BusTicket instance

		System.out.println(myTicket.toString());

		// The following is for demo purposes, to show how each step
		// of the builder pattern works.
		BusTicket.Builder rawTicket = new BusTicket.Builder("Pilsen", "Hamburg");
		rawTicket = rawTicket.wantedTV(true); // returns this Builder
		BusTicket myTicket2 = rawTicket.build(); // returns a new BusTicket

		System.out.println(myTicket2.toString());
	}
}

/*

From: Prague, To: Berlin, Vehicle #545, Catering true, TV false

From: Pilsen, To: Hamburg, Vehicle #460, Catering false, TV true

*/
