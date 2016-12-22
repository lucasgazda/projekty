
import java.util.ArrayList;
import java.util.List;

public class Car {

	private String brand;
	private double price;
	private double capacity;
	private double milage;
	private List<String> equipmentList = new ArrayList<>();
	
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public double getMilage() {
		return milage;
	}
	
	public void setMilage(double milage) {
		this.milage = milage;
	}
	
	public List<String> getEquipmentList() {
		return equipmentList;
	}
	
	public void addEquipmentList(String equipment) {
		this.equipmentList.add(equipment);
	}
	
	public Car() {
		
	}

	public Car(String brand, double price, double capacity, double milage, List<String> equipmentList) {
		this.brand = brand;
		this.price = price;
		this.capacity = capacity;
		this.milage = milage;
		this.equipmentList = equipmentList;
	}

	@Override
	public String toString() {
		return "BRAND = " + brand + ", PRICE = " + price + ", CAPACITY = " + capacity + ", MILAGE = " + milage
				+ ", EQUIPMENT LIST = " + equipmentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		long temp;
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((equipmentList == null) ? 0 : equipmentList.hashCode());
		temp = Double.doubleToLongBits(milage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(capacity) != Double.doubleToLongBits(other.capacity))
			return false;
		if (equipmentList == null) {
			if (other.equipmentList != null)
				return false;
		} else if (!equipmentList.equals(other.equipmentList))
			return false;
		if (Double.doubleToLongBits(milage) != Double.doubleToLongBits(other.milage))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	} 	
}
