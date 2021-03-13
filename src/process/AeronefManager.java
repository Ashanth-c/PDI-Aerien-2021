package process;

import data.Aeronef;
import data.Airport;
import data.Position;
import gui.SimulPara;

/**
 * Class for the managmenent of an Aeronef
 * 
 * @author Khadija
 */
public class AeronefManager extends Thread {
	private Aeronef aeronef;
	private float abscisseVariationValue;
	private float ordoneeVariationValue;
	private Airport destinationAirport;
	private boolean running = true;
	private String isInUrgence="SearchEmergencyAirport";

	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
		this.destinationAirport = ElementManager.getAiportFromName(aeronef.getDestination());
		this.abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);
		this.ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);

	}
	
	
	@Override
	public void run() {
		while(running) {
			Utility.unitTime();
			if (aeronef.getUrgent()) {
				
				if(isInUrgence.equals("SearchEmergencyAirport")) {
					isInUrgence=ElementManager.checkAirportsAround(aeronef);
					
					if(!isInUrgence.equals("SearchEmergencyAirport")) {					
						destinationAirport = ElementManager.getAiportFromName(isInUrgence);	
						aeronef.setDestination(destinationAirport.getName());
						aeronef.setType("Emergency");
						abscisseVariationValue = ElementManager.abscisseVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED);
						ordoneeVariationValue = ElementManager.ordoneeVariationValue(aeronef, destinationAirport, SimulPara.SIMULATION_SPEED); 
						System.out.println("Changement de Destination, Aterrisage d'urgence à " + destinationAirport.getName());
					}
				}
			}
			travelAeronef();
		}
		System.out.println("Atterisage de l'aeronef " + aeronef.getModel()+ " reussi");
	}

	public void landingAltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude == 0) {
			aeronef.setAltitude(AeronefAltitude++);
			AeronefAltitude = aeronef.getAltitude();

		}

	}

	public void takeOffAtltitute(Aeronef aeronef) {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude != 0) {
			aeronef.setAltitude(AeronefAltitude--);
			AeronefAltitude = aeronef.getAltitude();

		}

	}

	public void slowDownSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed - 100);

	}

	public void accelerateSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed + 100);

	}

	public void landingSpeed(Aeronef aeronef) {
		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed == 0) {
			accelerateSpeed(aeronef);
		}

	}

	public void takeOffSpeed(Aeronef aeronef) {

		int AeronefSpeed = aeronef.getSpeed();
		while (AeronefSpeed != 0) {
			slowDownSpeed(aeronef);
		}
	}

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
	
	public void travelAeronef() {
		ElementManager.avoidObstacle(aeronef);
		if (((int) aeronef.getAbscisse() != destinationAirport.getAbscisse()) && ((int) aeronef.getOrdonnee() != destinationAirport.getOrdonnee())) {
			moveAeronefAbcsisse(abscisseVariationValue);
			moveAeronefOrdonnee(ordoneeVariationValue);
			System.out.println("Coordonnee de l'aeronef : " + aeronef.getAbscisse() + " , " + (int) aeronef.getOrdonnee());
		}		
		else {
			AirportManager airportManager = new AirportManager(destinationAirport);
			running = (!airportManager.airportLandingAuthorization(aeronef));
		}
	}

	public void moveAeronefAbcsisse(float abscisseVariation) {
		float aeronefAbscisse = aeronef.getAbscisse();

		aeronefAbscisse += abscisseVariation;
		aeronef.setAbscisse(aeronefAbscisse);

	}

	public void moveAeronefOrdonnee(float ordonneeVariation) {
		float aeronefOrdonnee = aeronef.getOrdonnee();

		aeronefOrdonnee += ordonneeVariation;
		aeronef.setOrdonnee(aeronefOrdonnee);

	}

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



	public Aeronef getAeronef() {
		return aeronef;
	}



	public void setAeronef(Aeronef aeronef) {
		this.aeronef = aeronef;
	}



	public float getAbscisseVariationValue() {
		return abscisseVariationValue;
	}



	public void setAbscisseVariationValue(int abscisseVariationValue) {
		this.abscisseVariationValue = abscisseVariationValue;
	}



	public float getOrdoneeVariationValue() {
		return ordoneeVariationValue;
	}



	public void setOrdoneeVariationValue(int ordoneeVariationValue) {
		this.ordoneeVariationValue = ordoneeVariationValue;
	}

}