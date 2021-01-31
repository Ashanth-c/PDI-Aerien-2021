package data;

public class Aerodrome {
	private int totalRunway;
	private int runwayLenght;

	public Aerodrome(int totalRunway, int runwayLenght) {
		super();
		this.totalRunway = totalRunway;
		this.runwayLenght = runwayLenght;
	}

	public Aerodrome() {
		super();
	}

	public int getTotalRunway() {
		return totalRunway;
	}

	public void setTotalRunway(int totalRunway) {
		this.totalRunway = totalRunway;
	}

	public int getRunwayLenght() {
		return runwayLenght;
	}

	public void setRunwayLenght(int runwayLenght) {
		this.runwayLenght = runwayLenght;
	}

	@Override
	public String toString() {
		return "Aerodrome [totalRunway=" + totalRunway + ", runwayLenght=" + runwayLenght + "]";
	}

}
