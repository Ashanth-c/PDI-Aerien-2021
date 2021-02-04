package process;

import data.Aeronef;
import data.Airport;
import data.Block;

public class AeronefManager {
	private Aeronef aeronef;
	private BlockManager manager;

	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
		this.manager =  new BlockManager(aeronef);
	}

	public void landingAltitute() {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude != 0) {
			aeronef.setAltitude(AeronefAltitude--);
			AeronefAltitude = aeronef.getAltitude();

		}

	}

	public void takeOffAtltitute() {
		int aeronefAltitude = aeronef.getAltitude();

	}

	public void landingSpeed() {

	}

	public void takeOffSpeed() {

	}

	public void slowDownSpeed() {

	}

	public void accelerateSpeed() {

	}

	public void approchAirport(Airport airport) {
		int aeronefEndPoint = aeronef.getEndPoint();
		int aeronefStartPoint = aeronef.getStartPoint();

		if (true) {

		}

	}

}
