package process;

import data.Aeronef;
import data.Airport;
import data.Position;
import gui.SimulPara;

/**
 * 
 * 
 * @author Khadija
 * 
 * Classe gérant les aeronefs.
 * Classe constituée des attributs suivants :
 * aeronef (Aeronef), abscisseVariationValue (float), ordoneeVariationValue (float),
 * destinationAirport (Airport), running (boolean), isInUrgence(String), direction (String),
 * departureManager (AirportManager)
 * 
 * Cette classe est une classe fille de la classe Thread.
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
/**
 * AeronefManager Constructor
 * @param aeronef
 */
	/*
	 * AeronefManager Constructor
	 * param:
	 * 		aeronef : Aeronef
	 */
	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
		this.destinationAirport = ElementManager.getAiportFromName(aeronef.getDestination());
		this.abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);
		this.ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);

	}
	
	/**
	 * run() method
	 * 
	 * Method of the Thread class that's been overridden
	 * Moves an Aeronef
	 * Deals with an Aeronef's emergency landing
	 * 
	 */

	@Override
	public void run() {
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
						
						
						System.out.println("Changement de Destination de l'aeronef "+ aeronef.getName()+", Aterrisage d'urgence à " + destinationAirport.getName());
					}
				}
			}
			
			//else moves an Aeronef normally
			travelAeronef();
		}
	}

/**
 * landingAltitute method 
 * @param aeronef
 * 
 * Increases an Aeronef's altitude if it's 0
 */
	/*
	 * landingAltitute method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void landingAltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude == 0) {
			aeronef.setAltitude(AeronefAltitude++);
			AeronefAltitude = aeronef.getAltitude();

		}

	}
/**
 * takeOffAtltitute method
 * @param aeronef
 * 
 * Decreases an Aeronef's altitude if it isn't 0
 */
	/*
	 * takeOffAtlitute method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void takeOffAtltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude != 0) {
			aeronef.setAltitude(AeronefAltitude--);
			AeronefAltitude = aeronef.getAltitude();

		}

	}
/**
 * slowDownSpeed method
 * @param aeronef
 * 
 * Decreases an Aeronef's speed
 */
	/*
	 * slowDownSpeed method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void slowDownSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed - 100);

	}
/**
 * accelerateSpeed method
 * @param aeronef
 * 
 * Increases an Aeronef's speed
 */
	/*
	 * accelerateSpeed method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void accelerateSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed + 100);

	}
/**
 * landingSpeed method
 * @param aeronef
 * 
 * Decreases an Aeronef's speed if it isn't 0
 */
	/*
	 * landingSpeed method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void landingSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed != 0) {
			slowDownSpeed(aeronef);
		}
	}
	
/**
 * takeOffSpeed method
 * @param aeronef
 * 
 * 
 * Increases an Aeronef's speed if it's 0
 */
	/*
	 * takeOffSpeed method
	 * param:
	 * 		aeronef : Aeronef
	 */
	public void takeOffSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed == 0) {
			accelerateSpeed(aeronef);
		}
	}
/**
 * approachAirport method
 * @param aeronef
 * @param airport
 * 
 * Writes in the console if an Aeronef gets close to an airport
 */
	/*
	 * approchAirport method
	 * param:
	 * 		aeronef : Aeronef
	 * 		airport : Airport		
	 * 	
	 */
	public void approchAirport(Aeronef aeronef, Airport airport) {
		float aeronefAbscisse = aeronef.getAbscisse();
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float airportAbscisse = airport.getAbscisse();
		float airportOrdonnee = airport.getOrdonnee();

		if (java.lang.Math.sqrt(java.lang.Math.pow((airportAbscisse - aeronefAbscisse), 2)
				+ java.lang.Math.pow((airportOrdonnee - aeronefOrdonnee), 2)) < 100) {
			System.out.println("l'aeronef se rapproche de l'aÃ©roport:" + airport + "Et La distance entre eux est:"
					+ (java.lang.Math.sqrt(java.lang.Math.pow((airportAbscisse - aeronefAbscisse), 2)
							+ java.lang.Math.pow((airportOrdonnee - aeronefOrdonnee), 2))));

		}

	}
/**
 * 	travelAeronef method
 * 
 * Makes an Aeronef move till it's reached its destination
 * Sets the running boolean depending on whether the Aeronef is allowed to land
 */
	public void travelAeronef() {
		//Aeronef dodges obstacle
		ElementManager.avoidObstacle(aeronef);
		
		//if Aeronef's position is yet to be its destination's, Aeronef moves
		if (( aeronef.getAbscisse() != destinationAirport.getAbscisse()) && ( aeronef.getOrdonnee() != destinationAirport.getOrdonnee())) {
			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
			System.out.println("Coordonnee de l'aeronef " + aeronef.getName() + " : " + aeronef.getAbscisse() + " , " + (int) aeronef.getOrdonnee());
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
			System.out.println("Atterisage de l'aeronef " + aeronef.getName() + " " + aeronef.getModel()+ " reussi");
		}
	}
/**
 * moveAeronefAbscisse method
 * @param abscisseVariation
 * 
 * Moves an Aeronef with the given abscisseVaration parameter variation
 */
	public void moveAeronefAbcsisse(float abscisseVariation) {
		float aeronefAbscisse = aeronef.getAbscisse();

		aeronefAbscisse += abscisseVariation;
		aeronef.setAbscisse(aeronefAbscisse);

	}
/**
 * moveAeronefOrdonnee
 * @param ordonneeVariation
 * 
 * Moves an Aeronef with the given ordonneeVariation parameter variation
 */
	public void moveAeronefOrdonnee(float ordonneeVariation) {
		float aeronefOrdonnee = aeronef.getOrdonnee();

		aeronefOrdonnee += ordonneeVariation;
		aeronef.setOrdonnee(aeronefOrdonnee);

	}
/**
 * emergencyLanding() method
 * @param airport
 * 
 * Till an Aeronef has not reached a given airport's position,
 * that Aeronef moves
 */
	public void emergencyLanding(Airport airport) {

		float abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, airport, 20);
		float ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, airport, 20);

		while (((int) aeronef.getAbscisse() != airport.getAbscisse())
				&& ((int) aeronef.getOrdonnee() != airport.getOrdonnee())) {

			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
			System.out.println(
					"Coordonnees de l'aeronef en urgence : " + aeronef.getAbscisse() + " , " + aeronef.getOrdonnee());
		}
	}
/**
 * 
 */
	public synchronized void exit() {
		synchronized (departureManager) {
			departureManager.setFlyAeronef(0);
			departureManager.notify();
			}
	
	}
/**
 * getter getAeronef
 * @return aeronef
 */
	/*
	 * getter getAeronef
	 * 
	 * returns aeronef, Aeronef
	 */
	public Aeronef getAeronef() {
		return aeronef;
	}


/**
 * setter setAeronef
 * @param aeronef
 */
	/*
	 * setter setAeronef
	 * param:
	 * 		aeronef: Aeronef
	 */
	public void setAeronef(Aeronef aeronef) {
		this.aeronef = aeronef;
	}


/**
 * getter getAbscisseVariationValue
 * @return abscisseVariationValue
 */
	/*
	 * getter getAbscisseVariationValue
	 * 
	 * return abscisseVariationValue, float
	 */
	public float getAbscisseVariationValue() {
		return abscisseVariationValue;
	}


/**
 * setter setAbscisseVariationValue
 * @param abscisseVariationValue
 */
	/*
	 * setter setAbscisseVariationValue
	 * param:
	 * 		abscisseVariationValue : int
	 */
	public void setAbscisseVariationValue(int abscisseVariationValue) {
		this.abscisseVariationValue = abscisseVariationValue;
	}


/**
 * getter getOrdonneeVariationValue
 * @return ordonneeVariationValue
 */
	/*
	 * getter getOrdonneeVariationValue
	 * 
	 * return ordonneeVariationValue
	 */
	public float getOrdoneeVariationValue() {
		return ordoneeVariationValue;
	}


/**
 * setter setOrdoneeVariationValue
 * @param ordoneeVariationValue
 */
	/*
	 * setter setOrdoneeVariationValue
	 * param:
	 * 		ordoneeVariationValue : int
	 */
	public void setOrdoneeVariationValue(int ordoneeVariationValue) {
		this.ordoneeVariationValue = ordoneeVariationValue;
	}

/**
 * getter getDirection
 * @return direction
 * 
 * Sets direction depending if the variation used to move an Aeronef is negative or positive
 * if it's negative it means the Aeronef moves from east to west, if not it means it moves
 * west to east.
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
/**
 * setter setDirection	
 * @param direction
 */
	/*
	 * setter setDirection
	 * param:
	 * 		direction : String
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

/**
 * getter getDepartureManager
 * @return departureManager
 */
	/*
	 * getter getDepartureManager
	 * returns departureManager, AirportManager
	 */
	public AirportManager getDepartureManager() {
		return departureManager;
	}

/**
 * setter setDepartureManager
 * @param departureManager
 * 
 */
	/*
	 * setter setDepartureManager
	 * param:
	 * 		departureManager : AirportManager
	 */
	public void setDepartureManager(AirportManager departureManager) {
		this.departureManager = departureManager;
	}

}