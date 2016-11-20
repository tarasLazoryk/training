package ua.training.MyArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by oleksij.onysymchuk@gmail on 19.11.2016.
 */
public class MyArrayListTest {
	private List<Integer> testMyArrayList = new MyArrayList<>(3);

	@Before
	public void init() {
		testMyArrayList.add(5);
		testMyArrayList.add(3);
		testMyArrayList.add(null);
		testMyArrayList.add(4);
	}

	@Test
	public void testMyArrayListCreation() {
		List<String> newList = new MyArrayList<>();
		Assert.assertNotNull(newList);
	}

	@Test
	public void testSize() throws Exception {
		assertEquals(4, testMyArrayList.size());
	}

	@Test
	public void testAdd() throws Exception {
		testMyArrayList.add(100500);
		assertEquals(5, testMyArrayList.size());
	}

	@Test
	public void testGet() throws Exception {
		assertEquals(new Integer(5), testMyArrayList.get(0));
	}

	@Test
	public void testSet() throws Exception {
		testMyArrayList.set(1, 2);
		assertEquals(new Integer(2), testMyArrayList.get(1));
	}

	@Test
	public void testAddToPosition() throws Exception {
		List<Integer> testList = new ArrayList<>(Arrays.asList(5, 3, null, 4));
		testList.add(1, 2);
		testMyArrayList.add(1, 2);
		assertEquals(testList, testMyArrayList);
	}

	@Test
	public void testRemoveByIndex() throws Exception {
		List<Integer> testList = new ArrayList<>(Arrays.asList(5, 3, null, 4));
		testList.remove(3);
		testMyArrayList.remove(3);
		assertEquals(testList, testMyArrayList);
	}

	@Test
	public void testListIterator() throws Exception {
		ListIterator<Integer> iterator = testMyArrayList.listIterator();
		assertTrue("hasNext()", iterator.hasNext());
		assertFalse("hasPrevious", iterator.hasPrevious());

	}

	@Test(expected = NoSuchElementException.class)
	public void testListIteratorException() throws Exception {
		ListIterator<Integer> iterator = testMyArrayList.listIterator();

		iterator.next();
		iterator.previous();
		iterator.previous();

	}

}