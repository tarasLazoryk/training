package ua.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.training.control.Control;
import ua.training.model.Model;
import ua.training.model.entity.carriages.ComfortClass;
import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
import ua.training.model.entity.locomotive.MotorType;
import ua.training.model.entity.train.Train;
import ua.training.view.View;

public class Main {

	public static void main(String[] args) {
		// Initialization
		View view = new View();
		Model model = new Model();
		Control control = new Control(model, view);
		// run
		control.processUser();

	}

}
