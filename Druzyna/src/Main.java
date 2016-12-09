
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/

		Druzyna d = new Druzyna("Wisla", 10);
		Druzyna d1 = new Druzyna("Legia", 8);
		Druzyna d2 = new Druzyna("Lech", 20);
		Druzyna d3 = new Druzyna("Gornik", 30);
		Druzyna d4 = new Druzyna("Pogon", 51);
		
		Trener t = new Trener("Adam", "Nawalka", 55);
		Trener t1 = new Trener("Tomasz", "Hajto", 45);
		Trener t2 = new Trener("Tomasz", "Iwan", 40);
		Trener t3 = new Trener("Michal", "Probierz", 51);
		Trener t4 = new Trener("Czeslaw", "Michniewicz", 47);
		
		Map<Druzyna, Trener> mapa = new TreeMap<>((o1,o2) -> (o1.getLiczbaPunktow() - o2.getLiczbaPunktow()));
		mapa.put(d, t);
		mapa.put(d1, t1);
		mapa.put(d2, t2);
		mapa.put(d3, t3);
		mapa.put(d4, t4);
		
		Trener trenerPunktyMax = new Trener();
		Trener trenerWiekMax = new Trener();
		int liczbaPunktowMax = 0;
		int wiekMax = 0;
		
		for(Entry<Druzyna, Trener> e: mapa.entrySet())
		{
			if(e.getKey().getLiczbaPunktow() > liczbaPunktowMax)
			{
				trenerPunktyMax = e.getValue();
				liczbaPunktowMax = e.getKey().getLiczbaPunktow();
			}
		}
		
		for(Entry<Druzyna, Trener> e: mapa.entrySet())
		{
			if(e.getValue().getWiek() > wiekMax)
			{
				trenerWiekMax = e.getValue();
				wiekMax = e.getValue().getWiek();
			}
		}
		
		System.out.println("Najstarszy trener to " + trenerWiekMax.getImie() + " " + trenerWiekMax.getNazwisko());
		System.out.println();
		System.out.println(trenerPunktyMax.getImie() + " " + trenerPunktyMax.getNazwisko() + " trenuje druzyne o najwiekszej liczbe punktow");
		

	}

}
