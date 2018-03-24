
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATM {
	private Bank bankName;
	private Double cashLimit;

	/**
	 * 
	 * @param bankName
	 * @param cashLimit
	 */
	public ATM(Bank bankName, Double cashLimit) {
		this.bankName = bankName;
		this.cashLimit = cashLimit;
	}
	/**
	 * Gets the Bank name.
	 * @return bankName
	 */
	public Bank getBankName() {
		return bankName;
	}
	/**
	 * Gets the max cash limit.
	 * @return cashLimit
	 */
	public Double getCashLimit() {
		return cashLimit;
	}
	
	/**
	 * Checks if card is expired or not.
	 * @param expireDate
	 * @return if card is expired then returns true, else returns false.
	 * @throws ParseException
     * Precondition: expire date is a string
     * Postcondition: boolean true or false
	 */
	public boolean isExpired(String expireDate) throws ParseException {
		return new SimpleDateFormat("MM/dd/yy").parse(expireDate).before(new Date());
	}
	
	/**
	 * Checks if the card account is valid by checking if it has the correct bank_id and
	 * then checks if the card is expired.
	 * @param cardNumber
	 * @return returns true if bank_id is correct and card is not expired.
	 * @throws ParseException
     * Precondition: Card number is a string
     * Postcondition: boolean true or false
	 */
	public boolean isCardValid(String cardNumber) throws ParseException {
		if(cardNumber.substring(0, 1).equals(bankName.getBank_ID())) { //Checks if bankID is valid
			CashCard card = bankName.findCashCard(cardNumber);
			if(card != null) {
				String expireDate = card.getExpireDate();
				if(isExpired(expireDate)) {
					System.out.println("This card is expired and returned to you.");
					return false;
				}else {
					System.out.println("The card is accepted. Please enter your password.");
					return true;
				}
			} else {
				System.out.println("This card is not in the System. Try Again.");
				return false;
			}
		} else {
			System.out.println("This card is not supported by this ATM");
			return false;
		}
	}
	
	/**
	 * Checks if the password matches the account password.
	 * @param cardNumber
	 * @param password
	 * @return true if the password matches the account password.
     * Precondition: Card number and password is a string
     * Postcondition: boolean true or false
	 */
	public boolean checkPassword(String cardNumber, String password) {
		
		if(bankName.findCashCard(cardNumber).getPassword().equals(password)) {
			System.out.println("Authorization is accepted. "
					+ "Start your transaction by entering the amount to withdraw. ");
			return true;
		}
		else {
			System.out.print("This is a wrong password. ");
			return false;
		}
	}
	
	/**
	 * Checks if the entered amount can be withdrawn, 
	 * if yes then the money is subtracted from the current balance.
	 * @param cardNumber
	 * @param amount
     * Precondition: Card number is a string, and Double amount is greater than or equal to 0
     * Postcondition: the balance will be decreased by the amount
	 */
	public void withdraw(String cardNumber, double amount) {
		CashCard account = bankName.findCashCard(cardNumber);
		double accountBalance = account.getBalance();
        if(amount > 0){
            if(amount <= cashLimit) {
                if(amount <= accountBalance ) {
                    account.setBalance(accountBalance-amount);
                    System.out.printf("$%.2f is withdrawn from  your account. The remaining balance "
                            + "of this account is $%.2f. If you have more transactions,"
                            + " enter the amount or quit.\n", amount, accountBalance-amount);
                }
                else {
                    System.out.println("The amount exceeds the current balance. Enter another amount or quit.");
                }
            }
            else {
                System.out.println("This amount exceeds the maximum amount you can withdraw per transaction."
                        + " Please enter the amount or quit.");
            }
        }
        else {
            System.out.println("The amount has to be a positive value!");
    }
}
}
