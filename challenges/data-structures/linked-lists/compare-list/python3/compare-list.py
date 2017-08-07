"""
 Merge two linked list
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
def CompareLists(headA, headB):
	if headA == None or headB == None:
		return 1 if (headA == None and headB == None) else 0
	else:
		return 0 if (headA.data != headB.data) else CompareLists(headA.next, headB.next)
