
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/

		Random rnd = new Random();
		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			lista1.add(rnd.nextInt(50));
			lista2.add(rnd.nextInt(50));
		}
		
		lista1.stream().forEach(e -> {System.out.print(e + ", ");});
		System.out.println();
		lista2.stream().forEach(e -> {System.out.print(e + ", ");});
		System.out.println();
		
		
		Map<Integer, Integer> mapa = new HashMap<>();
		
		for (int i = 0; i < 20; i++) 
		{
			for (int j = 0; j < 20; j++) 
			{
				if(lista1.get(i) == lista2.get(j))
				{
					if(i < j)
					{
						mapa.put(lista1.get(i), i);
					}
					else
					{
						mapa.put(lista2.get(j), j);
					}
				}
			}
		}
		
		for(Entry<Integer, Integer> e: mapa.entrySet())
		{
			System.out.println(e);
		}
	}
}
