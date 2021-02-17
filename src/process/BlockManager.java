package process;

import java.util.ArrayList;
import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Block;
import data.FlockBirds;
import data.Line;
import data.Moutain;

/**
 * 
 * @author Ashanth
 *
 */
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

	public void moveFlockBirds(FlockBirds flockbirds, int rayon, double teta) {
        double flockbirdsOrdonnee=flockbirds.getOrdonnee();
        double flockbirdsAbscisse=flockbirds.getAbscisse();


        flockbirdsAbscisse+=rayon*(Math.cos(teta));
        flockbirdsOrdonnee+=rayon*(Math.sin(teta));

        flockbirds.setAbscisse((float) flockbirdsAbscisse);
        flockbirds.setOrdonnee((float) flockbirdsOrdonnee);
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
	
	public void avoidFlockBirds(FlockBirds flockbirds, Aeronef aeronef) {
        float flockbirdsAbscisse = flockbirds.getAbscisse();
        float flockbirdsOrdonnee = flockbirds.getOrdonnee();
        float aeronefsAbscisse = aeronef.getAbscisse();
        float aeronefsOrdonnee = aeronef.getOrdonnee();
        int flockbirdsaltitude = flockbirds.getAltitude();
        int aeronefaltitude= aeronef.getAltitude();

        if (((aeronefsAbscisse +10)>= flockbirdsAbscisse) && (aeronefsOrdonnee + 10)>= flockbirdsOrdonnee) {
            if (aeronefaltitude==flockbirdsaltitude) {
                System.out.println("Detection d'un groupe d'oiseau proche");
                aeronefaltitude+=150;
                aeronef.setAltitude(aeronefaltitude);
                System.out.println("Obstacle évité");
            }
        }
    }

	public void avoidMountain(Moutain moutain, Aeronef aeronef) {
		float mountainAbscisse = moutain.getAbscisse();
		float mountainOrdonnee = moutain.getOrdonnee();
		float aeronefsAbscisse = aeronef.getAbscisse();
		float aeronefsOrdonnee = aeronef.getOrdonnee();
		int mountainaltitude = moutain.getAltitude();
		
		if (((aeronefsAbscisse + 10) >= mountainAbscisse) && ((aeronefsOrdonnee + 10) >= mountainOrdonnee)) {
			if (aeronef.getAltitude() <= mountainaltitude) {
				mountainaltitude+=150;
				aeronef.setAltitude(mountainaltitude);
				System.out.println("Detection de Montagne proche");
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
	
	public void checkAirportsAround(Aeronef aeronef, Airport airport) {
		
		aeronef.setUrgent(true);
		float aeronefOrdonnee=aeronef.getOrdonnee();
		float aeronefAbscisse=aeronef.getAbscisse();
		
				if (((aeronefAbscisse + 10) >= airport.getAbscisse()) && ((aeronefOrdonnee + 10) >= airport.getOrdonnee())) {
					emergencyLanding(aeronef, airport);

					System.out.println("Atterissage en urgence réussi");
					aeronef.setUrgent(false);
			
		}
	}		
	
	
	public void emergencyLanding(Aeronef aeronef, Airport airport) {

		float aeronefOrdonnee=aeronef.getOrdonnee();
		float aeronefAbscisse=aeronef.getAbscisse();
		
		float abscisseVariationValue = abscisseVariationValue(aeronef, airport, 20);
		float ordoneeVariationValue = ordoneeVariationValue(aeronef, airport, 20);
		
		while (((int) aeronef.getAbscisse() != airport.getAbscisse())
							&& ((int) aeronef.getOrdonnee() != airport.getOrdonnee())) {
	
			MoveAeronefAbcsisse(aeronef, abscisseVariationValue);
			MoveAeronefOrdonnee(aeronef, ordoneeVariationValue);
			System.out.println("Coordonnees de l'aeronef en urgence : " + aeronef.getAbscisse()+ " , "
								+ aeronef.getOrdonnee());
		}
	}

}