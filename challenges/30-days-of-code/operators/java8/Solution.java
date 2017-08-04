import java.util.*;
import java.math.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Arithmetic {

    /*
    Problem TLDR:
    Calculate the total cost from the subtotal (meal cost), tip%, and tax%
    Write the variable to the totalcost rounding function. (or int cast)
    Then print "The total meal cost is %s dollars."
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();
      
        // Write your calculation code here.
        double totalCostUnrounded = mealCost + (mealCost * tipPercent / 100) + (mealCost * taxPercent / 100);
      
        // cast the result of the rounding operation to an int and save it as totalCost 
        int totalCost = (int) Math.round(totalCostUnrounded);
      
        // Print your result
        System.out.printf("The total meal cost is %d dollars.", totalCost);
    }
}
