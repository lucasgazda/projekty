
public class Main {

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/

		Okno o = new Okno(40, 20, 2);
		
		System.out.println(o);
		
		double cenaSzyby = 20;
		double cenaRamy = 10;
		
		System.out.println("Rzeczywista powierzchnia szyby " + o.obliczSzyba());
		System.out.println();
		System.out.println("Cena okna " + o.cenaOkna(cenaSzyby, cenaRamy));
		
	}

}
