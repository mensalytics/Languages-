package Languages.Java;


public class Screen {
    // method to display message 
    // void means it returns nothing 
    public void displayMessage(String message) {
        System.out.println(message); 
    }

    // method to display message line
    public void displayMessageLine(String message) {
        System.out.println(message); 
    }

    // display dollar amount 
    public void displayDollarAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    }
}