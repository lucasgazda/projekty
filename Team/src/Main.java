
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
//		KM PROGRAMS		http://km-programs.pl/

		Team d = new Team("Wisla", 10);
		Team d1 = new Team("Legia", 8);
		Team d2 = new Team("Lech", 20);
		Team d3 = new Team("Gornik", 30);
		Team d4 = new Team("Pogon", 51);
		
		Coach t = new Coach("Adam", "Nawalka", 55);
		Coach t1 = new Coach("Tomasz", "Hajto", 45);
		Coach t2 = new Coach("Tomasz", "Iwan", 40);
		Coach t3 = new Coach("Michal", "Probierz", 51);
		Coach t4 = new Coach("Czeslaw", "Michniewicz", 47);
		
		Map<Team, Coach> mapa = new TreeMap<>((o1,o2) -> (o1.getPointsNumber() - o2.getPointsNumber()));
		mapa.put(d, t);
		mapa.put(d1, t1);
		mapa.put(d2, t2);
		mapa.put(d3, t3);
		mapa.put(d4, t4);
		
		Coach coachPointsMax = new Coach();
		Coach coachAgeMax = new Coach();
		int pointsNumberMax = 0;
		int ageMax = 0;
		
		for(Entry<Team, Coach> e: mapa.entrySet())
		{
			if(e.getKey().getPointsNumber() > pointsNumberMax)
			{
				coachPointsMax = e.getValue();
				pointsNumberMax = e.getKey().getPointsNumber();
			}
		}
		
		for(Entry<Team, Coach> e: mapa.entrySet())
		{
			if(e.getValue().getAge() > ageMax)
			{
				coachAgeMax = e.getValue();
				ageMax = e.getValue().getAge();
			}
		}
		
		System.out.println("OLDEST COACH " + coachAgeMax.getName() + " " + coachAgeMax.getSurname());
		System.out.println();
		System.out.println(coachPointsMax.getName() + " " + coachPointsMax.getSurname() + " TRAINS TEAM WITH THE HIGHEST POINT NUMBER");
		

	}

}
