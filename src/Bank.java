

import java.util.ArrayList;

public class Bank{

	private String bank_ID;
	private ArrayList<CashCard> cardAccount = new ArrayList<>();
	/**
	 * @param bank_ID
	 */
	public Bank(String bank_ID) {
		this.bank_ID = bank_ID;
	}
	/**
	 * Gets the bank_id
	 * @return bank_id
	 */
	public String getBank_ID() {
		return bank_ID;
	}
	/**
	 * Adds a cash card to the cardAccount arraylist that holds all the card accounts.
	 * @param c
	 * 
	 */
	public void addCard(CashCard c) {
		cardAccount.add(c);
	}
	/**
	 * Finds the cashCard associated with the card number
	 * @param cardNumber
	 * @return CashCard
     * Precondition: Card number is a string
     * Postcondition: CashCard will be returned
	 */
	public CashCard findCashCard(String cardNumber) {
		CashCard card = null;
		for(CashCard c : cardAccount) {
			if(c.getCardNumber().equals(cardNumber)){
				card = c;
			}
			
		}
		return card;
	}
	
	
}
