package ua.training.templateMethod;

public class TemplateMethodPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C a= new A();
		C b = new B();
		a.templateMethod();
		System.out.println("");
		b.templateMethod();
	}

}

abstract class C {
	void templateMethod() {

		System.out.print("1");
		differ();
		System.out.print("3");
		diiffer2();
	}

	abstract void differ();
	abstract void diiffer2();
}

class A extends C {
	void differ() {
		System.out.print("2");
	}

	@Override
	void diiffer2() {
		System.out.print("5");
		
	}

}

class B extends C {
	void differ() {
		System.out.print("4");
	}

	@Override
	void diiffer2() {
		// TODO Auto-generated method stub
		
	}

}