package data;

public class Mountain extends Obstacle {
	private String country;

	public Mountain(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public Mountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		super(abscisse, ordonnee, name, altitude);
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
		return "Mountain "+getName();
	}

}
