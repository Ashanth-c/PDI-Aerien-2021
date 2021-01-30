package engine;

public class Block {
	private int startPoint;
	private int endPoint;

	public Block(int startPoint, int endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
}
