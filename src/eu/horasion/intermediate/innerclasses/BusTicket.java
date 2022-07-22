package eu.horasion.intermediate.innerclasses;

// Inner class example with the "builder pattern", which is very common.
public class BusTicket extends Ticket {

	// fromLocation, toLocation, vehicleNumber are in abstract class Ticket
	private boolean withCatering;
	private boolean withTV;

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

	public boolean withCatering() {
		return withCatering;
	}

	public boolean withTV() {
		return withTV;
	}

	public static class Builder {

		private String fromLocation;
		private String toLocation;
		private int vehicleNumber;
		private boolean withCatering;
		private boolean withTV;

		Builder(String fromLocation, String toLocation) {
			this.fromLocation = fromLocation;
			this.toLocation = toLocation;
		}

		public Builder wantedCatering(boolean withCatering) {
			this.withCatering = withCatering;
			return this;
		}

		public Builder wantedTV(boolean withTV) {
			this.withTV = withTV;
			return this;
		}

		public BusTicket build() {
			return new BusTicket(this);
		}

	}

}
