"""
 Insert Node at the end of a linked list 
 head pointer input could be None as well for empty list
 Node is defined as
 
 class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node
 
 return back the head of the linked list in the below method
"""
# Author: Allen Jiang
# Source: HackerRank
def Insert(head, data):
    if head == None:
        return Node(data, None)

    ptr = head
    while ptr.next:
        ptr = ptr.next
    ptr.next = Node(data, None)

    return head
