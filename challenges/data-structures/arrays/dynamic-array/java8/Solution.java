import java.io.*;
import java.util.*;


public class Solution {

	/*
	Problem:
	You must keep track of an int, here called lastAnswer, and a list of empty sequences.
	You get 2 numbers to begin with:
	- A number of sequences (n) to keep track of,.
	- A number of commands that follow.
	Then is a list of commands of format: c x y
	If c is 1, then:
	- Find sequence # (x xor lastanswer) % n,
	- Append y to that sequence.
	If c is 2, then:
	- Find sequence # (x xor lastanswer) % n,
	- Find element # y (modulo with size of sequence to wrap)
	- Write that element to lastAnswer, and then print it.
	Be careful with memory conservation! This problem is not solvable by a 2D array.
	*/

	// List of sequences to keep track of, and their array stored sizes
	private static ArrayList<ArrayList<Integer>> seqList;
	// Storage for n
	private static int n;
	// The lastAnswer storage
	private static int lastAnswer;
	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    	// Read the first two inputs.
    	n = in.nextInt();
    	int commandCount = in.nextInt();

    	// Initialize seqList to the correct size.
    	seqList = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }

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
    	int index = (x ^ lastAnswer) % n;
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
    	seqList.get(index).add(val);
    }

    /** Reads the value at the specified index and subindex in the sequence list
	* @param index The index of the sequence in the list
	* @param subindex The index of the item in the sequence
	* @return The element at the specified indices in the sequence list
    */
    private static int read(int index, int subindex) {
        ArrayList<Integer> seq = seqList.get(index);
    	return seq.get(subindex % seq.size());
    }
}