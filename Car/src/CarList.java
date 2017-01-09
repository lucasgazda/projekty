
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarList {

	private List<Car> carList = new ArrayList<>();
	
	
	public CarList() {
		
	}

	public CarList(String fileName) {
		String prefix = "G:\\Programowanie\\Git\\Car\\";
		String suffix = ".txt";
		String filePath = prefix + fileName + suffix;
		
		try(Scanner sc = new Scanner(new File(filePath)))
		{
			while(sc.hasNextLine())
			{
				String[] tab = sc.nextLine().split(" ");
				
				carList.add(new Car(tab[0], Double.parseDouble(tab[1]), Double.parseDouble(tab[2]), Double.parseDouble(tab[3]), new ArrayList<>(Arrays.asList(tab[4].split(";")))));
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void brandSort() {
		carList = carList.stream().sorted((o1,o2) -> (o1.getBrand().compareTo(o2.getBrand()))).collect(Collectors.toList());
	}
	
	public void priceSort() {
		carList = carList.stream().sorted((o1,o2) -> (Double.compare(o1.getPrice(), o2.getPrice()))).collect(Collectors.toList());
	}
	
	public void capacitySort() {
		carList = carList.stream().sorted((o1,o2) -> (Double.compare(o1.getCapacity(), o2.getCapacity()))).collect(Collectors.toList());
	}
	
	public void milageSort() {
		carList = carList.stream().sorted((o1,o2) -> (Double.compare(o1.getMilage(), o2.getMilage()))).collect(Collectors.toList());
	}
	
	public void sizeEquipmentListSort() {
		carList = carList.stream().sorted((o1,o2) -> (Integer.compare(o1.getEquipmentList().size(), o2.getEquipmentList().size()))).collect(Collectors.toList());
	}
	
	public void nameEquipmentListSort() {
		carList = carList.stream().map(s -> {s.getEquipmentList().stream().sorted();
											return s;
											}).collect(Collectors.toList());
	}
	
	public void carDelete(double milage) {
		carList = carList.stream().filter(e -> e.getMilage() <= milage).collect(Collectors.toList());
	}
	
	public void listBrandMilage() {
		String prefix = "G:\\Programowanie\\Git\\Car\\";
		String suffix = ".txt";
		String filePath = prefix + "listBrandMilage" + suffix;
		
		try(PrintWriter pw = new PrintWriter(filePath);)
		{
			pw.println(carList.stream().sorted((o1,o2) -> o1.getBrand().compareTo(o2.getBrand())).map(e -> e.getBrand() + "-" + e.getMilage()).collect(Collectors.toList()));
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void statisticPriceCapacityMilage() {
		DoubleSummaryStatistics statPrice = carList.stream().mapToDouble(e -> e.getPrice()).summaryStatistics();
		DoubleSummaryStatistics statCapacity = carList.stream().mapToDouble(e -> e.getCapacity()).summaryStatistics();
		DoubleSummaryStatistics statMilage = carList.stream().mapToDouble(e -> e.getMilage()).summaryStatistics();
		
		String prefix = "G:\\Programowanie\\Git\\Car\\";
		String suffix = ".txt";
		String filePath = prefix + "statisticPriceCapacityMilage" + suffix;
		
		try(PrintWriter pw = new PrintWriter(filePath))
		{
			pw.println("MINIMAL PRICE = " + statPrice.getMin());
			pw.println("AVARAGE PRICE = " + statPrice.getAverage());
			pw.println("MAXIMAL PRICE = " + statPrice.getMax());
			pw.println("MINIMAL CAPACITY = " + statCapacity.getMin());
			pw.println("AVARAGE CAPACITY = " + statCapacity.getAverage());
			pw.println("MAXIMAL CAPACITY = " + statCapacity.getMax());
			pw.println("MINIMAL MILAGE = " + statMilage.getMin());
			pw.println("AVARAGE MILAGE = " + statMilage.getAverage());
			pw.println("MAXIMAL MILAGE = " + statMilage.getMax());
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void maxPrice() {
		Optional<Car> car = carList.stream().max((o1,o2) -> (Double.compare(o1.getPrice(), o2.getPrice())));
		System.out.println("CAR WITH MAX PRICE " + car);
	}
	
	public boolean checkEquipment(String equipment) {
		return carList.stream().anyMatch(e -> e.getEquipmentList().contains(equipment));
	}
	
	@Override
		public String toString() {
			return carList.stream().map(e -> e.toString()).collect(Collectors.joining("\n"));
		}

}
