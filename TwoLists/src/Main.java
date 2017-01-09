//		KM PROGRAMS		http://km-programs.pl/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			list1.add(rnd.nextInt(50));
			list2.add(rnd.nextInt(50));
		}
		
		list1.stream().forEach(e -> {System.out.print(e + ", ");});
		System.out.println();
		list2.stream().forEach(e -> {System.out.print(e + ", ");});
		System.out.println();
		
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < 20; i++) 
		{
			for (int j = 0; j < 20; j++) 
			{
				if(list1.get(i) == list2.get(j))
				{
					if(i < j)
					{
						map.put(list1.get(i), i);
					}
					else
					{
						map.put(list2.get(j), j);
					}
				}
			}
		}
		
		for(Entry<Integer, Integer> e: map.entrySet())
		{
			System.out.println(e);
		}
		
	}
}
