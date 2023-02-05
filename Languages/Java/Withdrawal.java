package Languages.Java;

public class Withdrawal extends Transaction{ 
    private double amount; 
    private Keypad keypad; 
    private CashDispenser cashDispenser; 
    private final static int CANCELED = 6; 

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase); 
        keypad = atmKeypad; 
        cashDispenser = atmCashDispenser; 
    }

    @Override 
    public void execute() {
        boolean cashDispensed = false; 
        double availableBalance; 


        //  get references to the bankdatabase and screen 
        BankDatabase bankDatabase = getBankDatabase(); 
        Screen screen = getScreen(); 


        // loop until cash is dispensed or user cancels 
        // AN ALGORITHM 
        do {
            // obtain a chosen withdrawal amount from the user 
            amount = displayMenuOfAmounts(); 

            // check whether user chose a withdrawal amount or canceled 
            if (amount != CANCELED) {
                // get available balance of account involved 
                availableBalance = bankDatabase.getAvailableBalance(getAccountNumber()); 

                // check whether user has enough money in the account 
                if (amount <= availableBalance) {
                    // check whether the cash dispenser has enough money 
                    if (cashDispenser.isSufficientCashAvailable(amount)) {
                        // update the account involved to reflect the withdrawal 
                        bankDatabase.debit(getAccountNumber(), amount); 

                        cashDispenser.dispenseCash(amount); // dispense cash 
                        cashDispensed = true; // cash was dispensed so loop ends 

                        // instruct user to take cash 
                        screen.displayMessageLine("\nYour cash has been " + "dispensed. Please take your cash now."); 
                    } else { // cash dispenser does not have enough cash 
                        screen.displayMessageLine("\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount."); 
                    }
                } else { // not enough money available in user's account 
                    screen.displayMessageLine("\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount."); 
                }
            } else { // user chose cancel menu option 
                screen.displayMessageLine("\nCanceling transaction..."); 
                return; // return to main menu because user canceled 
            }
        } while (!cashDispensed);
        
    } 

    // method to display menu of amounts 
    private int displayMenuOfAmounts() {
        int userChoice = 0; 
        Screen screen = getScreen(); 

        int[] amounts = {0, 20, 40, 60, 100, 200}; 

        while (userChoice == 0) {
            screen.displayMessageLine("\nWithdrawal Menu: ");
            screen.displayMessageLine("1 - $20");
            screen.displayMessageLine("2 - $40");
            screen.displayMessageLine("3 - $60");
            screen.displayMessageLine("4 - $100");
            screen.displayMessageLine("5 - $200");
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessage("\nChoose a withdrawal amount: ");

            int input = keypad.getInput(); 

            switch (input) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                    userChoice = amounts[input]; 
                    break; 
                default: 
                    screen.displayMessageLine("\nInvalid selection. Try again.");
            }
        }
        return userChoice; 
    }
    
}
