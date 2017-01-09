//		KM PROGRAMS		http://km-programs.pl/

public class Main {
	
	public static Container pojemnikMax(Container[] tab) {
		double objetoscMax = 0;
		Container pojemnik = new Container();
		
		for (int i = 0; i < tab.length; i++) {
			
			if(pojemnik.calculateCapacity(tab[i]) > objetoscMax)
			{
				pojemnik = tab[i];
			}
		}
		
		return pojemnik;
	}
	
	

	public static void main(String[] args) {
	
		Container container1 = new Container("Grey", 5, 5, 5);
		Container container2 = new Container("Black", 10, 12, 15); 
		Container container3 = new Container("Red", 4, 4, 40);
		
		Container[] tab = new Container[]{container1, container2, container3};
		
		double containerCapacity = container1.calculateCapacity(new Container("Grey", 5, 5, 5));
		
		System.out.println("CAPACITY CONTAINER1 " + containerCapacity);
		System.out.println();
		
		if(container1.ifSubstanceFit(126, containerCapacity) == false)
		{
			System.out.println("SUBSTANCE WILL NOT FIT TO CONTAINER1");
			System.out.println();
		}
		else
		{
			System.out.println("SUBSTANCE WILL FIT TO CONTAINER1");
			System.out.println();
		}
		
		System.out.println("CONTAINER WITH THE BIGGEST CAPACITY:" + "\n" + pojemnikMax(tab));

	}

}
