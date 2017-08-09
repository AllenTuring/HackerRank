"""
 Find the node at which both lists merge and return the data of that node.
 head could be None as well for empty list
 Node is defined as
 
 class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node

 
"""
# Author: Allen Jiang
# Source: HackerRank

# solution using O(n) space and O(n) runtime
def FindMergeNode(headA, headB):
    # We need a data structure that behaves like a hashset in Java.
    # Sets do constant time access according to https://wiki.python.org/moin/TimeComplexity.

    # Dictionary to hold list A's nodes
    elemsA = set()
    while headA:
        elemsA.add(headA)
        headA = headA.next

    # now loop through B and ask for coincidence with A
    while headB:
        if headB in elemsA:
            return headB.data
        headB = headB.next
