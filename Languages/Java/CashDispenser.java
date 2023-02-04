package Languages.Java;

// Cashdispenser is supposed to dispense cash 
// initial amount is 2000 dollars in the dispenser 
public class CashDispenser {
    private static final int INITIAL_COUNT = 2000;
    private int count; // this counts the number of $20 bills remaining

    public CashDispenser() {
        count = INITIAL_COUNT; // set count to initial value
    }

    // simulate dispensing of specified amount of cash 
    public void dispenseCash(int amount) {
        // bills required is set to amount divided by 20 
        int billsRequired = amount / 20; 
        // deduct count of bills from the billsRequired 
        count -= billsRequired; 
    }

    // method to determine if cash dispenser can dispense desired amount 
    public boolean isSufficientCashAvailable(int amount) {
        // lets say 100 dollars
        // will get five 20 dollar bills 
        int billsRequired = amount / 20; // number of $20 bills required 

        if (count >= billsRequired) {
            return true; // enough bills available 
        } else {
            return false; // not enough bills available
    }
} 
    
}
