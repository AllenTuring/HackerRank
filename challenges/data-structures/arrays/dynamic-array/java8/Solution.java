import java.io.*;
import java.util.*;


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
	private static FastIntArrayList[] seqList;
	// The lastAnswer storage
	private static int lastAnswer;
	// Read input scanner from system.in
	private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    	// Read the first two inputs.
    	int size = in.nextInt();
    	int commandCount = in.nextInt();

    	// Initialize seqList to the correct size.
    	seqList = new FastIntArrayList[size];
        for (int i = 0; i < size; i++) {
            seqList[i] = new FastIntArrayList(size);
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
    	seqList[index].add(val);
    }

    /** Reads the value at the specified index and subindex in the sequence list
	* @param index The index of the sequence in the list
	* @param subindex The index of the item in the sequence
	* @return The element at the specified indices in the sequence list
    */
    private static int read(int index, int subindex) {
    	index = index % seqList.length;
    	return seqList[index].get(subindex);
    }
    
    /** A class for wrapping the data as a non-generic int array list.
    * Note that this data structure does not expand.
    */
    private static class FastIntArrayList {
        int[] data;
        int size;
        
        /** Constructor for a new FastIntArrayList
        * @param maxSize the maximum size of this array list.
        */
        public FastIntArrayList(int maxSize) {
            this.size = 0;
            this.data = new int[maxSize];
        }
        
        /** Adds a new element to the end of this array list.
        * @param elem The element to add.
        */
        public void add(int elem) {
            data[size] = elem;
            size++;
        }
        
        /** Gets the specified element of this array list
        * @param index The index of the element to return.
        */
        public int get(int index) {
            return data[index % size];
        }
    }

}