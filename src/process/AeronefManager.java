package process;

import data.Aeronef;
import data.Airport;
import data.Position;
import gui.SimulPara;
/*!
 * @file AeronefManager.java
 * @brief Classe gérant les aeronefs,  Cette classe est une classe fille de la classe Thread
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */

public class AeronefManager extends Thread {
	private Aeronef aeronef;
	private float abscisseVariationValue;
	private float ordoneeVariationValue;
	private Airport destinationAirport;
	private boolean running = true;
	private String isInUrgence="SearchEmergencyAirport";
	private String direction;
	private AirportManager departureManager;
/*!
 * AeronefManager()
 * @param aeronef 
 * @brief gérer les aeronef
 */
	
	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
		this.destinationAirport = ElementManager.getAiportFromName(aeronef.getDestination());
		this.abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);
		this.ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);
		getDirection();

	}
	
/*!
 * run()
 * @brief Méthode de la classe Thread qui a été remplacée, déplace un Aeronef, traite l'atterrissage d'urgence d'un Aeronef
 * 
 */

	@Override
	public void run() {
		aeronef.setFlying(true);
		initAeronefAltitute(aeronef.getType());
		while(running) {
			Utility.unitTime();
			
			//if Aeronef's urgent attribute is true and isInUrgence string isn't FindAirport
			if (aeronef.getUrgent() && (!isInUrgence.contentEquals("FindAirport"))) {
				
				//if isInUrgent is "SearchEmergencyAirport"
				if(isInUrgence.equals("SearchEmergencyAirport")) {
					
					//Airports around the Aeronef are checked
					isInUrgence=ElementManager.checkAirportsAround(aeronef);
					
					//if isInUrgent isn't "SearchEmergenyAirport"
					if(!isInUrgence.equals("SearchEmergencyAirport")) {	
						
						//set new destinationAirport as the closest airport that's been found
						destinationAirport = ElementManager.getAiportFromName(isInUrgence);	
						aeronef.setDestination(destinationAirport.getName());
						
						//Aeronef's type is set as Emergency
						aeronef.setType("Emergency");
						
						//Aeronef moves toward new destination
						abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_URGENCE_SPEED);
						ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_URGENCE_SPEED);
						
						//isInUrgence is set back to "FindAirport"
						isInUrgence="FindAirport";
						
					}
				}
			}
			
			//else moves an Aeronef normally
			travelAeronef();
		}
		aeronef.setFlying(false);
		aeronef.setAltitude(0);

	}

/*!
 * landingAltitute() 
 * @param aeronef
 * 
 * @brief Augmente l'altitude d'un Aeronef si elle est de 0
 */
	
	public void landingAltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude == 0) {
			aeronef.setAltitude(AeronefAltitude++);
			AeronefAltitude = aeronef.getAltitude();

		}

	}
/*!
 * takeOffAtltitute()
 * @param aeronef
 * 
 * @brief Diminue l'altitude d'un Aeronef si ce n'est pas 0
 */

	public void takeOffAtltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude != 0) {
			aeronef.setAltitude(AeronefAltitude--);
			AeronefAltitude = aeronef.getAltitude();

		}

	}
/*!
 * slowDownSpeed()
 * @param aeronef
 * 
 * @brief Diminue la vitesse d'un Aeronef
 */

	public void slowDownSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed - 100);

	}
/*!
 * accelerateSpeed()
 * @param aeronef
 * 
 * @brief Augmente la vitesse d'un Aeronef
 */

	public void accelerateSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed + 100);

	}
/*!
 * landingSpeed()
 * @param aeronef
 * 
 * @brief Diminue la vitesse d'un Aeronef si ce n'est pas 0
 */

	public void landingSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed != 0) {
			slowDownSpeed(aeronef);
		}
	}
	
/*!
 * takeOffSpeed()
 * @param aeronef
 * 
 * 
 * @brief Augmente la vitesse d'un Aeronef si elle est de 0
 */

	public void takeOffSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed == 0) {
			accelerateSpeed(aeronef);
		}
	}
/*!
 * approachAirport()
 * @param aeronef une avion
 * @param airport un aeroport
 * 
 * @brief Écrit dans la console si un Aeronef se rapproche d'un aéroport
 */
	public void approchAirport(Aeronef aeronef, Airport airport) {
		float aeronefAbscisse = aeronef.getAbscissa();
		float aeronefOrdonnee = aeronef.getOrdinate();
		float airportAbscisse = airport.getAbscissa();
		float airportOrdonnee = airport.getOrdinate();

		if (java.lang.Math.sqrt(java.lang.Math.pow((airportAbscisse - aeronefAbscisse), 2)
				+ java.lang.Math.pow((airportOrdonnee - aeronefOrdonnee), 2)) < 100) {
			System.out.println("l'aeronef se rapproche de l'aÃ©roport:" + airport + "Et La distance entre eux est:"
					+ (java.lang.Math.sqrt(java.lang.Math.pow((airportAbscisse - aeronefAbscisse), 2)
							+ java.lang.Math.pow((airportOrdonnee - aeronefOrdonnee), 2))));

		}

	}

	/*!
	 * 	travelAeronef()
	 * 
	 * @brief Fait bouger Aeronef jusqu'à ce qu'il atteigne sa destination
	 * @brief Définit le booléen en cours d'exécution selon que l'Aeronef est autorisé à atterrir
	 */
	public void travelAeronef() {
		//Aeronef évite l'obstacle
		ElementManager.avoidObstacle(this);
		
		//si la position d'Aeronef n'est pas encore celle de sa destination, Aeronef bouge
		if (( aeronef.getAbscissa() != destinationAirport.getAbscissa()) && ( aeronef.getOrdinate() != destinationAirport.getOrdinate())) {
			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
		}		
		/* si la position d'Aeronef est sa destination
		 * on ajoute l'aéroport de destination dans un airportmanager
		 * si l'Aeronef a l'autorisation d'atterrir, la course est définie sur false. sinon, courir est vrai.
		 * puis on sort
		 */
		else {
			AirportManager airportManager = new AirportManager(destinationAirport);
			running = !(airportManager.airportLandingAuthorization(aeronef));
			exit();
		}
	}
	
/*!
 * moveAeronefAbscisse()
 * @param abscisseVariation
 * 
 * @brief Déplace un Aeronef avec l'abscisse donnée Variation du paramètre de variation
 */
	public void moveAeronefAbcsisse(float abscisseVariation) {
		float aeronefAbscisse = aeronef.getAbscissa();

		aeronefAbscisse += abscisseVariation;
		aeronef.setAbscissa(aeronefAbscisse);

	}
/*!
 * moveAeronefOrdonnee()
 * @param ordonneeVariation
 * 
 * @brief Déplace un Aeronef avec la variation du paramètre ordonneeVariation donnée
 */
	public void moveAeronefOrdonnee(float ordonneeVariation) {
		float aeronefOrdonnee = aeronef.getOrdinate();

		aeronefOrdonnee += ordonneeVariation;
		aeronef.setOrdinate(aeronefOrdonnee);

	}
	
/*!
 * emergencyLanding()
 * @param airport
 * 
 * @brief Jusqu'à ce qu'un Aeronef n'ait pas atteint la position d'un aéroport donné,
 * @brief que Aeronef bouge
 */
	public void emergencyLanding(Airport airport) {

		float abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, airport, 20);
		float ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, airport, 20);

		while (((int) aeronef.getAbscissa() != airport.getAbscissa())
				&& ((int) aeronef.getOrdinate() != airport.getOrdinate())) {

			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
		}
	}
	
	
	
	
/*!
 * exit()
 * @brief quitter
 */
	public synchronized void exit() {
		synchronized (departureManager) {
			departureManager.setFlyAeronef(0);
			departureManager.notify();
			}
	
	}
/*!
 * getAeronef()
 * @return aeronef
 */
	public Aeronef getAeronef() {
		return aeronef;
	}


/*!
 * setter setAeronef()
 * @param aeronef
 */

	public void setAeronef(Aeronef aeronef) {
		this.aeronef = aeronef;
	}


/*!
 * getter getAbscisseVariationValue()
 * @return abscisseVariationValue
 */

	public float getAbscisseVariationValue() {
		return abscisseVariationValue;
	}


/*!
 * setter setAbscisseVariationValue()
 * @param abscisseVariationValue
 */

	public void setAbscisseVariationValue(int abscisseVariationValue) {
		this.abscisseVariationValue = abscisseVariationValue;
	}


/*!
 * getter getOrdonneeVariationValue()
 * @return ordonneeVariationValue
 */

	public float getOrdoneeVariationValue() {
		return ordoneeVariationValue;
	}


/*!
 * setter setOrdoneeVariationValue()
 * @param ordoneeVariationValue
 */

	public void setOrdoneeVariationValue(int ordoneeVariationValue) {
		this.ordoneeVariationValue = ordoneeVariationValue;
	}

/*!
 * getter getDirection
 * @return direction
 * 
 * @brief Définit la direction selon si la variation utilisée pour déplacer un Aeronef est négative ou positive
 * @brief si c'est négatif, cela signifie que l'Aeronef se déplace d'est en ouest, sinon cela signifie qu'il se déplace
 * @brief d'ouest en est.
 */
	public String getDirection() {
		if(abscisseVariationValue<0) {
			direction = "Est-West";
		}
		if(abscisseVariationValue>=0) {
			direction = "West-Est";
		}
		return direction;
	  }

	public void avoidOtherAeronef(Aeronef obstacleAeronef) {
		float aeronefAbscisse = aeronef.getAbscissa();
		float aeronefOrdonnee = aeronef.getOrdinate();
		float obstacleAeronefsAbscisse = obstacleAeronef.getAbscissa();
		float obstacleAeronefsOrdonnee = obstacleAeronef.getOrdinate();
		int aeronefaltitude = aeronef.getAltitude();
		if(!aeronef.isDetectObstacle()) {
			if(direction.equals("West-Est")) {
				float dx = (aeronefAbscisse) - obstacleAeronefsAbscisse;
				float dy = (aeronefOrdonnee) - obstacleAeronefsOrdonnee;
				double distance = Math.sqrt(dx * dx + dy * dy);
				if (distance < 70) {
					aeronef.setDetectAeronef("Aeronef");
					aeronef.setAltitude(4500);
				}
			}
			else {
				obstacleAeronef.setDetectAeronef("No");
				aeronef.setAltitude(4100);
			}
		}
	}
	
	public void initAeronefAltitute(String type) {
		if (type.contains("Military")) {
			aeronef.setAltitude(11200);
		}
		else {
			aeronef.setAltitude(4100);
		}
	}
	
	/*!
	 * setter setDirection()	
	 * @param direction la direction de l'aeronef
	 * @brief changer la direction de l'aeronef
	 */

	public void setDirection(String direction) {
		this.direction = direction;
	}

	/*!
	 * getDepartureManager()
	 * @return departureManager le depart de l'aeronef
	 */
	
	public AirportManager getDepartureManager() {
		return departureManager;
	}

/*!
 * setDepartureManager()
 * @param departureManager le depart de l'aeronef
 * @brief changer la deparature de l'aeronef
 */
	public void setDepartureManager(AirportManager departureManager) {
		this.departureManager = departureManager;
	}

}
