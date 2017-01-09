import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConferenceRoom {
	
	private Queue<Event> queueEvent = new PriorityQueue<>((o1,o2) -> (o1.getDuration() - o2.getDuration()));

	public void addEvent(Event event) {
		queueEvent.add(event);
	}

	public void deleteEvent() {
		Scanner sc = new Scanner(System.in);

		queueEvent.forEach(e -> {System.out.println(e);});

		System.out.println("PLEASE PROVIDE EVENT NAME TO DELETE");
		String wydarzenie = sc.nextLine();

		queueEvent.removeIf(e -> e.getEventName().equals(wydarzenie));

		System.out.println("--------------------------------------------");

		queueEvent.forEach(e -> {System.out.println(e);});

	}

	public void eventStatistics() {
		queueEvent.forEach(e -> {System.out.println(e);});

		NumberFormat nf = new DecimalFormat("#0.0");

		System.out.println("------------------------------------");

		System.out.println("Srednia liczba uczestnikow " + nf.format(queueEvent.stream().collect(Collectors.summarizingDouble(e -> e.getParticipantName())).getAverage()));

		System.out.println("Najdluzszy czas trwania wydarzenia " + nf.format(queueEvent.stream().collect(Collectors.summarizingInt(e -> e.getDuration())).getMax()));

		System.out.println("Najkrotszy czas trwania wydarzenia " + nf.format(queueEvent.stream().collect(Collectors.summarizingInt(e -> e.getDuration())).getMin()));

		System.out.println("Sredni czas trwania wydarzenia " + nf.format(queueEvent.stream().collect(Collectors.summarizingInt(e -> e.getDuration())).getAverage()));
	}

	public ConferenceRoom() {

	}
	
	public ConferenceRoom(Queue<Event> queueEvent) {
		super();
		this.queueEvent = queueEvent;
	}

	@Override
	public String toString() {
		return "KOLEJKA = " + queueEvent;
	}
}
