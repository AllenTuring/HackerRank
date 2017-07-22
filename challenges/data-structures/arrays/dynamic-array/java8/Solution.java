import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

	/*
	Problem:
	You must keep track of an int, here called lastAnswer, and a list of empty sequences.
	You get 2 numbers to begin with:
	- A number of sequences (n) to keep track of, which is also the max length of each.
	- A number of commands that follow.
	Then is a list of commands of format: c x y
	If c is 1, then:
	- Find sequence # (x xor lastanswer) % n,
	- Append y to that sequence.
	If c is 2, then:
	- Find sequence # (x xor lastanswer) % n,
	- Find element # y (modulo with size of sequence to wrap)
	- Write that element to lastAnswer, and then print it.
	*/

	// List of sequences to keep track of, and their array stored sizes
	private static int[][] seqList;
	private static int[] seqSizes;
	// The lastAnswer storage
	private static int lastAnswer;
	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    	// Read the first two inputs.
    	int size = in.nextInt();
    	int commandCount = in.nextInt();

    	// Initialize seqList to the correct size.
    	seqList = new int[size][size];
    	seqSizes = new int[size];

    	// Read the specified number of commands.
    	for (int i = 0; i < commandCount; i++) {
    		readCommand();
    	}
    }

    /** Reads and executes a 3-digit code command from stdin.
    */
    private static void readCommand() {
    	// Read the commands from stdin
    	int command = in.nextInt();
    	int x = in.nextInt();
    	int y = in.nextInt();
    	int index = x ^ lastAnswer;

    	// Execute them.
    	switch (command) {
    		case 1:
    			append(index, y);
    			break;
    		case 2:
    			lastAnswer = read(index, y);
    			System.out.println(lastAnswer);
    			break;
    	}
    }

	/** Appends a value to the end of the specified sequence in the sequence list.
	* @param index The index of the sequence in the list
	* @param val The value to append
    */
    private static void append(int index, int val) {
    	// Modulo wrap the index value
    	index = index % seqList.length;
    	// Find the subindex value of the tail.
    	int subindex = seqSizes[index];
    	seqList[index][subindex] = val;
    	seqSizes[index]++;
    }

    /** Reads the value at the specified index and subindex in the sequence list
	* @param index The index of the sequence in the list
	* @param subindex The index of the item in the sequence
	* @return The element at the specified indices in the sequence list
    */
    private static int read(int index, int subindex) {
    	index = index % seqList.length;
    	subindex = subindex % seqSizes[index];
    	return seqList[index][subindex];
    }
}