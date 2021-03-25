package process;

import java.util.List;

import data.Airport;
import data.Line;

/**
 * @author Ashanth
 * 
 * Classe qui crée une ligne entre deux aéroport
 * Classe définie par l'attribut suivant : line (Line)
 *
 */
public class LineBuilder {
	private Line line;
/**
 * addLines method
 * @param airport1
 * @param airport2
 * 
 * Crée une ligne entre deux aéoports
 */
	public void addLines(Airport airport1, Airport airport2) {
		line = new Line(airport1, airport2);
		List<Line> newAirport1LinesList = airport1.getLinesList();
		List<Line> newAirport2LinesList = airport2.getLinesList();

		//si deux aéroports sont de type militaires on créé une ligne entre eux
		if (airport1.getType().contains("Military") && airport2.getType().contains("Military")) {
			newAirport1LinesList.add(line);
			newAirport2LinesList.add(line);

			airport1.setLinesList(newAirport1LinesList);
			airport2.setLinesList(newAirport2LinesList);

		} 
		//on crée une ligne si les types de deux aéroports ne sont pas miliaires
		else if (!(airport1.getType().equals("Military") || airport2.getType().equals("Military"))) {

			newAirport1LinesList.add(line);
			newAirport2LinesList.add(line);

			airport1.setLinesList(newAirport1LinesList);
			airport2.setLinesList(newAirport2LinesList);
		}

	}
}