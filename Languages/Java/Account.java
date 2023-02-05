package Languages.Java;

public class Account {
    private int accountNumber;
    private int pin; 
    private double availableBalance; 
    private double totalBalance; 


    public Account(int theAccountNumber, int thePin, double theAvailableBalance, double theTotalBalance) {
        accountNumber = theAccountNumber;
        pin = thePin;
        availableBalance = theAvailableBalance;
        totalBalance = theTotalBalance;
    }

    // validate user pin 
    public boolean validatePin(int userPin) {
        if (userPin == pin) {
            return true; 
            
        } else {
            return false; 
        }
    }

    // returns the available balance 
    public double getAvailableBalance() {
        return availableBalance; 
    }

    // returns the total balance 
    public double getTotalBalance() {
        return totalBalance; 
    }

    // credits an amount into account, need an amount and add that to total balancce 
    public void credit(double amount) {
        totalBalance += amount; 
    }


    // debits an amount from the account, need an amount and subtract that from total balance
    public void debit(double amount) {
        availableBalance -= amount; // subtract from available balance 
        totalBalance -= amount; // subtract from total balance
    }

    // get the users accounbt number 
    public int getAccountNumber() {
        return accountNumber; 
    }
    
}
