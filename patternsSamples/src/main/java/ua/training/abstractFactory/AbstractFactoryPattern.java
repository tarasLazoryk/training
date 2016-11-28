package ua.training.abstractFactory;

public class AbstractFactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeviceFactory devFactory = getFactoryByCountryCode("UKR");
		Mouse m = devFactory.getMouse();
		Keyboard k = devFactory.getKeyboard();
		Touchpad t = devFactory.getTouchpad();
		
		m.click();
		m.doubleClick();
		m.scroll(5);
		
		k.print();
		k.println();
		
		t.track(3, 4);
		devFactory = getFactoryByCountryCode("EN");
		m = devFactory.getMouse();
		k = devFactory.getKeyboard();
		t = devFactory.getTouchpad();
		
		m.click();
		m.doubleClick();
		m.scroll(5);
		
		k.print();
		k.println();
		
		t.track(3, 4);
		
		devFactory = getFactoryByCountryCode("EівіаN");
		
	}
	
	private static DeviceFactory getFactoryByCountryCode(String lang){
		switch(lang){
		case "UKR":
			return new UkrDeviceFactory();
		case "EN":
			return new EnDevicefactory();
	default:
		throw new RuntimeException("Unsupported Country Code: "+ lang);
		}
		
	}

}

interface Mouse {
	void click();

	void doubleClick();

	void scroll(int direction);
}

interface Keyboard {
	void print();

	void println();
}

interface Touchpad {
	void track(int deltaX, int deltaY);

}

interface DeviceFactory {
	Mouse getMouse();

	Keyboard getKeyboard();

	Touchpad getTouchpad();
}

class UkrMouse implements Mouse {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("ukr click");
	}

	@Override
	public void doubleClick() {
		// TODO Auto-generated method stub
		System.out.println("ukr double click");
	}

	@Override
	public void scroll(int direction) {
		// TODO Auto-generated method stub
		if (direction > 0) {
			System.out.println("ukr scroll up");
		} else if (direction < 0) {
			System.out.println("ukr scroll down");
		} else {
			System.out.println("ukr dont scroll");
		}
	}

}

class UkrKeyboard implements Keyboard {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("ukr print");
	}

	@Override
	public void println() {
		// TODO Auto-generated method stub
		System.out.println("ukr println");
	}

}

class UkrTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		System.out.println("ukr move " + s + "pixels");
	}

}

class EnMouse implements Mouse {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("en click");
	}

	@Override
	public void doubleClick() {
		// TODO Auto-generated method stub
		System.out.println("en double click");
	}

	@Override
	public void scroll(int direction) {
		// TODO Auto-generated method stub
		if (direction > 0) {
			System.out.println("en scroll up");
		} else if (direction < 0) {
			System.out.println("en scroll down");
		} else {
			System.out.println("en dont scroll");
		}
	}

}

class EnKeyboard implements Keyboard {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("en print");
	}

	@Override
	public void println() {
		// TODO Auto-generated method stub
		System.out.println("en println");
	}

}

class EnTouchpad implements Touchpad {

	@Override
	public void track(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		System.out.println("en move " + s + "pixels");
	}

}

class EnDevicefactory implements DeviceFactory{

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new EnMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new EnKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		// TODO Auto-generated method stub
		return new EnTouchpad();
	}
	
}

class UkrDeviceFactory implements DeviceFactory{

	@Override
	public Mouse getMouse() {
		// TODO Auto-generated method stub
		return new UkrMouse();
	}

	@Override
	public Keyboard getKeyboard() {
		// TODO Auto-generated method stub
		return new UkrKeyboard();
	}

	@Override
	public Touchpad getTouchpad() {
		// TODO Auto-generated method stub
		return new UkrTouchpad();
	}
	
}