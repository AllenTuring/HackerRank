import java.io.*;
import java.util.*;

/**
* @author Allen Jiang
* Solution class for HackerRank
*/

public class Solution {

    // BEGIN CODE SECTION

    /*
      Find merge point of two linked lists
      head pointer input could be NULL as well for empty list
      Node is defined as 
      class Node {
         int data;
         Node next;
      }
    */

    /** Finds the merge point of two linked lists specified by head nodes headA and headB.
    * O(n) memory and O(n) runtime.
    * @param headA The head node of the first linked list for merge detection.
    * @param headB The head node of the second linked list for merge detection.
    * @return Integer data value at the first common node.
    * @throws IllegalArgumentException
    */
    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.

        // We create and populate HashSet for O(1) searching of A's elements
        // At a cost of O(n) memory
        HashSet<Node> listA = new HashSet<Node>();
        for (Node ptrA = headA; ptrA != null; ptrA = ptrA.next) {
            listA.add(ptrA);
        }

        // Then we iterate through B with constant-time searches through A.
        for (Node ptrB = headB; ptrB != null; ptrB = ptrB.next) {
            if (listA.contains(ptrB)) {
                return ptrB.data;
            }
        }

        // Base case for no convergence
        throw new IllegalArgumentException("Linked lists A and B do not converge");
    }

    // END CODE SECTION

}