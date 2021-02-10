package data;

public class Block {
	private float abscisse;
	private float ordonnee;


	public Block(float abscisse, float ordonnee) {
		super();
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		
	}

	public float getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(float abscisse) {
		this.abscisse = abscisse;
	}

	public float getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(float ordonnee) {
		this.ordonnee = ordonnee;
	}



	@Override
	public String toString() {
		return "Block [l'abscisse=" + abscisse + ", l'ordonnée=" +ordonnee + "]";
	}
}

