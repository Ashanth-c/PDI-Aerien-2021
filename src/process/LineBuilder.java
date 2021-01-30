package process;

import java.util.List;

import data.Airport;
import data.Line;

public class LineBuilder {
	private Line line;

	public void addLines(Airport airport1, Airport airport2) {
		line = new Line(airport1, airport2);
		List<Line> newAirport1LinesList = airport1.getLinesList();
		List<Line> newAirport2LinesList = airport2.getLinesList();

		newAirport1LinesList.add(line);
		newAirport2LinesList.add(line);

		airport1.setLinesList(newAirport1LinesList);
		airport2.setLinesList(newAirport2LinesList);
	}

}
