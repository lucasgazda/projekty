
public class Owoc {

	private String nazwa;
	private double cena;
	private double waga;
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		if(nazwa.matches("Kiwi|Banan|Brzoskwinia"))
		{
			this.nazwa = nazwa;
		}
		else
		{
			this.nazwa = "Arbuz";
			System.out.println("Podano nieprawidlowy owoc");
		}
	}
	
	public double getCena() {
		return cena;
	}
	
	public void setCena(double cena) {
		if(getNazwa().matches("Kiwi"))
		{
			if(cena >= 1.2 && cena <= 4.5)
			{
				this.cena = cena;
			}
			else
			{
				this.cena = 3.3;
				System.out.println("Podana cena nie zawiera sie w przedziale");
			}
		}
		else
		{
			if(cena >= 0.4 && cena <= 2.3)
			{
				this.cena = cena;
			}
			else
			{
				this.cena = 3.3;
				System.out.println("Podana cena nie zawiera sie w przedziale");
			}
		}
	}
	
	public double getWaga() {
		return waga;
	}
	
	public void setWaga(double waga) {
		if(waga > 0)
		{
			this.waga = waga;
		}
		else
		{
			this.waga = 33;
			System.out.println("Waga jest mniejsza badz rowna 0");
		}
	}
	
	public static double obliczCene(Owoc o){
		return o.cena * o.waga;
	}

	public Owoc() {
		
	}

	public Owoc(String nazwa, double cena, double waga) {
		setNazwa(nazwa);
		setCena(cena);
		setWaga(waga);
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "NAZWA = " + nazwa + "\n";
			text += "CENA = " + cena + "\n";
			text += "WAGA = " + waga + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		temp = Double.doubleToLongBits(waga);
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
		Owoc other = (Owoc) obj;
		if (Double.doubleToLongBits(cena) != Double.doubleToLongBits(other.cena))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (Double.doubleToLongBits(waga) != Double.doubleToLongBits(other.waga))
			return false;
		return true;
	}
	
}
