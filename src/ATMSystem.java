
import java.text.ParseException;
import java.util.Scanner;
/**
 * ATM system allows the user to access their bank account to withdraw money.
 * @author Praneet Singh
 *
 */
public class ATMSystem {
	/**
	 * main
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		
		Bank bankA = new Bank("A");
		
		CashCard card1 = new CashCard("A11", "04/24/17", "password1", 40.0);
		bankA.addCard(card1);
		CashCard card2 = new CashCard("A12", "11/12/18", "mypassword", 40.0);
		bankA.addCard(card2);
		
		Bank bankB = new Bank("B");
		
		CashCard card3 = new CashCard("B111", "06/22/21", "password3", 40.0);
		bankB.addCard(card3);
		CashCard card4 = new CashCard("B122", "01/15/15", "password4", 40.0);
		bankB.addCard(card4);
		CashCard card5 = new CashCard("B133", "10/21/20", "password5", 40.0);
		bankB.addCard(card5);
		
		ATM atmA1 = new ATM(bankA, 50.0);
		ATM atmA2 = new ATM(bankA, 50.0);
		ATM atmB1 = new ATM(bankB, 50.0);
		ATM atmB2 = new ATM(bankB, 50.0);

		boolean loop = false;   // will stay false until the card is valid, the password is correct and withdraw amount is accepted
		boolean loop1 = true;   // will stay true until a valid choice of ATM is selected
		Scanner scan = new Scanner(System.in);
		
		while(loop1) {
		System.out.println("Enter your choice of ATM: ");
		String atmSelection = scan.nextLine();      //Gets the choice of ATM
	
			if(atmSelection.equals("ATM1_A")){
				loop1 = false;
				String cardNumber = null;
				while(!loop) {                      // loops until card is invalid
					System.out.println("Enter your card: ");
					cardNumber = scan.nextLine();
					loop = atmA1.isCardValid(cardNumber);
				}
				loop = false;
					while(!loop) {                  // loops until password is invalid
					System.out.println("Enter your password: ");
					String password = scan.nextLine();
					loop = atmA1.checkPassword(cardNumber, password);
					}
				
				loop = false;
				while(!loop) {                      // loops until withdraw amount is accepted, exits is user enters "quit"
					String withdrawOrExit = scan.nextLine();
					if(withdrawOrExit.equals("quit")) {
						scan.close();               // closes scanner
						return;
					}else {
						Double withdrawAmount = Double.parseDouble(withdrawOrExit);
					atmA1.withdraw(cardNumber, withdrawAmount);
					}
				}
			}
		
			else if(atmSelection.equals("ATM2_A")) {
				loop1 = false;
				String cardNumber = null;
				while(!loop) {                      // loops until card is invalid
					System.out.println("Enter your card: ");
					cardNumber = scan.nextLine();
					loop = atmA2.isCardValid(cardNumber);
				}
				loop = false;
					while(!loop) {                  // loops until password is invalid
					System.out.println("Enter your password: ");
					String password = scan.nextLine();
					loop = atmA2.checkPassword(cardNumber, password);
					}
				
				loop = false;
				while(!loop) {                      // loops until withdraw amount is accepted, exits is user enters "quit"
					String withdrawOrExit = scan.nextLine();
					if(withdrawOrExit.equals("quit")) {
						scan.close();               // closes scanner
						return;
					}else {
						Double withdrawAmount = Double.parseDouble(withdrawOrExit);
					atmA2.withdraw(cardNumber, withdrawAmount);
					}
				}
				
			}
			else if(atmSelection.equals("ATM1_B")) {
				loop1 = false;
				String cardNumber = null;
				while(!loop) {                      // loops until card is invalid
					System.out.println("Enter your card: ");
					cardNumber = scan.nextLine();
					loop = atmB1.isCardValid(cardNumber);
				}
				loop = false;
					while(!loop) {                  // loops until password is invalid
					System.out.println("Enter your password: ");
					String password = scan.nextLine();
					loop = atmB1.checkPassword(cardNumber, password);
					}
				
				loop = false;
				while(!loop) {                      // loops until withdraw amount is accepted, exits is user enters "quit"
					String withdrawOrExit = scan.nextLine();
					if(withdrawOrExit.equals("quit")) {
						scan.close();               // closes scanner
						return;
					}else {
						Double withdrawAmount = Double.parseDouble(withdrawOrExit);
					atmB1.withdraw(cardNumber, withdrawAmount);
					}
				}
				
			}
			else if(atmSelection.equals("ATM2_B")) {
				loop1 = false;
				String cardNumber = null;
				while(!loop) {                      // loops until card is invalid
					System.out.println("Enter your card: ");
					cardNumber = scan.nextLine();
					loop = atmB2.isCardValid(cardNumber);
				}
				loop = false;
					while(!loop) {                  // loops until password is invalid
					System.out.println("Enter your password: ");
					String password = scan.nextLine();
					loop = atmB2.checkPassword(cardNumber, password);
					}
				
				loop = false;
				while(!loop) {                      // loops until withdraw amount is accepted, exits is user enters "quit"
					String withdrawOrExit = scan.nextLine();
					if(withdrawOrExit.equals("quit")) {
						scan.close();               // closes scanner
						return;
					}else {
						Double withdrawAmount = Double.parseDouble(withdrawOrExit);
					atmB2.withdraw(cardNumber, withdrawAmount);
					}
				}
				
			}
			else {
				loop1 = true;
				System.out.println("ATM you chose is invalid try again. ");
			}
			
		}
		scan.close();                               // closes scanner
	}	
}
	
