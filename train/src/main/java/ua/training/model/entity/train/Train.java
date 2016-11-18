package ua.training.model.entity.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;

public class Train {
	private Integer trainNumber;
	private Locomotive frontLocomotive;
	private List<RailwayCarriage> railwayCarriages = new ArrayList<>();
	
	public Train(Integer trainNumber, Locomotive frontLocomotive,
			List<RailwayCarriage> railwayCarriages) {
		super();
		this.trainNumber = trainNumber;
		this.frontLocomotive = frontLocomotive;
		this.railwayCarriages = railwayCarriages;
	}
	
	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Locomotive getFrontLocomotive() {
		return frontLocomotive;
	}

	public void setFrontLocomotive(Locomotive frontLocomotive) {
		this.frontLocomotive = frontLocomotive;
	}

	public List<RailwayCarriage> getRailwayCarriages() {
		return railwayCarriages;
	}

	public void setRailwayCarriages(List<RailwayCarriage> railwayCarriages) {
		this.railwayCarriages = railwayCarriages;
	}

	public void sort() {
		List<FreightCarriage> freightCarriages = getFreightCarriages();
		List<PassangerCarriage> passangerCarriages = getPassangerCarriages();
		railwayCarriages.clear();
		Collections.sort(passangerCarriages);
		railwayCarriages.addAll(passangerCarriages);
		railwayCarriages.addAll(freightCarriages);
	}
	
	public int getSummaryAmountOfPlaces(){
		int summaryAmountOfPlaces = 0;
		for (RailwayCarriage railwayCarriage : railwayCarriages) {
			summaryAmountOfPlaces += railwayCarriage.getAmountOfPlaces();
		}
		return summaryAmountOfPlaces;
	}
	
	private List<FreightCarriage> getFreightCarriages(){
		List<FreightCarriage> freightCarriages = new ArrayList<>();
		for (RailwayCarriage railwayCarriage : railwayCarriages) {
			if (railwayCarriage instanceof FreightCarriage) {
				freightCarriages.add((FreightCarriage) railwayCarriage);
			}
		}
		return freightCarriages;
	}
	
	private List<PassangerCarriage> getPassangerCarriages(){
		List<PassangerCarriage> passangerCarriages = new ArrayList<>();
		for (RailwayCarriage railwayCarriage : railwayCarriages) {
			if (railwayCarriage instanceof PassangerCarriage) {
				passangerCarriages.add((PassangerCarriage) railwayCarriage);
			}
		}
		return passangerCarriages;
	}
	
	public List<PassangerCarriage> getPassangerCarriagesInBounds(int minBound, int maxBound) {
		List<PassangerCarriage> passangerCarriages = getPassangerCarriages();
		List<PassangerCarriage> passangerCarriagesInBounds = new ArrayList<>();
		for (PassangerCarriage passangerCarriage : passangerCarriages) {
			if ((passangerCarriage.getAmountOfPlaces() > minBound)
					&& (passangerCarriage.getAmountOfPlaces() < maxBound)) {
				passangerCarriagesInBounds.add(passangerCarriage);
			}			
			
		}
		return passangerCarriagesInBounds;
	}

	@Override
	public String toString() {

		return "Train [trainNumber=" + trainNumber + ", frontLocomotive=" + frontLocomotive + ", railwayCarriages=" + railwayCarriages;
	}

}
