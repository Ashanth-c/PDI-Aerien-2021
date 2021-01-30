package data;

public class FlockBirds extends Obstacle {
	private int numberOfBirds;
	private int speed;

	public FlockBirds(int startPoint, int endPoint) {
		super(startPoint, endPoint);
	}

	public FlockBirds(int startPoint, int endPoint, int numberOfBirds, int speed) {
		super(startPoint, endPoint);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}

	public FlockBirds(int startPoint, int endPoint, String name, int altitude, int numberOfBirds, int speed) {
		super(startPoint, endPoint, name, altitude);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}

	public int getNumberOfBirds() {
		return numberOfBirds;
	}

	public void setNumberOfBirds(int numberOfBirds) {
		this.numberOfBirds = numberOfBirds;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
