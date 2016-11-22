package ua.training.model.entity.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.PassangerCarriagesComparator;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
/**
 * expresses train. stands as a model in mvs pattern.
 * 
 * @author taras
 *
 */
public class Train {
	
	/**
	 * number of train
	 */
	private Integer trainNumber;
	
	/**
	 * trains locomotive
	 */
	private Locomotive locomotive;
	
	/**
	 * Passanger and freight carriages
	 */
	private List<RailwayCarriage> railwayCarriages = new ArrayList<RailwayCarriage>();

	public Train(){
		
	}
	public Train(Integer trainNumber, Locomotive frontLocomotive, List<RailwayCarriage> railwayCarriages) {
		super();
		this.trainNumber = trainNumber;
		this.locomotive = frontLocomotive;
		this.railwayCarriages = railwayCarriages;
	}

	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Locomotive getFrontLocomotive() {
		return locomotive;
	}

	public void setFrontLocomotive(Locomotive frontLocomotive) {
		this.locomotive = frontLocomotive;
	}

	public List<RailwayCarriage> getRailwayCarriages() {
		return railwayCarriages;
	}

	public void setRailwayCarriages(List<RailwayCarriage> railwayCarriages) {
		this.railwayCarriages = railwayCarriages;
	}

	/**
	 * Sorts the PassengerCarriage in the train by comfort class.
	 * railwayCarriages consist of freight and passanger carriages, freight
	 * can't be sorted by comfort class. As a result of this method, first
	 * carriages will be passanger, and they will be sorted, after them all
	 * freight carriage will go.
	 * 
	 */
	public ArrayList<PassangerCarriage> sort(PassangerCarriagesComparator<PassangerCarriage> comparator) {
		ArrayList<PassangerCarriage> result = new ArrayList<>();
		// List<FreightCarriage> freightCarriages = getFreightCarriages();
		List<PassangerCarriage> passangerCarriages = getPassangerCarriages();
		passangerCarriages.sort(comparator);
		result.addAll(passangerCarriages);
		// result.addAll(freightCarriages);
		return result;
	}

	/**
	 * Gets summary amoun of passenger and freight places.
	 * 
	 * @return summary amount of places.
	 */
	public int getSummaryAmountOfPlaces() {
		return railwayCarriages.stream().mapToInt(RailwayCarriage::getAmountOfPlaces).sum();		
	}

	/**
	 * Gets obly freightCarriages from railwayCarraiages.
	 * 
	 * @return List of freightCarriage
	 */
	private List<FreightCarriage> getFreightCarriages() {
		List<FreightCarriage> freightCarriages = new ArrayList<FreightCarriage>();
		for (RailwayCarriage railwayCarriage : railwayCarriages) {
			if (railwayCarriage instanceof FreightCarriage) {
				freightCarriages.add((FreightCarriage) railwayCarriage);
			}
		}
		return freightCarriages;
	}

	/**
	 * Gets obly passangerCarriages from railwayCarraiages.
	 * 
	 * @return List of passangerCarriage
	 */
	public List<PassangerCarriage> getPassangerCarriages() {
		List<PassangerCarriage> passangerCarriages = new ArrayList<PassangerCarriage>();
		for (RailwayCarriage railwayCarriage : railwayCarriages) {
			if (railwayCarriage instanceof PassangerCarriage) {
				passangerCarriages.add((PassangerCarriage) railwayCarriage);
			}
		}
		return passangerCarriages;
	}

	/**
	 * /** Gets only passangerCarriages from railwayCarraiages, which are in
	 * bound.
	 * 
	 * @param minBound  min bound
	 * @param maxBound  max bound
	 * @return List of passangerCarriage in bounds
	 */
	public List<PassangerCarriage> getPassangerCarriagesInBounds(int minBound, int maxBound) {
		List<PassangerCarriage> passangerCarriages = getPassangerCarriages();
		return passangerCarriages.stream().filter((e)->((minBound<=e.getAmountOfPlaces()) && 
				(e.getAmountOfPlaces() <=maxBound))).collect(Collectors.toList());
	}

	@Override
	public String toString() {

		return "Train [trainNumber=" + trainNumber + ", Locomotive=" + locomotive 
				+ ", railwayCarriages="	+ railwayCarriages;
	}

}
