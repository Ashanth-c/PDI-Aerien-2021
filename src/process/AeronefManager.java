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

		while (AeronefAltitude == 0) {
			aeronef.setAltitude(AeronefAltitude++);
			AeronefAltitude = aeronef.getAltitude();

		}

	}

	public void takeOffAtltitute() {
		int AeronefAltitude = aeronef.getAltitude();

		while (AeronefAltitude != 0) {
			aeronef.setAltitude(AeronefAltitude--);
			AeronefAltitude = aeronef.getAltitude();

		}

	}
	
	public void slowDownSpeed() {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed-100) ;

	}
	
		public void accelerateSpeed() {
		int AeronefSpeed = aeronef.getSpeed();
		aeronef.setSpeed(AeronefSpeed+100) ;

	}


	public void landingSpeed() {
		int AeronefSpeed = aeronef.getSpeed();
		while(AeronefSpeed ==0){
			accelerateSpeed();
		}

	}

	public void takeOffSpeed() {
		int AeronefSpeed = aeronef.getSpeed();
		while(AeronefSpeed !=0){
			slowDownSpeed();
		}
	}


	
	public void approchAirport(Airport airport) {
		int aeronefCurrentPoint = aeronef.getCurrentPoint();
		int aeroportEndPoint =aeroport.getEndPoint();

		if (aeronefCurrentPoint-aeroportEndPoint<100) {
			System.out.println("l'aeronef se rapproche de l'aéroport:"+airport+"Et La distance entre eux est:"+(aeronefCurrentPoint-aeroportEndPoint));

		}

	}

}
