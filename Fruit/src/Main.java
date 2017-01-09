//		KM PROGRAMS		http://km-programs.pl/

public class Main {
	
	public static Fruit porownajOwoc(Fruit o1, Fruit o2) {
		
		if(Fruit.calculatePrice(o1) > Fruit.calculatePrice(o2))
		{
			return o1;
		}
		return o2;
	}

	public static void main(String[] args) {
			
		Fruit o1 = new Fruit("Banana", 2.3, 2);
		Fruit o2 = new Fruit("Kiwi", 1.5, 2);
		
		System.out.println(o1.getName() + " price " + o1.calculatePrice(o2));
		
		System.out.println("FRUIT WITH BIGGEST PRICE:" + "\n" + porownajOwoc(o1, o2));
	}

}