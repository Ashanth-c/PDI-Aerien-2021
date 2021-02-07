package data;

public class FlockBirds extends Obstacle {
	private int numberOfBirds;
	private int speed;

	public FlockBirds(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public FlockBirds(int abscisse, int ordonnee, int numberOfBirds, int speed) {
		super(abscisse, ordonnee);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}

	public FlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed) {
		super(abscisse, ordonnee, name, altitude);
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

	@Override
	public String toString() {
		return "FlockBirds [numberOfBirds=" + numberOfBirds + ", speed=" + speed + "]";
	}

}
