package ua.training.control.init;

import ua.training.model.entity.carriages.PassangerCarriage;

import java.util.ArrayList;

import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.MotorType;

/**
 * Enum for initialization carriages
 * 
 * @author taras
 *
 */
public enum InitCarriages {
	FirstClassCarriage(new PassangerCarriage(6, 10.,"FirstClass")),
	SecondClassCarriage(new PassangerCarriage(6, 10.,"SecondClass")),
	ThirdClassCarriage(new PassangerCarriage(6, 10.,"ThirdClass")),
	FreightCarriage(new FreightCarriage(6, 10.,100));
	
	private RailwayCarriage railwayCarriage;
	
	InitCarriages(RailwayCarriage railwayCarriage){
		this.railwayCarriage = railwayCarriage;
	}

	public RailwayCarriage getRailwayCarriage() {
		return railwayCarriage;
	}
	
	/**
	 * This method returns list of railway carriages
	 *  
	 * @return ArrayList of RailwayCarriage.
	 */
	public static ArrayList<RailwayCarriage> getRailwayCarriagesList(){
		ArrayList<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add(InitCarriages.FirstClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.SecondClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.FirstClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.ThirdClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.FreightCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.FreightCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.ThirdClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.SecondClassCarriage.getRailwayCarriage());
		railwayCarriages.add(InitCarriages.FirstClassCarriage.getRailwayCarriage());
		return railwayCarriages;
	}
	
	/**
	 * This method returns sorted list of passanger carriages
	 *  
	 * @return ArrayList of sorted PassngerCarriage.
	 */
	public static ArrayList<PassangerCarriage> getSortedPassangerCarriagesList(){
		ArrayList<PassangerCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add((PassangerCarriage)InitCarriages.FirstClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.FirstClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.FirstClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.SecondClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.SecondClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.ThirdClassCarriage.getRailwayCarriage());
		railwayCarriages.add((PassangerCarriage)InitCarriages.ThirdClassCarriage.getRailwayCarriage());			
		return railwayCarriages;
	}
	
}
