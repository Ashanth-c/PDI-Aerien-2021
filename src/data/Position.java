package data;

public class Position {
	private float abscisse;
	private float ordinate;

	public Position(float abscisse, float ordinate) {
		super();
		this.abscisse = abscisse;
		this.ordinate = ordinate;

	}

	public float getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(float abscisse) {
		this.abscisse = abscisse;
	}

	public float getOrdonnee() {
		return ordinate;
	}

	public void setOrdonnee(float ordinate) {
		this.ordinate = ordinate;
	}

	@Override
	public String toString() {
		return "Position [abscisse=" + abscisse + ", ordinate=" + ordinate + "]";
	}
}