
public class Okno {
	
	private double szerokoscCalkowita;
	private double wysokoscCalkowita;
	private double szerokoscRamy;
	
	
	public double getSzerokoscCalkowita() {
		return szerokoscCalkowita;
	}
	
	public void setSzerokoscCalkowita(double szerokoscCalkowita) {
		if(szerokoscCalkowita > 0)
		{
			this.szerokoscCalkowita = szerokoscCalkowita;
		}
		else
		{
			System.out.println("Wartosc mniejsza badz rowna zero");
			this.szerokoscCalkowita = 50;
		}
	}
	
	public double getWysokoscCalkowita() {
		return wysokoscCalkowita;
	}
	
	public void setWysokoscCalkowita(double wysokoscCalkowita) {
		if(wysokoscCalkowita > 0)
		{
			this.wysokoscCalkowita = wysokoscCalkowita;
		}
		else
		{
			System.out.println("Wysokosc calkowita mniejsza badz rowna zero");
			this.wysokoscCalkowita = 80;
		}
	}
	
	public double getSzerokoscRamy() {
		return szerokoscRamy;
	}
	
	public void setSzerokoscRamy(double szerokoscRamy) {
		if((szerokoscRamy * 2) <= (getSzerokoscCalkowita() * 0.1))
		{
			this.szerokoscRamy = szerokoscRamy;
		}
		else
		{
			System.out.println("Szerokosc ramy wieksza od 10% szerokosci calkowitej");
			this.szerokoscRamy = 3;
		}
	}

	public Okno() {
		
	}

	public Okno(double szerokoscCalkowita, double wysokoscCalkowita, double szerokoscRamy) {
		setSzerokoscCalkowita(szerokoscCalkowita);
		setWysokoscCalkowita(wysokoscCalkowita);
		setSzerokoscRamy(szerokoscRamy);
	}
	
	public double obliczSzyba() {
		return (getSzerokoscCalkowita() - (2 * getSzerokoscRamy())) * 
				(getWysokoscCalkowita() - (2 * getSzerokoscRamy()));
	}
	
	public double cenaOkna(double cenaRamy, double cenaSzyby) {
		return (cenaSzyby * obliczSzyba()) + (cenaRamy * ((getSzerokoscCalkowita() * 
												getWysokoscCalkowita()) - obliczSzyba()));
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "SZEROKOSC CALKOWITA = " + szerokoscCalkowita + "\n";
			text += "WYSOKOSC CALKOWITA = " + wysokoscCalkowita + "\n";
			text += "SZEROKOSC RAMY = " + szerokoscRamy + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(szerokoscCalkowita);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(szerokoscRamy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wysokoscCalkowita);
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
		Okno other = (Okno) obj;
		if (Double.doubleToLongBits(szerokoscCalkowita) != Double.doubleToLongBits(other.szerokoscCalkowita))
			return false;
		if (Double.doubleToLongBits(szerokoscRamy) != Double.doubleToLongBits(other.szerokoscRamy))
			return false;
		if (Double.doubleToLongBits(wysokoscCalkowita) != Double.doubleToLongBits(other.wysokoscCalkowita))
			return false;
		return true;
	}
}
