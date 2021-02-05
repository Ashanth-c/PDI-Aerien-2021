package data;

public class Block {
	private int startPoint;
	private int endPoint;
	private int currentPoint;

	public Block(int startPoint, int endPoint, int currentPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.currentPoint = currentPoint;
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
	
	public int getCurrentPoint() {
		return currentPoint;
	}
	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}


	@Override
	public String toString() {
		return "Block [startPoint=" + startPoint + ", endPoint=" + endPoint +",currentPoint=" + currentPoint + "]";
	}
}
