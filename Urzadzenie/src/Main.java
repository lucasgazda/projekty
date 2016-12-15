
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	
	public static Map<Urzadzenie, Boolean> przegladUrzadzenia(Set<Urzadzenie> u, Map<String, Integer> m) {
		Map<Urzadzenie, Boolean> listaPrzeglad = new HashMap<>();
		
		for(Urzadzenie e: u) {
			if(m.get(e.getKlasaUrzadznia()) < e.getSumarycznyCzasPracy())
			{
				listaPrzeglad.put(e, true);
			}
			else
			{
				listaPrzeglad.put(e, false);
			}
		}
		return listaPrzeglad;
	}
	
	public static double kosztNaprawy(Map<Urzadzenie, Boolean> m) {
		double kosztNaprawy = 0;
		for(Entry<Urzadzenie, Boolean> e: m.entrySet())
		{
			if(e.getValue() == true)
			{
				kosztNaprawy += e.getKey().getKosztNaprawyUrzadzenia();
			}
		}
		return kosztNaprawy;
	}

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/

		Set<Urzadzenie> listaUrzadzen = new HashSet<>();
		listaUrzadzen.add(new Urzadzenie("Pralka", 120, "A", 100));
		listaUrzadzen.add(new Urzadzenie("Lodowka", 60, "D", 90));
		listaUrzadzen.add(new Urzadzenie("Mikrofala", 80, "C", 110));
		listaUrzadzen.add(new Urzadzenie("Plyta indukcyjna", 110, "B", 110));
		listaUrzadzen.add(new Urzadzenie("Kuchenka", 100, "A", 110));
		listaUrzadzen.add(new Urzadzenie("Piekarnik", 91, "B", 100));
		listaUrzadzen.add(new Urzadzenie("Zmywarka", 71, "C", 80));
		
		Map<String, Integer> wytyczneNaprawy = new HashMap<>();
		wytyczneNaprawy.put("A", 110);
		wytyczneNaprawy.put("B", 90);
		wytyczneNaprawy.put("C", 70);
		wytyczneNaprawy.put("D", 50);
		
		System.out.println(przegladUrzadzenia(listaUrzadzen, wytyczneNaprawy));
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("Sumaryczny koszty naprawy urzadzenia wynosi " 
							+ kosztNaprawy(przegladUrzadzenia(listaUrzadzen, wytyczneNaprawy)));
	}

}
