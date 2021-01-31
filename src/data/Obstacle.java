package data;

public class Obstacle extends Block {
	private String name;
	private int altitude;

	public Obstacle(int startPoint, int endPoint) {
		super(startPoint, endPoint);
	}

	public Obstacle(int startPoint, int endPoint, String name, int altitude) {
		super(startPoint, endPoint);
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
