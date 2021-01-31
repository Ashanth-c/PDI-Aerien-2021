package data;

public class Moutain extends Obstacle {
	private String country;

	public Moutain(int startPoint, int endPoint) {
		super(startPoint, endPoint);
	}

	public Moutain(int startPoint, int endPoint, String name, int altitude, String country) {
		super(startPoint, endPoint, name, altitude);
		this.country = country;
	}

	public Moutain(int startPoint, int endPoint, String country) {
		super(startPoint, endPoint);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Moutain [country=" + country + "]";
	}

}