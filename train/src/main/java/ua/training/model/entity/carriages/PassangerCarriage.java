package ua.training.model.entity.carriages;

public class PassangerCarriage implements RailwayCarriage, Comparable {
	
	private int amountOfPlaces;
	private ComfortClass comfortType;
	
	public PassangerCarriage(String comfortType) {
		this.amountOfPlaces = ComfortClass.valueOf(comfortType).getAmountOfPlaces();
		this.comfortType = ComfortClass.valueOf(comfortType);
	}

	public int getAmountOfPlaces() {
		return amountOfPlaces;
	}
	
	public ComfortClass getComfortType() {
		return comfortType;
	}

	public void setComfortType(ComfortClass comfortType) {
		this.comfortType = comfortType;
	}

	public void setComfortType(String comfortType) {
		this.comfortType = ComfortClass.valueOf(comfortType);
	}

	@Override
	public String toString() {
		return "PassangerCarriage [amountOfPlaces=" + amountOfPlaces + ", comfortType=" + comfortType + "]";
	}

	@Override
	public int compareTo(Object obj) {
		PassangerCarriage entry = (PassangerCarriage) obj;
		int result = comfortType.compareTo(entry.getComfortType());
		if (result != 0) {
			return result;
		}
		return 0;
	}

}
