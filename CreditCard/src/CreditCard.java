
import java.util.List;
import java.util.Scanner;

public class CreditCard extends AbstractBankOperations {
	Scanner sc = new Scanner(System.in);
	
	private int pin = 123;
	
	
	public int getPin() {
		return pin;
	}

	public CreditCard() {
		
	}
	
	public boolean ifPinIsCorrect(int pin) {
		boolean ifCorrect = false;
		if(pin == getPin())
		{
			ifCorrect = true;
		}
		return ifCorrect;
	}
	
	public CreditCard(int pin) {
		this.pin = pin;
	}

	@Override
	public void transfer(double amount) {
		System.out.println("Please provide pin number");
		int pin = Integer.parseInt(sc.nextLine());
		if(ifPinIsCorrect(pin))
		{
			setActualAccountBalance(getActualAccountBalance() + amount);
		}
		else
		{
			addAccountOperations("LOGIN_ERROR");
			System.out.println("Pin number incorrect");
		}
	}
	
	@Override
		public void clearOperationsHistory() {
			System.out.println("Please provide pin number");
			int pin = Integer.parseInt(sc.nextLine());
			if(ifPinIsCorrect(pin))
			{
				super.clearOperationsHistory();
			}
			else
			{
				addAccountOperations("LOGIN_ERROR");
				System.out.println("Pin number incorrect");
			}
		}

	public static CreditCard errorLoginCreditCard(List<CreditCard> creditCardList) {
		return creditCardList.stream().sorted((x1, x2) -> 
		((int)(x1.getAccountOperations().stream().filter(x -> x.equals("LOGIN_ERROR")).count() - 
			   x2.getAccountOperations().stream().filter(x -> x.equals("LOGIN_ERROR")).count())))
				 .findFirst().get();
	}
	
	public static CreditCard compareCreditCards(CreditCard card1, CreditCard card2) {
		
		return card1.getActualAccountBalance() > card2.getActualAccountBalance() ? card1 : card2;
	}

	public static void statisticCreditCard(List<CreditCard> creditCardList) {
		int i = 1;
		
		for(CreditCard card: creditCardList)
		{
			System.out.println("CARD" + i);
			System.out.println("NUMBERS OF OCCURENCES 'TRANFER' IN OPERATIONS HISTORY " + card.getAccountOperations().stream().filter(x -> x.matches("TRANSFER_[0-9]+")).count());
			System.out.println("NUMBERS OF OCCURENCES 'WITHDRAW' IN OPERATIONS HISTORY " + card.getAccountOperations().stream().filter(x -> x.matches("WITHDRAW_[0-9]+")).count());
			System.out.println("NUMBERS OF OCCURENCES 'CANCELED' IN OPERATIONS HISTORY " + card.getAccountOperations().stream().filter(x -> x.equals("CANCELED")).count());
			System.out.println("NUMBERS OF OCCURENCES 'LOGIN_ERROR' IN OPERATIONS HISTORY " + card.getAccountOperations().stream().filter(x -> x.equals("LOGIN_ERROR")).count());
			i++;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (pin != other.pin)
			return false;
		return true;
	}
}
