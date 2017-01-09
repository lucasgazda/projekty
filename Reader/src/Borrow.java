
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Borrow { 
	
	private Reader reader = new Reader();
	private Book book = new Book();
	private String date;
 
	public Reader getReader() {
		return reader;
	}
	
	public void setReder(Reader reader) {
		this.reader = reader;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void calculatePenalty(Borrow borrow) {
		double penaltyAmount = 5.0;
		LocalDate ld = LocalDate.now();
		String borrowDate = borrow.getDate();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld1 = LocalDate.parse(borrowDate, dtf);
		long borrowDays = ChronoUnit.DAYS.between(ld, ld1);
		
		int days = Math.abs((int)borrowDays);
		
		if(days > 14) 
		{
			if(borrow.getReader().getAge() > 18) 
			{
				borrow.getReader().setPenaltyAmount(((days-14) * penaltyAmount) + borrow.getReader().getPenaltyAmount());
			}
			else
			{
				borrow.getReader().setPenaltyAmount(((days-14) * (penaltyAmount * 0.5)) + borrow.getReader().getPenaltyAmount());
			}
		}
	}

	public Borrow() {
		
	}

	public Borrow(Reader reader, Book book, String date) {
		this.reader = reader;
		this.book = book;
		this.date = date;
	}

	@Override
	public String toString() {
		String text = "";
		text += "READER = " + reader + "\n";
		text += "BOOK = " + book + "\n";
		text += "DATE = " + date + "\n";
		return text;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		Borrow other = (Borrow) obj;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}
	
}
