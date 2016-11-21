package ua.training.model.entity.carriages;

/**
 * FreightCarriage represent freight carriage
 * 
 * @author taras
 *
 */
public class FreightCarriage extends RailwayCarriage {
	
	/**
	 * Amount of places for cargo
	 */
	private int amountOfPlaces;
		
	public FreightCarriage(int amountOfWheelPairs, double weight, int amountOfPlaces) {
		super(amountOfWheelPairs, weight);
		this.amountOfPlaces = amountOfPlaces;
	}
	
	public void setAmountOfPlaces(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}
	
	

	

	@Override
	public String toString() {
		return "FreightCarriage [amountOfPlaces=" + amountOfPlaces 
				+ ", amountOfWheelPairs=" + getAmountOfWheelPairs() 
				+ ", weight=" + getWeight() + "]";
	}

	public int getAmountOfPlaces() {
		// TODO Auto-generated method stub
		return amountOfPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountOfPlaces;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreightCarriage other = (FreightCarriage) obj;
		if (amountOfPlaces != other.amountOfPlaces)
			return false;
		return true;
	}	
	
}
