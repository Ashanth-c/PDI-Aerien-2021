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
 * @brief Method of the Thread class that's been overridden, Moves an Aeronef,Deals with an Aeronef's emergency landing
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
 * @brief Increases an Aeronef's altitude if it's 0
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
 * @brief Decreases an Aeronef's altitude if it isn't 0
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
 * @brief Decreases an Aeronef's speed
 */

	public void slowDownSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed - 100);

	}
/*!
 * accelerateSpeed()
 * @param aeronef
 * 
 * @brief Increases an Aeronef's speed
 */

	public void accelerateSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed + 100);

	}
/*!
 * landingSpeed()
 * @param aeronef
 * 
 * @brief Decreases an Aeronef's speed if it isn't 0
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
 * @brief Increases an Aeronef's speed if it's 0
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
 * @brief Writes in the console if an Aeronef gets close to an airport
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
	 * @brief Makes an Aeronef move till it's reached its destination
	 * @brief Sets the running boolean depending on whether the Aeronef is allowed to land
	 */
	public void travelAeronef() {
		//Aeronef dodges obstacle
		ElementManager.avoidObstacle(this);
		
		//if Aeronef's position is yet to be its destination's, Aeronef moves
		if (( aeronef.getAbscissa() != destinationAirport.getAbscissa()) && ( aeronef.getOrdinate() != destinationAirport.getOrdinate())) {
			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
		}		
		/*if Aeronef's position is its destination
		 * we add the destination airport in an airportmanager 
		 * if the Aeronef has authorization to land, running is set false. if not, running is true.
		 * then we exit
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
 * @brief Moves an Aeronef with the given abscisseVaration parameter variation
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
 * @brief Moves an Aeronef with the given ordonneeVariation parameter variation
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
 * @brief Till an Aeronef has not reached a given airport's position,
 * @brief that Aeronef moves
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
 * @brief Sets direction depending if the variation used to move an Aeronef is negative or positive
 * @brief if it's negative it means the Aeronef moves from east to west, if not it means it moves
 * @brief west to east.
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
