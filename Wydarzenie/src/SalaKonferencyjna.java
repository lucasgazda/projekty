
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SalaKonferencyjna {

	private Queue<Wydarzenie> kolejka = new PriorityQueue<>	((o1,o2) -> 
															(o1.getCzasTrwania() - o2.getCzasTrwania()));
	
	public void dodajWydarzenie(Wydarzenie wydarzenie) {
		kolejka.add(wydarzenie);
	}
	
	public void usunWydarzenie() {
		Scanner sc = new Scanner(System.in);
		
		kolejka.forEach(e -> {System.out.println(e);});
		
		System.out.println("Podaj tytul wydarzenia do usuniecia");
		String wydarzenie = sc.nextLine();
		
		kolejka.removeIf(e -> e.getNazwaWydarzenia().equals(wydarzenie));
		
		System.out.println("--------------------------------------------");
		
		kolejka.forEach(e -> {System.out.println(e);});
		
	}
	
	public void statystyka() {
		kolejka.forEach(e -> {System.out.println(e);});
		
		NumberFormat nf = new DecimalFormat("#0.0");
		
		System.out.println("------------------------------------");
		
		System.out.println("Srednia liczba uczestnikow " + nf.format(kolejka.stream()
		.collect(Collectors.summarizingDouble(e -> e.getIloscUczestnikow())).getAverage()));
		
		System.out.println("Najdluzszy czas trwania wydarzenia " + nf.format(kolejka.stream()
				.collect(Collectors.summarizingInt(e -> e.getCzasTrwania())).getMax()));
		
		System.out.println("Najkrotszy czas trwania wydarzenia " + nf.format(kolejka.stream()
				.collect(Collectors.summarizingInt(e -> e.getCzasTrwania())).getMin()));
		
		System.out.println("Sredni czas trwania wydarzenia " + nf.format(kolejka.stream()
				.collect(Collectors.summarizingInt(e -> e.getCzasTrwania())).getAverage()));
	}

	public SalaKonferencyjna() {
		
	}

	public SalaKonferencyjna(Queue<Wydarzenie> kolejka) {
		this.kolejka = kolejka;
	}
	
	@Override
		public String toString() {
			return "KOLEJKA = " + kolejka;
		}
}
