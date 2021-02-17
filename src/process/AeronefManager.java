package process;

import data.Aeronef;
import data.Airport;
import data.Block;
/**
 * Class for the managmenent of an Aeronef
 * @author Khadija
 *
 */
public class AeronefManager {
	private Aeronef aeronef;
	private BlockManager manager;

	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
		this.manager = new BlockManager(aeronef);
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
			System.out.println("l'aeronef se rapproche de l'aéroport:" + airport + "Et La distance entre eux est:"
					+ (java.lang.Math.sqrt(java.lang.Math.pow((airportAbscisse - aeronefAbscisse), 2)
							+ java.lang.Math.pow((airportOrdonnee - aeronefOrdonnee), 2))));

		}

	}

}
