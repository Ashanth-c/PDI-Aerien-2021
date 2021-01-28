package data;

import java.util.ArrayList;
import java.util.Date;

public class Airport {
	private String name;
	private Aerodrome aerodrome;
	private Terminal terminal;
	private City city;
	private Date openingDate;
	private Date constructionDate;
	private ArrayList<Line> linesList;

	public Airport(String name, Aerodrome aerodrome, Terminal terminal, City city, Date openingDate,
			Date constructionDate, ArrayList<Line> linesList) {
		super();
		this.name = name;
		this.aerodrome = aerodrome;
		this.terminal = terminal;
		this.city = city;
		this.openingDate = openingDate;
		this.constructionDate = constructionDate;
		this.linesList = linesList;
	}

	public Airport(String name, Aerodrome aerodrome, Terminal terminal, City city, Date openingDate,
			Date constructionDate) {
		super();
		this.name = name;
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

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getConstructionDate() {
		return constructionDate;
	}

	public void setConstructionDate(Date constructionDate) {
		this.constructionDate = constructionDate;
	}

	public ArrayList<Line> getLinesList() {
		return linesList;
	}

	public void setLinesList(ArrayList<Line> linesList) {
		this.linesList = linesList;
	}
}
