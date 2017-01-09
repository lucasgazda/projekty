//		KM PROGRAMS		http://km-programs.pl/

import java.util.Scanner;

public class Main {
	
	public static void sort(CarList carList) {
		System.out.println("PLEASE CHOOSE HOW DO YOU WAN TO SORT YOUR COLLECTION:");
		System.out.println("1. BRAND");
		System.out.println("2. PRICE");
		System.out.println("3. CAPACITY");
		System.out.println("4. MILAGE");
		System.out.println("5. SIZE OF EQUIPMENT LIST");
		Scanner sc = new Scanner(System.in);
		int choice = Integer.parseInt(sc.nextLine());
		
		switch (choice) 
		{
		case 1:
			carList.brandSort();
			System.out.println(carList);
			break;
		case 2:
			carList.priceSort();
			System.out.println(carList);
			break;
		case 3:
			carList.capacitySort();
			System.out.println(carList);
			break;
		case 4:
			carList.milageSort();
			System.out.println(carList);
			break;
		case 5:
			carList.sizeEquipmentListSort();
			carList.nameEquipmentListSort();
			System.out.println(carList);
			break;
		}
	}
	
	public static void check(CarList carList) {
		System.out.println("PLEASE PROVIDE EQUIPMENT NAME FOR SEARCHING");
		Scanner sc = new Scanner(System.in);
		String equipment = sc.nextLine();
		
		if(carList.checkEquipment(equipment) == true)
		{
			System.out.println("COLECTION CONTAINS " + equipment + " EQUIPMENT");
		}
		else
		{
			System.out.println("COLECTION DID NOT CONTAIN " + equipment + " EQUIPMENT");
		}
	}
	
	public static void carDelete(CarList carList) {
		System.out.println(carList);
		System.out.println("PLESE PROVIDE MILAGE NUMEBR. CARS WITH HIGHER MILAGE WILL BE DELETE");
		Scanner sc = new Scanner(System.in);
		double milage = Double.parseDouble(sc.nextLine());
		carList.carDelete(milage);
		System.out.println(carList);
	}

	public static void main(String[] args) {

		CarList cl = new CarList("data");
		
		sort(cl);
		
		cl.listBrandMilage();
		
		System.out.println();
		check(cl);
		
		cl.statisticPriceCapacityMilage();
		
		System.out.println();
		cl.maxPrice();
		
		System.out.println();
		carDelete(cl);
	}
}
