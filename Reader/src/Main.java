//		KM PROGRAMS		http://km-programs.pl/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("-------------------------");
		Set<Reader> readerSet = new HashSet<>();
		readerSet.add(new Reader("Lukasz", "Pietruszka", 33, 0.0));
		readerSet.add(new Reader("Jan", "Kowalski", 19, 0.0));
		readerSet.add(new Reader("Ewa", "Pelczar", 15, 0.0));
		readerSet.add(new Reader("Jerzy", "Czarniecki", 45, 0.0));
		
		List<Reader> readerList = new ArrayList<>();
		readerList.addAll(readerSet);
		
		Set<Book> bookSet = new HashSet<>();
		bookSet.add(new Book("Chciwosc", "Pawel Reszka", 50));
		bookSet.add(new Book("Janko muzykant", "Henryk Sienkiewicz", 20));
		bookSet.add(new Book("Krzyzacy", "Henryk Sienkiewicz", 100));
		bookSet.add(new Book("Lalka", "Boleslaw Prus", 40));
		bookSet.add(new Book("Dym", "Maria Konopnicka", 60));
		bookSet.add(new Book("Antek", "Boleslaw Prus", 70));
		bookSet.add(new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 80));
		bookSet.add(new Book("Potop", "Henryk Sienkiewicz", 90));
		
		List<Book> bookList = new ArrayList<>();
		bookList.addAll(bookSet);
		
		List<Borrow> borrowList = new ArrayList<>();
		borrowList.add(new Borrow(readerList.get(0), bookList.get(0), "02-11-2016"));
		borrowList.add(new Borrow(readerList.get(0), bookList.get(1), "02-11-2016"));
		borrowList.add(new Borrow(readerList.get(1), bookList.get(2), "04-10-2016"));
		borrowList.add(new Borrow(readerList.get(1), bookList.get(3), "25-10-2016"));
		borrowList.add(new Borrow(readerList.get(2), bookList.get(4), "30-09-2016"));
		borrowList.add(new Borrow(readerList.get(2), bookList.get(5), "01-08-2016"));
		borrowList.add(new Borrow(readerList.get(3), bookList.get(6), "15-10-2016"));
		borrowList.add(new Borrow(readerList.get(3), bookList.get(7), "29-10-2016"));		
		
		for(Borrow borrow: borrowList) {
			borrow.calculatePenalty(borrow);
		}
		
		Map<Reader, Double> penalty = new HashMap<>();
		for (Reader reader : readerSet) {
			penalty.put(reader, reader.getPenaltyAmount());
		}
		
		for(Entry<Reader, Double> penaltyMap: penalty.entrySet()) {
			System.out.println(penaltyMap);
		}
		
	}
}
