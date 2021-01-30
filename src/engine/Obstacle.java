package engine;

public class Obstacle extends Block {
	private String name;

	public Obstacle(int startPoint, int endPoint) {
		super(startPoint, endPoint);
	}

	public Obstacle(int startPoint, int endPoint, String name) {
		super(startPoint, endPoint);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
