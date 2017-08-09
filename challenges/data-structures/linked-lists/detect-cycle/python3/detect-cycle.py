"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as: 
 
    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""
# Author: Allen Jiang
# Source: HackerRank
def has_cycle(head):
	# a list of the nodes we've seen (sad: O(n) memory)
    visited_nodes = []

    # loop through the list with head until head is None
    while head:
    	# Have we seen this before?
    	if head in visited_nodes:
    		return True
    	# Otherwise record and move on
    	visited_nodes.append(head)
    	head = head.next

    # The list was all clear
    return False
