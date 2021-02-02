package process;

import data.Aeronef;

public class AeronefManager {
	private Aeronef aeronef;

	public AeronefManager(Aeronef aeronef) {
		super();
		this.aeronef = aeronef;
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

}
