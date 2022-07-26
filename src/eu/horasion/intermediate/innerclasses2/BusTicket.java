package eu.horasion.intermediate.innerclasses2;

import java.util.Random;

// 2nd inner class example with the "builder pattern".
public class BusTicket {

	// Compared to innerclasses (v1) demo there are no class field duplications,
	// I only keep the Builder object reference here.
	private Builder rawTicket;

	// The constructor is private, BusTicket.Builder.build() is used
	// to create a new instance of a BusTicket.
	private BusTicket(Builder rawTicket) {
		this.rawTicket = rawTicket;
	}

	public String getFromLocation() {
		return rawTicket.fromLocation;
	}

	public String getToLocation() {
		return rawTicket.toLocation;
	}

	public int getVehicleNumber() {
		return rawTicket.vehicleNumber;
	}

	public boolean isWithCatering() {
		return rawTicket.withCatering;
	}

	public boolean isWithTV() {
		return rawTicket.withTV;
	}

	@Override
	public String toString() {
		return String.format("From: %s, To: %s, Vehicle #%d, Catering %b, TV %b\n", getFromLocation(), getToLocation(), getVehicleNumber(), isWithCatering(), isWithTV());
	}

	// The whole inner class here is almost *without* any modifications,
	// only the "extends Ticket" has been added compared to innerclasses demo.

	// This inner class must be 'static' because we need access to it from
	// outside even before a new instance of BusTicket is created.
	public static class Builder extends Ticket {
		// Following class fields are not static, so they are instance variables.
		// Class fields will get default values if not initialised.
		String fromLocation;
		String toLocation; // default for object is null
		int vehicleNumber; // default for int is 0
		boolean withCatering; // default for boolean is false
		boolean withTV;

		Builder(String fromLocation, String toLocation) {
			this.fromLocation = fromLocation;
			this.toLocation = toLocation;
			vehicleNumber = new Random().nextInt(1000); // 0..999
		}

		Builder wantedCatering(boolean withCatering) {
			this.withCatering = withCatering;
			return this;
		}

		Builder wantedTV(boolean withTV) {
			this.withTV = withTV;
			return this;
		}

		BusTicket build() {
			return new BusTicket(this);
		}

	}

}
