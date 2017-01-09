
public class Reader {
	
	private String name;
	private String surname;
	private int age;
	private double penaltyAmount;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAge() {
		return age;
	}
	 
	public void setAge(int age) {
		this.age = age;
	}
	 
	public double getPenaltyAmount() {
		return penaltyAmount;
	}
	 
	public void setPenaltyAmount(double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public Reader() {
		
	}

	public Reader(String name, String surname, int age, double penaltyAmount) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.penaltyAmount = penaltyAmount;
	}

	@Override
		public String toString() {
			String text = "";
			text += "\n";
			text += "NAME = " + name + "\n";
			text += "SURNAME = " + surname + "\n";
			text += "AGE = " + age + "\n";
			text += "PENALTY AMOUNT = " + penaltyAmount + "\n";
			return text;
		}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + age;
		long temp;
		temp = Double.doubleToLongBits(penaltyAmount);
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
		Reader other = (Reader) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(penaltyAmount) != Double.doubleToLongBits(other.penaltyAmount))
			return false;
		return true;
	}
	
}