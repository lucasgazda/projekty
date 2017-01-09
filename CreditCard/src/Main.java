//		KM PROGRAMS		http://km-programs.pl/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		CreditCard card1 = new CreditCard();
		card1.setActualAccountBalance(500);
		card1.addAccountOperations("CANCELED");
		card1.addAccountOperations("TRANSFER_100");
		card1.addAccountOperations("CANCELED");
		card1.addAccountOperations("TRANSFER_50");
		card1.addAccountOperations("CANCELED");
		card1.addAccountOperations("WITHDRAW_10");
		card1.addAccountOperations("LOGIN_ERROR");
		
		CreditCard card2 = new CreditCard();
		card2.setActualAccountBalance(400);
		card2.addAccountOperations("TRANSFER_10");
		card2.addAccountOperations("LOGIN_ERROR");
		card2.addAccountOperations("WITHDRAW_50");
		card2.addAccountOperations("CANCELED");
		card2.addAccountOperations("WITHDRAW_50");
		card2.addAccountOperations("LOGIN_ERROR");
		card2.addAccountOperations("CANCELED");
		
		CreditCard card3 = new CreditCard();
		card3.setActualAccountBalance(300);
		card3.addAccountOperations("LOGIN_ERROR");
		card3.addAccountOperations("WITHDRAW_40");
		card3.addAccountOperations("CANCELED");
		card3.addAccountOperations("WITHDRAW_60");
		card3.addAccountOperations("LOGIN_ERROR");
		card3.addAccountOperations("CANCELED");
		card3.addAccountOperations("LOGIN_ERROR");
		
		System.out.println("AMOUNT CANCEL OPERATIONS: " + card1.amountCancelOperations());
		System.out.println();
		System.out.println("CARD WITH LARGEST ACCOUNT BALANCE:" + "\n" + CreditCard.compareCreditCards(card3, card2));
		System.out.println();
		System.out.println("ACCOUNT BALANCE BEFORE 5 OPERATIONS: " + card2.accountBalanceBefore(5));
		System.out.println();
		
		List<CreditCard> creditCardList = new ArrayList<>(Arrays.asList(new CreditCard[]{card1, card2, card3}));
		System.out.println(CreditCard.errorLoginCreditCard(creditCardList));
		System.out.println();
		
		CreditCard.statisticCreditCard(creditCardList);
		System.out.println();
		
		card1.transfer(100);
		System.out.println();
		
		card1.clearOperationsHistory();
		System.out.println();
	
	}
}