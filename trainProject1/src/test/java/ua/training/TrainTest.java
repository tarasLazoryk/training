package ua.training;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ua.training.control.init.InitCarriages;
import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.PassangerCarriagesComparator;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
import ua.training.model.entity.locomotive.MotorType;
import ua.training.model.entity.train.Train;

/**
 * Unit test for simple App.
 */
public class TrainTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public void testGetSummaryAmount() {
		Locomotive locomotive = new Locomotive(MotorType.Electric, 5, 10.,10.);
		List<RailwayCarriage> railwayCarriages = new ArrayList<RailwayCarriage>();
		railwayCarriages = InitCarriages.getRailwayCarriagesList();
		Train train = new Train(5, locomotive, railwayCarriages);
		assertEquals(434, train.getSummaryAmountOfPlaces());

	}

	public void testGetPassangerCarriagesInBounds() {
		Locomotive locomotive = new Locomotive(MotorType.Electric, 5, 10.,10.);
		List<RailwayCarriage> railwayCarriages = new ArrayList<RailwayCarriage>();
		railwayCarriages = InitCarriages.getRailwayCarriagesList();
		Train train = new Train(5, locomotive, railwayCarriages);
		List<PassangerCarriage> passCarr = train.getPassangerCarriagesInBounds(0, 50);
		for (int i = 0; i < passCarr.size(); i++) {
			assertTrue((passCarr.get(i).getAmountOfPlaces() < 50) && (passCarr.get(i).getAmountOfPlaces() > 0));
		}
	}

	public void testSort() {
		Locomotive locomotive = new Locomotive(MotorType.Electric, 5, 10.,10.);
		List<PassangerCarriage> sortedRailwayCarriages = new ArrayList<>();
		sortedRailwayCarriages = InitCarriages.getSortedPassangerCarriagesList();
		List<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages = InitCarriages.getRailwayCarriagesList();
		List<PassangerCarriage> testSortedList = new ArrayList<>();
		Train train = new Train(5, locomotive, railwayCarriages);
		testSortedList = train.sort(new PassangerCarriagesComparator<PassangerCarriage>());
		for (int i = 0; i < sortedRailwayCarriages.size(); i++) {
			assertTrue(testSortedList.get(i).equals(sortedRailwayCarriages.get(i)));
		}

	}

}
