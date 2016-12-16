package ua.training.textParser.control;

import java.util.Scanner;

/**
 * Adapter for Scanner
 * 
 * @author Taras Lazoryk
 *
 */
public class ScannerAdapter {
	Scanner scanner;

	public ScannerAdapter(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public String next(){
		return scanner.next();
	}
}
