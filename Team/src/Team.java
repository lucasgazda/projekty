
public class Team {

	private String name;
	private int pointsNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPointsNumber() {
		return pointsNumber;
	}
	
	public void setPointsNumber(int pointsNumber) {
		this.pointsNumber = pointsNumber;
	}

	public Team() {
		
	}

	public Team(String name, int pointsNumber) {
		this.name = name;
		this.pointsNumber = pointsNumber;
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "NAME = " + getName() + "\n";
			text += "POINTS NUMBER = " + getPointsNumber() + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pointsNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Team other = (Team) obj;
		if (pointsNumber != other.pointsNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
