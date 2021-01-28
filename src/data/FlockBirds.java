package data;

public class FlockBirds extends Obstacle {
	private int numberOfBirds;
	private int speed;

	public FlockBirds(String name, int numberOfObstacle, int numberOfBirds, int speed) {
		super(name, numberOfObstacle);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}

	public FlockBirds(String name, int numberOfObstacle) {
		super(name, numberOfObstacle);
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
