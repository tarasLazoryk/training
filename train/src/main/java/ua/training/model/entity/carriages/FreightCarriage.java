package ua.training.model.entity.carriages;

public class FreightCarriage implements RailwayCarriage {

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

	@Override
	public int getAmountOfPlaces() {
		// TODO Auto-generated method stub
		return amountOfPlaces;
	}

}
