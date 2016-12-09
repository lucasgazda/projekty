

public class Main {
	
	public static Owoc porownajOwoc(Owoc o1, Owoc o2) {
		
		if(Owoc.obliczCene(o1) > Owoc.obliczCene(o2))
		{
			return o1;
		}
		return o2;
	}

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/
	
		Owoc o1 = new Owoc("Banan", 2.3, 2);
		Owoc o2 = new Owoc("Kiwi", 1.5, 2);
		
		System.out.println("Cena " + o1.getNazwa() + " to " + o1.obliczCene(o2));
		
		System.out.println("Owoc o najwiekszej cenie to" + "\n" + porownajOwoc(o1, o2));
	}

}
