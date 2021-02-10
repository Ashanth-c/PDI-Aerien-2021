package process;

import java.util.ArrayList;
import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Block;
import data.FlockBirds;
import data.Line;
import data.Moutain;

public class BlockManager {

	private Block block;
	private List<Aeronef> aeronefs = new ArrayList<Aeronef>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Moutain> mountains = new ArrayList<Moutain>();

	public BlockManager(Block block) {
		super();
		this.block = block;
	}

	public BlockManager() {
		super();
	}

	public void addAeronef(Aeronef aeronef) {
		aeronefs.add(aeronef);

	}

	public void addBirds(FlockBirds flockBirds) {
		birds.add(flockBirds);

	}

	public void addMountain(Moutain mountain) {
		mountains.add(mountain);

	}

	public void impactMountain() {
		for (Aeronef aeronef : aeronefs) {
			for (Moutain moutain : mountains) {
				if ((moutain.getAbscisse() == aeronef.getAbscisse())
						&& moutain.getOrdonnee() == aeronef.getOrdonnee()) {
					if (moutain.getAltitude() >= aeronef.getAltitude()) {

					}
				}
			}
		}
	}

	public float abscisseVariationValue(Aeronef aeronef, Airport destinationAirport, Integer time) {
		float aeronefAbscisse = aeronef.getAbscisse();
		float airportAbscisse = destinationAirport.getAbscisse();

		float abscisseVariation = (airportAbscisse - aeronefAbscisse) / time;

		return abscisseVariation;

	}

	public float ordoneeVariationValue(Aeronef aeronef, Airport destinationAirport, Integer time) {
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float airportOrdonnee = destinationAirport.getOrdonnee();

		float ordonneeVariation = (airportOrdonnee - aeronefOrdonnee) / time;

		return ordonneeVariation;

	}

	public void MoveAeronefAbcsisse(Aeronef aeronef, float abscisseVariation) {
		float aeronefAbscisse = aeronef.getAbscisse();

		aeronefAbscisse += abscisseVariation;
		aeronef.setAbscisse(aeronefAbscisse);

	}

	public void MoveAeronefOrdonnee(Aeronef aeronef, float ordonneeVariation) {
		float aeronefOrdonnee = aeronef.getOrdonnee();

		aeronefOrdonnee += ordonneeVariation;
		aeronef.setOrdonnee(aeronefOrdonnee);

	}

}
