using System;
using System.Collections.Generic;
using System.IO;

class Solution {
    static void Main(String[] args) {
        int i = 4;
        double d = 4.0;
        string s = "HackerRank ";
        // Declare second integer, double, and String variables.
        int intInput;
        double doubleInput;
        string stringInput;
        
        // Read and save an integer, double, and String to your variables.
        intInput = int.Parse(Console.ReadLine());
        doubleInput = double.Parse(Console.ReadLine());
        stringInput = Console.ReadLine();

        // Print the sum of both integer variables on a new line.
        Console.WriteLine(i + intInput);

        // Print the sum of the double variables on a new line.
        Console.WriteLine("{0:N1}", d + doubleInput); // we do this for the single decimal
        
        // Concatenate and print the String variables on a new line
        // The 's' variable above should be printed first.
        Console.WriteLine(s + stringInput);
        

    }
}
