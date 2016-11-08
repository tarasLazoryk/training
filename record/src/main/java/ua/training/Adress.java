package ua.training;
	/**
	 * This class expresses physical adress; 
	 * @author taras
	 *
	 */
public class Adress {
	private String index;
	private String city;
	private String street;
	private int houseNumber;
	private int appatamentNumber;

	public Adress() {
	}
	
	/**
	 * Constructor with parameters. All input parameters are String. 
	 * HouseNumber and AppartamentNumber will be converted into int.
	 * 
	 * @param Index expresses index.
	 * @param City expresses name of the city.
	 * @param Street expresses name of the street.
	 * @param HouseNumber expresses number of the house.
	 * @param AppartamentNumber expresses number of the appartament.
	 */
	public Adress(String index, String city, String street, String houseNumber,
				String appartamentNumber) {
		this.index = index;
		this.city = city;
		this.street = street;
		this.houseNumber = Integer.parseInt(houseNumber);
		this.appatamentNumber = Integer.parseInt(appartamentNumber);
	}

	@Override
	public String toString() {
		return "Index=" + index + ", City=" + city + ", Street=" + street 
				+ ", HouseNumber=" + houseNumber + ", AppatamentNumber=" 
				+ appatamentNumber + "";
	}

}
