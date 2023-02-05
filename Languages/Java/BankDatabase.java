package Languages.Java;


// HOLDS INFORMATION ABOUT ACCOUNT HOLDERS 
public class BankDatabase {
    private Account[] accounts; // array of accounts 

    public BankDatabase() {
        accounts = new Account[2]; // two accounts for testing purposes 
        accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[1] = new Account(98765, 56789, 200.0, 200.0);

    }
    // retrieve account object containing specified account number 
        // private method object created from the Account class with an account number argument(used inside the code) 
        // for loop through all Account class object with currentAccount as placeholder for account object 
        // if currentAccount object calls getAccountNumber method and its equal to accountNumber argument 
        // then return the account number 
        // else return numm 
    private Account getAccount(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                return currentAccount;
            }
        }
        return null; // if no matching account was found, return null 
    }

    // determine whether user-specified account number and pin match 
    // public method that returns boolean with accountNumber and pin as as arguments 
    // getAccount method is used to get account number which matches and store in Account object called user account 
    // if userAccount object is not null, return userAccount object calling validatePIN method from the account class with userPIN as argument, else return false 
    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);
        if (userAccount != null) {
            return userAccount.validatePin(userPIN); 
        } else {
            return false; 
        }
    }

    // return available balance of account with specified account number 
    // return getAccount method with accountNumber calling getAvailablaBalance method from the Account class
    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance(); 
    }

    // get the total balance 
    // public class that returns double with accountNumber as argument 
    // return getAccount method with accountNumber calling getTotalBalance method from the Account class
    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance(); 
    }

    // credit an amount to Account with specified account number 
    // public class that returns nothing but adds money into account 
    // name of method is credit and takes two arguments, accountNumber and amount 
    // getAccount method with accountnumber callng credit method with amount as argument 
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount); 
    }


    // debit an amount from Account with specified account number 
    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount); 
    }
    
    
}
