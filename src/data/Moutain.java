package data;

public class Moutain extends Obstacle {
	private String country;

	public Moutain(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public Moutain(int abscisse, int ordonnee, String name, int altitude, String country) {
		super(abscisse, ordonnee, name, altitude);
		this.country = country;
	}

	public Moutain(int abscisse, int ordonnee, String country) {
		super(abscisse, ordonnee);
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
