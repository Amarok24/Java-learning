package eu.horasion.intermediate.innerclasses;

public class InnerDemo {

	public static void main(String[] args) {
		BusTicket fridayTicket = new BusTicket.Builder("Prague", "Berlin")
			.wantedCatering(true)
			.wantedTV(false);
	}
}
