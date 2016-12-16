package ua.training.TextParser.control;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ua.training.textParser.control.ScannerAdapter;
import ua.training.textParser.control.TextParserControl;
import ua.training.textParser.model.Model;
import ua.training.textParser.model.TextParserModel;
import ua.training.textParser.view.TextParserView;
import ua.training.textParser.view.View;


public class TestTextParserControl {
	@Test
	public void testCheckStringForInt() {		
		Model m = new TextParserModel();
		View v = new TextParserView();
		String five = "5";
		TextParserControl c = new TextParserControl(m,v);	
		assertTrue(c.checkStringForInt(five));		
	}
	
	@Test
	public void testInputAmountOfCharacters() {		
		Model m = new TextParserModel();
		View v = new TextParserView();
		TextParserControl c = new TextParserControl(m,v);	
		ScannerAdapter sc = mock(ScannerAdapter.class);
		when(sc.next()).thenReturn("10");
		int a = c.inputAmountOfCharacters(sc);
		assertEquals(10,a);	
	}
}


