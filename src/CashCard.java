

public class CashCard {
	private String cardNumber;
	private String expireDate;
	private String password;
	private Double balance;
	
	public CashCard(String cardNumber, String expireDate, String password, Double balance) {
		this.cardNumber = cardNumber;
		this.expireDate = expireDate;
		this.password = password;
		this.balance = balance;
	}
	/**
	 * Gets the card number.
	 * @return String cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * Gets the expiration date.
	 * @return String expireDate
	 */
	public String getExpireDate() {
		return expireDate;
	}
	
	/**
	 * Gets the account password.
	 * @return	String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the bank balance
	 * @return Double balance
	 */
	public Double getBalance() {
		return balance;
	}
	
	/**
	 * Sets the bank balance to a new amount.
	 * @param balance
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}	
}
