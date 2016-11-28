package ua.training.singleton;

public class SingletonPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 1000;
		//Singleton s ;
		
		Singleton[] arr = new Singleton[SIZE];
		for(int i=0; i< SIZE; i++){
			arr[i]= Singleton.getInstance();
		}
	//Singleton s2 = new Singleton();
		System.out.println(Singleton.getCounter());
	}

}
class Singleton{
	private static Singleton instance;
	public static int counter = 0;
	private Singleton(){
		counter++;		
	}
	
	public static int getCounter() {
		return counter;
	}

	public static Singleton getInstance(){
		if(instance == null){
			
			instance = new Singleton();
		}
		return instance;
	}
}