package process;

import java.util.List;

import data.Airport;
import data.Line;

public class LineBuilder {
	private Line line;

	public void addLines(Airport airport1, Airport airport2) {
		line = new Line(airport1, airport2); //Ligne creer a partir des deux aeroport
		List<Line> newAirport1LinesList = airport1.getLinesList(); //List des ligne de l'aeroport 1
		List<Line> newAirport2LinesList = airport2.getLinesList(); //Liste des lignes de l'aeroport 2

		newAirport1LinesList.add(line); //Ajoute la nouvelle ligne dans la liste des lignes de l'aeroport 1
		newAirport2LinesList.add(line); //Ajoute la nouvelle ligne dans la liste des lignes de l'aeroport 2

		airport1.setLinesList(newAirport1LinesList); //change la liste de ligne par la nouvelle liste dans l'aeroport 1
		airport2.setLinesList(newAirport2LinesList); //change la liste ce ligne par la nouvelle liste dans l'aeroport 2 
	}

}
