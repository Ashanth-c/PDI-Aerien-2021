package data;

public class Line {
	private Airport departure;
	private Airport destination;

	public Line(Airport departure, Airport destination) {
		super();
		this.departure = departure;
		this.destination = destination;
	}

	public Line() {
		super();
	}

	public Airport getdeparture() {
		return departure;
	}

	public void setdeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getdestination() {
		return destination;
	}

	public void setdestination(Airport destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "\nDeparture = " + departure.getName() + ", Destination = " + destination.getName() + "\n";
	}
}
