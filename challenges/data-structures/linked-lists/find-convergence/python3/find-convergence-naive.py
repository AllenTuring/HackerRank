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

# naive solution using O(1) space and O(n^2) runtime
def FindMergeNode(headA, headB):
    # loop consecutively through headA linked list
    ptrA = headA
    while ptrA:
        # loop consecutively through headB linked list
        # for matches to the current headA node
        ptrB = headB
        while ptrB:
            if ptrA == ptrB:
                return ptrA.data
            ptrB = ptrB.next
        ptrA = ptrA.next
