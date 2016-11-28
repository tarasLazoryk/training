package ua.training.proxy;

public class ProxyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image = new ProxyImage("d:/images/my.jpg");
		image.display();
	}

}
interface Image{
	void display();
}
class ProxyImage implements Image{
	String file;
	RealImage realImage;
	public ProxyImage(String file) {
		this.file = file;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		if(realImage == null){
			realImage = new RealImage(file);
		}
		realImage.display();
	}
}
class RealImage implements Image{
	String file;
	
	public RealImage(String file) {
		this.file = file;
		load();
	}
	
	void load(){
		System.out.println("load "+file);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("watch "+file);
	}
	
}