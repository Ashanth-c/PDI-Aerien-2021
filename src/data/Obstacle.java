package data;

public class Obstacle {
	private String name;
	private int numberOfObstacle;

	public Obstacle(String name, int numberOfObstacle) {
		super();
		this.name = name;
		this.numberOfObstacle = numberOfObstacle;
	}

	public Obstacle() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfObstacle() {
		return numberOfObstacle;
	}

	public void setNumberOfObstacle(int numberOfObstacle) {
		this.numberOfObstacle = numberOfObstacle;
	}

}
