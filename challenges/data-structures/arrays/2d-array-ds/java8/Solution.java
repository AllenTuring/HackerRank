import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

	/*
	Problem TLDR:
	You get a 6x6 2d array entered as string-separated numbers on separate lines.
	The elements will be integers between -9 and 9 inclusive.
	An hourglass is an I shape like this:
	 1 2 3
	   4
	 5 6 7
	Find the maximum hourglass sum, and print it.
	*/

	// Scanner to read inputs
	private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
		// 6x6 2D array to store the grid
		int[][] grid = new int[6][6];
		// Populate grid with input
		read(in, grid);
		// Find the maximum sum
		int maxSum = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE;
		// Loop through and target the center hourglass value
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				sum = hourglassSum(i, j, grid);
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		// Output
		System.out.println(maxSum);
    }

    /** Given an input and an int[][] grid, populates that grid with input
    * @param grid A 6x6 2D array of ints to fill
    * @param input A Scanner with the designated data source input
    */
    private static void read(Scanner input, int[][] grid) {
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 6; j++) {
    			grid[i][j] = input.nextInt();
    		}
    	}
    }

    /** Given a 6x6 grid of ints, and a pair of coordinates for the
    * center of an hourglass, returns the sum of that hourglass.
    * @param grid A 6x6 2D array of ints
    * @param i Primary coordinate for search
    */
    private static int hourglassSum(int i, int j, int[][] grid) {
    	int sum = 0;
    	sum += grid[i - 1][j - 1]; // top left
    	sum += grid[i - 1][j];     // top
    	sum += grid[i - 1][j + 1]; // top right
    	sum += grid[i][j]; // center
    	sum += grid[i + 1][j - 1]; // bottom left
    	sum += grid[i + 1][j];     // bottom
    	sum += grid[i + 1][j + 1]; // bottom right
    	return sum;
    }
}