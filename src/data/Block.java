package data;

public class Block {
	private int abscisse;
	private int ordonnee;


	public Block(int abscisse, int ordonnee) {
		super();
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}



	@Override
	public String toString() {
		return "Block [l'abscisse=" + abscisse + ", l'ordonnée=" +ordonnee + "]";
	}
}

