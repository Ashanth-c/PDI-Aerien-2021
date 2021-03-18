package data;

public class City {
	private String name;
	private String country;

	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public City() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return name +", "+ country;
	}
}
