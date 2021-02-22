package data;

public class Obstacle extends Position {
	private String name;
	private int altitude;

	public Obstacle(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public Obstacle(int abscisse, int ordonnee, String name, int altitude) {
		super(abscisse, ordonnee);
		this.name = name;
		this.altitude = altitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Override
	public String toString() {
		return "Obstacle [name=" + name + ", altitude=" + altitude + "]";
	}

}
