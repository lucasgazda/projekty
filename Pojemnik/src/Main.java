
public class Main {
	
	public static Pojemnik pojemnikMax(Pojemnik[] tab) {
		double objetoscMax = 0;
		Pojemnik pojemnik = new Pojemnik();
		
		for (int i = 0; i < tab.length; i++) {
			
			if(pojemnik.obliczObjetosc(tab[i]) > objetoscMax)
			{
				pojemnik = tab[i];
			}
		}
		
		return pojemnik;
	}
	
	

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/
	
		Pojemnik p1 = new Pojemnik("Szary", 5, 5, 5);
		Pojemnik p2 = new Pojemnik("Czarny", 10, 12, 15); 
		Pojemnik p3 = new Pojemnik("Czerwony", 4, 4, 40);
		
		Pojemnik[] tab = new Pojemnik[]{p1, p2, p3};
		
		double d = p1.obliczObjetosc(new Pojemnik("Szary", 5, 5, 5));
		
		System.out.println("Objetosc pojemnika p1 to " + d);
		
		if(p1.czySubstancjaSieZmiesci(126, d) == false)
		{
			System.out.println("Substancja nie zmiesci sie do pojemnika p1");
		}
		else
		{
			System.out.println("Substancja zmiesci sie do pojemnika p1");
		}
		
		System.out.println("Pojmnik o najwiekszej objetosci to " + "\n" + pojemnikMax(tab));

	}

}
