/*
Kenneth Adair
www.cslearner.com

This program is used to calculate how many possible ways there are to have a certain coin value
using quarters, dimes, nickels, and pennies.  
For example there are four ways to have 10  cents:
1 dime
2 nickels
1 nickel and 5 pennies
10 pennies 
 */
package howmanywaystoget34cents;

/**
 *
 * @author Kenneth Adair
 */
public class HowManyWaysToGet34Cents {

    //This array holds our coins.  It allows the loops in the method to subtract
    //quarters, dimes, nickels, and pennies.  Theoretically we don't need this array
    //and could have hard-coded the values but I like this way better.
    protected static int[] coins = {25,10,5,1};
    //The counter is used to keep track of how many solutions there are.
    protected static int counter = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The valueToTest variable is the value we're checking to see
        //how many ways you can have that amount of money using
        //quarters, dimes, nickels, and pennies.
        int valueToTest = 34;
        System.out.println("We are testing " + valueToTest + " for this specific run.");
        //Calling our method
        coinCounter(0, valueToTest);
        //Display the solution
        System.out.println("There are " + counter + " total ways to get " + valueToTest + " cents.");
    }
    
    //This is the method that counts the coins and does all the heavy lifting for this program.  
    protected static void coinCounter(int coinIndex, int currentValue){
        //If the currentValue is less than 0 we exit without recursively calling.
        //There are 0 ways to get a negative number using coins after all.
        if(currentValue < 0){
            return;
        }
        //If we have counted down to 0, add 1 to our counter and stop recursively calling.
        //Basically this is where we've found a solution.  
        if(currentValue == 0){
            System.out.println("Incrementing the counter since we found a new solution\n");
            counter++;
            return;
        }
        /*If we haven't found a solution and we're below zero we start recursively calling the algorithm to check for other solutions
        For the loop notice that we start variable i at the coinIndex instead of at 0.  Why?
        Imagine that I'm counting how many ways to count how to get 10 cents.  
        If I allowed my algorithm to count up in addition to counting down it would find
        FIVE ways to get 10 cents instead of the correct amount which is four.
        My algorithm would find the following solutions:
        1 dime
        2 nickels
        ***1 nickel and 5 pennies***
        ***5 pennies and 1 nickel***
        10 pennies
        Notice two of the solutions are exactly the same but just in different orders.
        I accidentally double counted!  
        That's why the coinIndex is necessary and that's why it's necessary
        for the loop to start at the coin index instead of zero for each loop.  
        */
        for(int i = coinIndex; i < 4; i++){
            System.out.println("Recursively calling coinCounter using " + currentValue + " minus " + coins[i] + ".");
            coinCounter(i, (currentValue - coins[i]));
        }
    }
}