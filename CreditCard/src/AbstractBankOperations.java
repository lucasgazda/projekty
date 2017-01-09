
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBankOperations implements BankOperations {

	private double actualAccountBalance;
	private List<String> accountOperationsList = new ArrayList<>();
	
	
	public double getActualAccountBalance() {
		return actualAccountBalance;
	}
	
	public void setActualAccountBalance(double actualAccountBalance) {
		this.actualAccountBalance = actualAccountBalance;
	}
	
	public List<String> getAccountOperations() {
		return accountOperationsList;
	}

	public void addAccountOperations(String operations) {
		accountOperationsList.add(operations);
	}

	public AbstractBankOperations() {
		
	}

	public AbstractBankOperations(double actualAccountBalance, List<String> accountOperations) {
		this.actualAccountBalance = actualAccountBalance;
		this.accountOperationsList = accountOperations;
	}

	@Override
		public void withDraw(double amount) {
			if(getActualAccountBalance() >= amount)
			{
				actualAccountBalance -= amount;
				accountOperationsList.add("Withdraw_" + String.valueOf(actualAccountBalance));
			}
			else
			{
				accountOperationsList.add("CANCELED");
			}
		}
	
	@Override
		public double accountBalance() {
			return getActualAccountBalance();
		}

	public Long amountCancelOperations() {
		return accountOperationsList.stream().filter(x -> x.equals("CANCELED")).count();
	}
	
	public void clearOperationsHistory() {
		accountOperationsList.clear();
	}
	
	public double accountBalanceBefore(int amountOperations) {
		
		for(int i = 0; i < accountOperationsList.size() - amountOperations; i++)
		{
			String[] tab = accountOperationsList.get(i).split("_");
	
			if(tab[0].matches("WITHDRAW"))
			{
				setActualAccountBalance(getActualAccountBalance() - Integer.parseInt(tab[1]));
			}
			else if(tab[0].matches("TRANSFER"))
			{
				setActualAccountBalance(getActualAccountBalance() + Integer.parseInt(tab[1]));
			}
		}
		return getActualAccountBalance();
	}

	@Override
	public String toString() {
		return "ACTUAL ACCOUNT BALANCE = " + getActualAccountBalance() + "\n" + "ACCOUNT OPERATIOINS = " + accountOperationsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountOperationsList == null) ? 0 : accountOperationsList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(actualAccountBalance);
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
		AbstractBankOperations other = (AbstractBankOperations) obj;
		if (accountOperationsList == null) {
			if (other.accountOperationsList != null)
				return false;
		} else if (!accountOperationsList.equals(other.accountOperationsList))
			return false;
		if (Double.doubleToLongBits(actualAccountBalance) != Double.doubleToLongBits(other.actualAccountBalance))
			return false;
		return true;
	}
}
