package ua.training;

import ua.training.control.Control;
import ua.training.model.entity.train.Train;
import ua.training.view.View;

public class Main {

	public static void main(String[] args) {
		// Initialization
		View view = new View();
		Train model = new Train();
		Control control = new Control(model, view);
		// run
		control.processUser();
	}
}
