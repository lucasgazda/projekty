

public class Trener {
	
//	Zaimplementuj 
//	klas� Trener o polach imi�, nazwisko oraz wiek. Przygotuj metody potrzebne do 
//	prawid�owego funkcjonowania klasy.
	
	private String imie;
	private String nazwisko;
	private int wiek;
	
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public int getWiek() {
		return wiek;
	}
	
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public Trener() {
		
	}

	public Trener(String imie, String nazwisko, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
	}
	
	@Override
		public String toString() {
			String text = "";
			text += "IMIE = " + getImie() + "\n";
			text += "NAZWISKO = " + getNazwisko() + "\n";
			text += "WIEK = " + getWiek() + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + wiek;
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
		Trener other = (Trener) obj;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}
	
	

}