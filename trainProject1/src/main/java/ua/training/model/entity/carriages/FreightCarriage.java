package ua.training.model.entity.carriages;

/**
 * FreightCarriage represent freight carriage
 * 
 * @author taras
 *
 */
public class FreightCarriage implements RailwayCarriage {
	
	/**
	 * Amount of places for cargo
	 */
	private int amountOfPlaces;
	
	
	public FreightCarriage(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}
	
	public void setAmountOfPlaces(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}
	
	@Override
	public String toString() {
		return "FreightCarriage [amountOfPlaces=" + amountOfPlaces + "]";
	}

	public int getAmountOfPlaces() {
		// TODO Auto-generated method stub
		return amountOfPlaces;
	}

}
