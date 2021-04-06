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


/*!
 * @file ObstacleManager.java
 * @brief Classe qui gère les obstacles, Constituée par les attributs :obstacle (Obstacle), teta (double)
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class ObstacleManager {

	private Obstacle obstacle;
	private double teta=0;
/*!
 * ObsctacleManager()
 * @brief  gère les obstacles
 */
	public ObstacleManager() {
		super();
	}
/*!
 * ObstacleManager()
 * @param obstacle
 */
	public ObstacleManager(Obstacle obstacle) {
		super();
		this.obstacle = obstacle;
	}
	
/*!
 * moveFlockBirds()
 * @param rayon
 * 
 * @brief Fait bouger les oiseaux selon une trajectoire circulaire
 */
	public void moveFlockBirds(double rayon) {
		double flockbirdsOrdonnee = obstacle.getOrdinate();
		double flockbirdsAbscisse = obstacle.getAbscissa();
		if (teta>2 * (Math.PI)) {
			teta=0;
		}			
			flockbirdsAbscisse = rayon * (Math.cos(teta));
			flockbirdsOrdonnee = rayon * (Math.sin(teta));
			teta+=1/Math.PI;
		obstacle.setAbscissa((float) flockbirdsAbscisse);
		obstacle.setOrdinate((float) flockbirdsOrdonnee);


	}
/*!
 * impactMountain()
 * @param aeronef
 * 
 * @brief Vérifie si les coordonnées d'un aeronef correspondent à celles d'un obstacle
 */
	public void impactMountain(Aeronef aeronef) {
		if ((obstacle.getAbscissa() == aeronef.getAbscissa()) && obstacle.getOrdinate() == aeronef.getOrdinate()) {
			if (obstacle.getAltitude() >= aeronef.getAltitude()) {
			}
		}
	}
/*!
 * avoidFlockBirds()
 * @param aeronef
 * 
 * @brief Fait un troupeau d'esquive d'aéronef - Oiseaux s'il est assez proche en changeant l'altitude de l'aéronef
 */
	public void avoidFlockBirds(Aeronef aeronef) {
		float flockbirdsAbscisse = obstacle.getAbscissa();
		float flockbirdsOrdonnee = obstacle.getOrdinate();
		float aeronefsAbscisse = aeronef.getAbscissa();
		float aeronefsOrdonnee = aeronef.getOrdinate();
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
/*!
 * avoidMountain()
 * @param aeronef
 * 
 * @brief Permet à un aeronef d'esquiver une montagne si elle est suffisamment proche en changeant son altitude
 */
	public void avoidMountain(Aeronef aeronef) {
		float mountainAbscisse = obstacle.getAbscissa();
		float mountainOrdonnee = obstacle.getOrdinate();
		float aeronefsAbscisse = aeronef.getAbscissa();
		float aeronefsOrdonnee = aeronef.getOrdinate();
		int mountainaltitude = obstacle.getAltitude();
		
		float dx = (aeronefsAbscisse) - mountainAbscisse;
		float dy = (aeronefsOrdonnee) - mountainOrdonnee;
		double distance = Math.sqrt(dx * dx + dy * dy);
		if ((distance < 40)) {
			if (aeronef.getAltitude() <= obstacle.getAltitude()) {
					aeronef.setDetectObstacle(true);
					mountainaltitude += 150;
					aeronef.setAltitude(mountainaltitude);
				}
		}
		else {
			aeronef.setDetectObstacle(false);
		}
	}
}
