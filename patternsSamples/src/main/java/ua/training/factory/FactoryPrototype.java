package ua.training.factory;

import java.util.Date;

public class FactoryPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WatchMaker digitalFactory = new DigitalWatchMaker();
		WatchMaker romeFactory = new RomeWatchMaker();
		Watch newWatch = digitalFactory.createWatch();
		newWatch.showTime();
		newWatch =  romeFactory.createWatch();
		newWatch.showTime();
		
		WatchMaker newWatchMaker = getWatchMakerByName("Digital");
		newWatch = newWatchMaker.createWatch();
		newWatch.showTime();
		
	}
	public static WatchMaker getWatchMakerByName(String maker){
		if(maker.equals("Digital")){
			return new DigitalWatchMaker();
		}
		else if (maker.equals("Rome")){
			return new RomeWatchMaker();
		}
		throw new RuntimeException("incorrect watch");
	}

}
interface Watch{
	public void showTime();
}

class DigitalWatch implements Watch{

	@Override
	public void showTime() {
		System.out.println( new Date());
	}
	
}

class RomeWatch implements Watch{
	@Override
	public void showTime() {
		System.out.println("VII-XII" );
	}
}

interface WatchMaker{
	Watch createWatch();
	
}

class DigitalWatchMaker implements WatchMaker{

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new DigitalWatch();
	}
	
}

class RomeWatchMaker implements WatchMaker{

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new RomeWatch();
	}
	
}