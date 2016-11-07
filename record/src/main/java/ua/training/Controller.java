package ua.training;

import java.util.Scanner;

/**
 * Controller class. It expresses controller in MVC pattern.
 * 
 * @author Taras Lazoryk
 *
 */
public class Controller {
	Model model = new Model();
	View view = new View();	

	// constructor
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

	}
	/**
	 * The main method, which creates recordController, creates record and 
	 * prints it
	 */
	public void processUser(){
		RecordController recordController = new RecordController(view);
        model.addRecord(recordController.inputDataWithScanner());
        for (int i = 0; i < model.getRecordsList().size(); i++) {
            view.print(model.getRecordsList().get(i).toString());
        }
	}

}
