
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;


public class Main {
	
//	KM PROGRAMS		http://km-programs.pl/
	
	public static void main(String[] args) {

		Set<Czytelnik> listaCzytelnikow = new HashSet<>();
		listaCzytelnikow.add(new Czytelnik("Lukasz", "Gazda", 33, 0.0));
		listaCzytelnikow.add(new Czytelnik("Jan", "Kowalski", 19, 0.0));
		listaCzytelnikow.add(new Czytelnik("Ewa", "Pelczar", 15, 0.0));
		listaCzytelnikow.add(new Czytelnik("Jerzy", "Czarniecki", 45, 0.0));
		
		List<Czytelnik> lCzytelnik = new ArrayList<>();
		lCzytelnik.addAll(listaCzytelnikow);
		
		
		Set<Ksiazka> listaKsiazka = new HashSet<>();
		listaKsiazka.add(new Ksiazka("Chciwosc", "Pawel Reszka", 50));
		listaKsiazka.add(new Ksiazka("Janko muzykant", "Henryk Sienkiewicz", 20));
		listaKsiazka.add(new Ksiazka("Krzyzacy", "Henryk Sienkiewicz", 100));
		listaKsiazka.add(new Ksiazka("Lalka", "Boleslaw Prus", 40));
		listaKsiazka.add(new Ksiazka("Dym", "Maria Konopnicka", 60));
		listaKsiazka.add(new Ksiazka("Antek", "Boleslaw Prus", 70));
		listaKsiazka.add(new Ksiazka("W pustyni i w puszczy", "Henryk Sienkiewicz", 80));
		listaKsiazka.add(new Ksiazka("Potop", "Henryk Sienkiewicz", 90));
		
		List<Ksiazka> lKsiazka = new ArrayList<>();
		lKsiazka.addAll(listaKsiazka);
		
		List<Wypozyczenie> wypozyczenie = new ArrayList<>();
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(0), lKsiazka.get(0), "02-11-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(0), lKsiazka.get(1), "02-11-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(1), lKsiazka.get(2), "04-10-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(1), lKsiazka.get(3), "25-10-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(2), lKsiazka.get(4), "30-09-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(2), lKsiazka.get(5), "01-08-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(3), lKsiazka.get(6), "15-10-2016"));
		wypozyczenie.add(new Wypozyczenie(lCzytelnik.get(3), lKsiazka.get(7), "29-10-2016"));		
		
		for(Wypozyczenie w: wypozyczenie) {
			w.obliczKara(w);
		}
		
		Map<Czytelnik, Double> kara = new HashMap<>();
		for (Czytelnik c : listaCzytelnikow) {
			kara.put(c, c.getWysokoscKary());
		}
		
		for(Entry<Czytelnik, Double> e: kara.entrySet()) {
			System.out.println(e);
		}
	}
}
