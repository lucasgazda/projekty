
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Wypozyczenie { 
	
	private Czytelnik c = new Czytelnik();
	private Ksiazka k = new Ksiazka();
	private String data;
 
	public Czytelnik getC() {
		return c;
	}
	
	public void setC(Czytelnik c) {
		this.c = c;
	}
	
	public Ksiazka getK() {
		return k;
	}
	
	public void setK(Ksiazka k) {
		this.k = k;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void obliczKara(Wypozyczenie w) {
		double wysokoscKary = 5.0;
		LocalDate ld = LocalDate.now();
		String dataWypozyczenia = w.getData();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld1 = LocalDate.parse(dataWypozyczenia, dtf);
		long dniWypozyczenie = ChronoUnit.DAYS.between(ld, ld1);
		
		int dni = Math.abs((int)dniWypozyczenie);
		
		if(dni > 14) 
		{
			if(w.getC().getWiek() > 18) 
			{
				w.getC().setWysokoscKary(((dni-14) * wysokoscKary) + w.getC().getWysokoscKary());
			}
			else
			{
				w.getC().setWysokoscKary(((dni-14) * (wysokoscKary * 0.5)) + w.getC().getWysokoscKary());
			}
		}
	}

	public Wypozyczenie() {
		
	}

	public Wypozyczenie(Czytelnik c, Ksiazka k, String data) {
		this.c = c;
		this.k = k;
		this.data = data;
	}
	
	@Override
	public String toString() {
		String text = "";
		text += "CZYTELNIK = " + c + "\n";
		text += "KSIAZKA = " + k + "\n";
		text += "DATA = " + data + "\n";
		return text;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((k == null) ? 0 : k.hashCode());
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
		Wypozyczenie other = (Wypozyczenie) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		return true;
	}
}
