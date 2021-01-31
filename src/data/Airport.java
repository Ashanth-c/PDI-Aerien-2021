package data;

import java.util.List;

public class Airport {
	private String name;
	private String type;
	private Aerodrome aerodrome;
	private Terminal terminal;
	private City city;
	private String openingDate;
	private String constructionDate;
	private List<Line> linesList;

	public Airport(String name, String type, Aerodrome aerodrome, Terminal terminal, City city, String openingDate,
			String constructionDate, List<Line> linesList) {
		super();
		this.name = name;
		this.type = type;
		this.aerodrome = aerodrome;
		this.terminal = terminal;
		this.city = city;
		this.openingDate = openingDate;
		this.constructionDate = constructionDate;
		this.linesList = linesList;
	}

	public Airport(String name, String type, Aerodrome aerodrome, Terminal terminal, City city, String openingDate,
			String constructionDate) {
		super();
		this.name = name;
		this.type = type;
		this.aerodrome = aerodrome;
		this.terminal = terminal;
		this.city = city;
		this.openingDate = openingDate;
		this.constructionDate = constructionDate;
	}

	public Airport() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aerodrome getAerodrome() {
		return aerodrome;
	}

	public void setAerodrome(Aerodrome aerodrome) {
		this.aerodrome = aerodrome;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getopeningDate() {
		return openingDate;
	}

	public void setopeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getconstructionDate() {
		return constructionDate;
	}

	public void setconstructionDate(String constructionDate) {
		this.constructionDate = constructionDate;
	}

	public List<Line> getLinesList() {
		return linesList;
	}

	public void setLinesList(List<Line> linesList) {
		this.linesList = linesList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Airport [name=" + name + ", type=" + type + ", aerodrome=" + aerodrome + ", terminal=" + terminal
				+ ", city=" + city + ", openingDate=" + openingDate + ", constructionDate=" + constructionDate
				+ ", linesList=" + linesList + "]";
	}

}
