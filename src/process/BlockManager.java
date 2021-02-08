package process;

import java.util.ArrayList;
import java.util.List;

import data.Aeronef;
import data.Block;
import data.FlockBirds;
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

}
