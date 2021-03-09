package process;

import java.util.ArrayList;
import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Position;
import data.FlockBirds;
import data.Line;
import data.Mountain;
import data.Obstacle;

/**
 * 
 * @author Ashanth
 *
 */
public class ObstacleManager {

	Obstacle obstacle;

	public ObstacleManager() {
		super();
	}

	public ObstacleManager(Obstacle obstacle) {
		super();
		this.obstacle = obstacle;
	}

	public void moveFlockBirds(FlockBirds flockbirds, int rayon, double teta) {
		double flockbirdsOrdonnee = flockbirds.getOrdonnee();
		double flockbirdsAbscisse = flockbirds.getAbscisse();

		flockbirdsAbscisse += rayon * (Math.cos(teta));
		flockbirdsOrdonnee += rayon * (Math.sin(teta));

		flockbirds.setAbscisse((float) flockbirdsAbscisse);
		flockbirds.setOrdonnee((float) flockbirdsOrdonnee);

	}

	public void impactMountain(Aeronef aeronef) {
		if ((obstacle.getAbscisse() == aeronef.getAbscisse()) && obstacle.getOrdonnee() == aeronef.getOrdonnee()) {
			if (obstacle.getAltitude() >= aeronef.getAltitude()) {
			}
		}
	}

	public void avoidFlockBirds(Aeronef aeronef) {
		float flockbirdsAbscisse = obstacle.getAbscisse();
		float flockbirdsOrdonnee = obstacle.getOrdonnee();
		float aeronefsAbscisse = aeronef.getAbscisse();
		float aeronefsOrdonnee = aeronef.getOrdonnee();
		int flockbirdsaltitude = obstacle.getAltitude();
		int aeronefaltitude = aeronef.getAltitude();

		if (((aeronefsAbscisse + 10) >= flockbirdsAbscisse) && (aeronefsOrdonnee + 10) >= flockbirdsOrdonnee) {
			if (aeronefaltitude == flockbirdsaltitude) {
				System.out.println("Detection d'un groupe d'oiseau proche");
				aeronefaltitude += 150;
				aeronef.setAltitude(aeronefaltitude);
				System.out.println("Obstacle évité");
			}
		}
	}

	public void avoidMountain(Aeronef aeronef) {
		float mountainAbscisse = obstacle.getAbscisse();
		float mountainOrdonnee = obstacle.getOrdonnee();
		float aeronefsAbscisse = aeronef.getAbscisse();
		float aeronefsOrdonnee = aeronef.getOrdonnee();
		int mountainaltitude = obstacle.getAltitude();

		if (((aeronefsAbscisse + 10) >= mountainAbscisse) && ((aeronefsOrdonnee + 10) >= mountainOrdonnee)) {
			if (aeronef.getAltitude() <= mountainaltitude) {
				mountainaltitude += 150;
				aeronef.setAltitude(mountainaltitude);
				System.out.println("Detection de Montagne proche");
			}
		}
	}
}