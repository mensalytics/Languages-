package Languages.Java;
import java.util.Scanner; 

public class Keypad {
    private Scanner input; // object created from the scanner class 

    // constructor 
    public Keypad() {
        input = new Scanner(System.in); 
    }

    // method to get the input which is an integer 
    public int getInput() {
        return input.nextInt(); 
    }
    
}
