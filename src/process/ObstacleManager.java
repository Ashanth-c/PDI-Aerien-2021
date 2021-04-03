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
 * @author Ashanth, Maeva
 *
 *	Classe qui gère les obstacles
 *	Constituée par les attributs :
 *	obstacle (Obstacle), teta (double)
 */
public class ObstacleManager {

	private Obstacle obstacle;
	private double teta=0;
/**
 * Constructor ObsctacleManager
 */
	public ObstacleManager() {
		super();
	}
/**
 * Constructor ObstacleManager
 * @param obstacle
 */
	public ObstacleManager(Obstacle obstacle) {
		super();
		this.obstacle = obstacle;
	}
	
/**
 * 	moveFlockBirds method
 * @param rayon
 * 
 * Makes birds move in a circular trajectory
 */
	public void moveFlockBirds(double rayon) {
		double flockbirdsOrdonnee = obstacle.getOrdonnee();
		double flockbirdsAbscisse = obstacle.getAbscisse();
		if (teta>2 * (Math.PI)) {
			teta=0;
		}			
			flockbirdsAbscisse = rayon * (Math.cos(teta));
			flockbirdsOrdonnee = rayon * (Math.sin(teta));
			teta+=1/Math.PI;
		obstacle.setAbscisse((float) flockbirdsAbscisse);
		obstacle.setOrdonnee((float) flockbirdsOrdonnee);


	}
/**
 * impactMountain method
 * @param aeronef
 * 
 * Checks if an aeronef's coordinates match with an obstacle's
 */
	public void impactMountain(Aeronef aeronef) {
		if ((obstacle.getAbscisse() == aeronef.getAbscisse()) && obstacle.getOrdonnee() == aeronef.getOrdonnee()) {
			if (obstacle.getAltitude() >= aeronef.getAltitude()) {
			}
		}
	}
/**
 * avoidFlockBirds method
 * @param aeronef
 * 
 * Makes an aeronef dodge flockBirds if it's close enough by changing the aeronef's altitude
 */
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
/**
 * avoidMountain method
 * @param aeronef
 * 
 * Makes an aeronef dodge a mountain if it's close enough by changing its altitude 
 */
	public void avoidMountain(Aeronef aeronef) {
		 float mountainAbscisse = obstacle.getAbscisse();
		float mountainOrdonnee = obstacle.getOrdonnee();
		float aeronefsAbscisse = aeronef.getAbscisse();
		float aeronefsOrdonnee = aeronef.getOrdonnee();
		int mountainaltitude = obstacle.getAltitude();
		
//		if (aeronefsAbscisse+10 >= mountainAbscisse && aeronefsOrdonnee + 10 >= mountainOrdonnee && aeronefsAbscisse - 30 <= mountainAbscisse && aeronefsOrdonnee - 30 <= mountainOrdonnee) {
		float dx = (aeronefsAbscisse+20) - mountainAbscisse;
		float dy = (aeronefsOrdonnee+20) - mountainOrdonnee;
		double distance = Math.sqrt(dx * dx + dy * dy);
		if (distance < 40) {
				if (aeronef.getAltitude() <= mountainaltitude) {
					aeronef.setDetectObstacle("Obstacle");
					mountainaltitude += 150;
					aeronef.setAltitude(mountainaltitude);
					System.out.println("Detection de Montagne proche" + aeronef.getDetectObstacle());
				}
		}
		else {
			aeronef.setDetectObstacle("No");
			mountainaltitude -= 150;
			aeronef.setAltitude(mountainaltitude);
		}

	}
}