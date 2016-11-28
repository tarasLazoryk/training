package ua.training.flyWeight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FlyWeightPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory shapeFactory = new ShapeFactory();
		ArrayList<Shape> shapes = new ArrayList<>();

		shapes.add(shapeFactory.getShape("square"));
		shapes.add(shapeFactory.getShape("circle"));
		shapes.add(shapeFactory.getShape("circle"));
		shapes.add(shapeFactory.getShape("point"));
		shapes.add(shapeFactory.getShape("square"));
		shapes.add(shapeFactory.getShape("circle"));
		shapes.add(shapeFactory.getShape("point"));
		shapes.add(shapeFactory.getShape("point"));
		
		Random rand = new Random();
		for(Shape shape:shapes){
			int x = rand.nextInt(100);
			int y = rand.nextInt(100);
			shape.draw(x, y);
		}
		
	}

}

class ShapeFactory {
	private static final Map<String, Shape> shapes = new HashMap<>();

	public Shape getShape(String shapeName) {
		Shape shape = shapes.get(shapeName);
		if (shape == null) {
			switch (shapeName) {
			case "circle":
				shape = new Circle();
				break;
			case "square":
				shape = new Square();
				break;
			case "point":
				shape = new Point();
				break;
			}
			shapes.put(shapeName, shape);
		}
		return shape;
	}

}

interface Shape {
	void draw(int x, int y);
}

class Point implements Shape {

	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw point in x=" + x + " , y=" + y);
	}

}

class Circle implements Shape {
	int r = 5;

	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw circle in x=" + x + " , y=" + y + " with radius = " + r);
	}

}

class Square implements Shape {
	int a = 10;

	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw square in x=" + x + " , y=" + y + " with side = " + a);
	}

}
