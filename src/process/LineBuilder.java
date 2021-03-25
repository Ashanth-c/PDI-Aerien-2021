package process;

import java.util.List;

import data.Airport;
import data.Line;

/**
 * @author Ashanth
 * 
 * Classe qui cr�e une ligne entre deux a�roport
 * Classe d�finie par l'attribut suivant : line (Line)
 *
 */
public class LineBuilder {
	private Line line;
/**
 * addLines method
 * @param airport1
 * @param airport2
 * 
 * Cr�e une ligne entre deux a�oports
 */
	public void addLines(Airport airport1, Airport airport2) {
		line = new Line(airport1, airport2);
		List<Line> newAirport1LinesList = airport1.getLinesList();
		List<Line> newAirport2LinesList = airport2.getLinesList();

		//si deux a�roports sont de type militaires on cr�� une ligne entre eux
		if (airport1.getType().contains("Military") && airport2.getType().contains("Military")) {
			newAirport1LinesList.add(line);
			newAirport2LinesList.add(line);

			airport1.setLinesList(newAirport1LinesList);
			airport2.setLinesList(newAirport2LinesList);

		} 
		//on cr�e une ligne si les types de deux a�roports ne sont pas miliaires
		else if (!(airport1.getType().equals("Military") || airport2.getType().equals("Military"))) {

			newAirport1LinesList.add(line);
			newAirport2LinesList.add(line);

			airport1.setLinesList(newAirport1LinesList);
			airport2.setLinesList(newAirport2LinesList);
		}

	}
}