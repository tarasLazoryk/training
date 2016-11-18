package ua.training;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
import ua.training.model.entity.locomotive.MotorType;
import ua.training.model.entity.train.Train;

public class TrainTest extends TestCase {

	public void checkGetSummaryAmount() {
		Locomotive locomotive = new Locomotive(MotorType.Electric);
		List<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new FreightCarriage(200));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new FreightCarriage(100));
		/* Inizialization of train instance */
		Train train = new Train(5, locomotive, railwayCarriages);

		assertEquals(516, train.getSummaryAmountOfPlaces());

	}

	public void checkGetPassangerCarriagesInBounds() {
		Locomotive locomotive = new Locomotive(MotorType.Electric);
		List<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new FreightCarriage(200));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new FreightCarriage(100));
		/* Inizialization of train instance */
		Train train = new Train(5, locomotive, railwayCarriages);
		List<PassangerCarriage> passCarr = train.getPassangerCarriagesInBounds(0, 50);
		for (int i = 0; i < passCarr.size(); i++) {
			assertTrue((passCarr.get(i).getAmountOfPlaces() < 50) && (passCarr.get(i).getAmountOfPlaces() > 0));
		}
	}
	
	public void checkSort() {
		Locomotive locomotive = new Locomotive(MotorType.Electric);
		List<RailwayCarriage> sortedRailwayCarriages = new ArrayList<>();
		sortedRailwayCarriages.add(new PassangerCarriage("FirstClass"));
		sortedRailwayCarriages.add(new PassangerCarriage("FirstClass"));
		sortedRailwayCarriages.add(new PassangerCarriage("SecondClass"));
		sortedRailwayCarriages.add(new PassangerCarriage("SecondClass"));
		sortedRailwayCarriages.add(new PassangerCarriage("ThirdClass"));
		sortedRailwayCarriages.add(new PassangerCarriage("ThirdClass"));
		sortedRailwayCarriages.add(new FreightCarriage(200));		
		sortedRailwayCarriages.add(new FreightCarriage(100));
		List<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new FreightCarriage(200));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new FreightCarriage(100));
		/* Inizialization of train instance */
		Train train = new Train(5, locomotive, railwayCarriages);
		train.sort();
		Assert.assertArrayEquals(train.getRailwayCarriages().toArray(),
                sortedRailwayCarriages.toArray());
	}

}
