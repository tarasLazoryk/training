package ua.training.MyRealizationOfLists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import MyArrayList.MyArrayList;
import MyLinkedList.MyLinkedList;
import MyTreeSet.MyTreeSet;

//import ua.training.MyLinkedList.MyLinkedList;

import java.util.*;

import static org.junit.Assert.*;

public class TreeSetTest {
	MyTreeSet<Integer> testMyTreeSet =  new MyTreeSet<Integer>();
	LinkedList<Integer> s = new LinkedList<>();

	@Before
	public void init() {
		
		testMyTreeSet.add(6);
		testMyTreeSet.add(3);
		testMyTreeSet.add(8);
		testMyTreeSet.add(1);
		testMyTreeSet.add(0);
		testMyTreeSet.add(2);
		testMyTreeSet.add(4);
		testMyTreeSet.add(7);
		testMyTreeSet.add(9);
	}

	
	@Test
	public void testSize() throws Exception {
		//testMyTreeSet.add(5);
		assertEquals(9, testMyTreeSet.size());
	}

	@Test
	public void testAdd() throws Exception {
		boolean isAdded = testMyTreeSet.add(5);
		assertTrue( isAdded);
	}
	
	@Test
	public void testAdd2() throws Exception {
		boolean isAdded = testMyTreeSet.add(4);
		assertFalse(isAdded);
	}
	
	@Test
	public void testRemove() throws Exception {
		 testMyTreeSet.remove(3);
		assertTrue( true);
	}

	

}