
public class Fruit {

	private String name;
	private double price;
	private double weight;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.matches("Kiwi|Banana|Peach"))
		{
			this.name = name;
		}
		else
		{
			System.out.println("INCORRECT FRUIT");
			this.name = "Watermelon";
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if(getName().matches("Kiwi"))
		{
			if(price >= 1.2 && price <= 4.5)
			{
				this.price = price;
			}
			else
			{
				this.price = 3.3;
				System.out.println("PRICE OUTSIDE RANGE");
			}
		}
		else
		{
			if(price >= 0.4 && price <= 2.3)
			{
				this.price = price;
			}
			else
			{
				this.price = 3.3;
				System.out.println("PROVIDED PRICE DOES NOT INCLUDE IN RANGE");
			}
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		if(weight > 0)
		{
			this.weight = weight;
		}
		else
		{
			this.weight = 33;
			System.out.println("WEIGHT IS LESS OR EQUAL 0");
		}
	}
	
	public static double calculatePrice(Fruit fruit){
		return fruit.price * fruit.weight;
	}

	public Fruit() {
		
	}

	public Fruit(String name, double price, double weight) {
		setName(name);
		setPrice(price);
		setWeight(weight);
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "NAME = " + name + "\n";
			text += "PRICE = " + price + "\n";
			text += "WEIGHT = " + weight + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
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
		Fruit other = (Fruit) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
}
