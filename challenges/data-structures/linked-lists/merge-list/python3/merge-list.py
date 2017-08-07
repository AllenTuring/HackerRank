"""
 Merge two linked lists
 head could be None as well for empty list
 Node is defined as
 
 class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node

 return back the head of the linked list in the below method.
"""
# Author: Allen Jiang
# Source: HackerRank
def MergeLists(headA, headB):
	# Empty list base cases
	if headA == None:
		return headB
	if headB == None:
		return headA
	# If neither case applies, neither list is empty

	# Compare the values, and set the lower element's
	# next to the merged list of remaining elements
	if headA.data < headB.data:
		headA.next = MergeLists(headA.next, headB)
		return headA
	else:
		headB.next = MergeLists(headA, headB.next)
		return headB
