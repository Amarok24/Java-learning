package eu.horasion.intermediate.innerclasses;

import java.util.Random;

// Inner class example with the "builder pattern", which is very common.
public class BusTicket extends Ticket {

	// fromLocation, toLocation, vehicleNumber are in abstract class Ticket
	private boolean withCatering;
	private boolean withTV;

	// The constructor is private, BusTicket.Builder.build() is used
	// to create a new instance of a BusTicket.
	private BusTicket(Builder builder) {
		this.fromLocation = builder.fromLocation;
		this.toLocation = builder.toLocation;
		this.vehicleNumber = builder.vehicleNumber;
		this.withCatering = builder.withCatering;
		this.withTV = builder.withTV;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public boolean isWithCatering() {
		return withCatering;
	}

	public boolean isWithTV() {
		return withTV;
	}

	@Override
	public String toString() {
		return String.format("From: %s, To: %s, Vehicle #%d, Catering %b, TV %b\n", fromLocation, toLocation, vehicleNumber, withCatering, withTV);
	}

	// This inner class must be 'static' because we need access to it from
	// outside even before a new instance of BusTicket is created.
	public static class Builder {
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
