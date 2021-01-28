package data;

public class Line {
	private Airport airport1;
	private Airport airport2;

	public Line(Airport airport1, Airport airport2) {
		super();
		this.airport1 = airport1;
		this.airport2 = airport2;
	}

	public Line() {
		super();
	}

	public Airport getAirport1() {
		return airport1;
	}

	public void setAirport1(Airport airport1) {
		this.airport1 = airport1;
	}

	public Airport getAirport2() {
		return airport2;
	}

	public void setAirport2(Airport airport2) {
		this.airport2 = airport2;
	}
}
