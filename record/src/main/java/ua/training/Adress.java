package ua.training;
	/**
	 * This class expresses physical adress; 
	 * @author taras
	 *
	 */
public class Adress {
	private String Index;
	private String City;
	private String Street;
	private int HouseNumber;
	private int AppatamentNumber;

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
	public Adress(String Index, String City, String Street, String HouseNumber,
				String AppartamentNumber) {
		this.Index = Index;
		this.City = City;
		this.Street = Street;
		this.HouseNumber = Integer.parseInt(HouseNumber);
		this.AppatamentNumber = Integer.parseInt(AppartamentNumber);
	}

	@Override
	public String toString() {
		return "Index=" + Index + ", City=" + City + ", Street=" + Street 
				+ ", HouseNumber=" + HouseNumber + ", AppatamentNumber=" 
				+ AppatamentNumber + "";
	}

}
