
public class Container {
	
	private String colour;
	private double width;
	private double lenght;
	private double height;
	
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		if(colour.matches("[A-Z][a-z]+"))
		{
			this.colour = colour;
		}
		else
		{
			System.out.println("COLOUR VALIDATION INCORRECT");
			this.colour = "WHITE";
		}
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		if(width >= 0)
		{
			this.width = width;
		}
		else
		{
			System.out.println("WIDTH LESS THEN 0");
			this.width = 5;
		}
	}
	
	public double getLenght() {
		return lenght;
	}
	
	public void setLenght(double lenght) {
		if(lenght >= 0)
		{
			this.lenght = lenght;
		}
		else
		{
			System.out.println("LENGHT LESS THEN 0");
			this.lenght = 5;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		if(height >= 0)
		{
			this.height = height;
		}
		else
		{
			System.out.println("HEIGHT LESS THEN 0");
			this.height = 5;
		}
	}

	public Container() {
		
	}

	public Container(String colour, double width, double lenght, double height) {
		setColour(colour);
		setWidth(width);
		setLenght(lenght);
		setHeight(height);
	}

	public double calculateCapacity(Container container) {
		return container.getLenght() * container.getWidth() * container.getHeight();
	}
	
	public boolean ifSubstanceFit(double capacity, double containerCapacity) {
		if(capacity == containerCapacity)
		{
			return true;
		}
		return false;
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "COLOUR = " + colour + "\n";
			text += "WIDTH = " + width + "\n";
			text += "LENGHT = " + lenght + "\n";
			text += "HEIGHT = " + height + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lenght);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
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
		Container other = (Container) obj;
		if (Double.doubleToLongBits(lenght) != Double.doubleToLongBits(other.lenght))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}
	
}
