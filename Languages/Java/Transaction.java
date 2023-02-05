package Languages.Java;

// what is the abstract class mean ?? 
public abstract class Transaction {
    private int accountNumber; 
    private Screen screen; 
    private BankDatabase bankDatabase;

    public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        accountNumber = userAccountNumber;
        screen = atmScreen;
        bankDatabase = atmBankDatabase;
    }

    // return account number 
    public int getAccountNumber() {
        return accountNumber; 
    }

    // return reference to screen 
    public Screen getScreen() {
        return screen; 
    }

    // return reference to bank database 
    public BankDatabase getBankDatabase() {
        return bankDatabase; 
    }

    // perform the transaction which will be overriden by subclasses 
    abstract public void execute();

    
}
