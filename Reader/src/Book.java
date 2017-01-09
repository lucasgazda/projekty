
public class Book {
	
	public String title;
	private String author;
	private double priceForProlongationBookReturn;


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String tytul) {
		this.title = tytul;
	}
	
	public String getAutor() {
		return author;
	}

	public void setAutor(String autor) {
		this.author = autor;
	}
	
	public double getPriceForProlongationBookReturn() {
		return priceForProlongationBookReturn;
	}
	
	public void setPriceForProlongationBookReturn(double priceForProlongationBookReturn) {
		this.priceForProlongationBookReturn = priceForProlongationBookReturn;
	}

	public Book() {
	
	}

	public Book(String title, String author, double priceForProlongationBookReturn) {
		this.title = title;
		this.author = author;
		this.priceForProlongationBookReturn = priceForProlongationBookReturn;
	}

	@Override
		public String toString() {
			String text = "";
			text += "\n";
			text += "TITLE = " + title + "\n";
			text += "AUTHOR = " + author + "\n";
			text += "PRICE FOR PROLONGATION BOOK RETURN = " + priceForProlongationBookReturn + "\n";
		return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceForProlongationBookReturn);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (Double.doubleToLongBits(priceForProlongationBookReturn) != Double
				.doubleToLongBits(other.priceForProlongationBookReturn))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
