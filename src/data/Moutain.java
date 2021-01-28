package data;

public class Moutain extends Obstacle {
	private String country;

	public Moutain(String name, int numberOfObstacle, String country) {
		super(name, numberOfObstacle);
		this.country = country;
	}

	public Moutain(String name, int numberOfObstacle) {
		super(name, numberOfObstacle);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}