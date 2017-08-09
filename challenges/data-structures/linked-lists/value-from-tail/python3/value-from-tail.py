#Body
"""
 Get Node data of the Nth Node from the end.
 head could be None as well for empty list
 Node is defined as
 
 class Node(object):
 
   def __init__(self, data=None, next_node=None):
       self.data = data
       self.next = next_node

 return back the node data of the linked list in the below method.
"""
# Author: Allen Jiang
# Source: HackerRank
def GetNode(head, position):
	# Define a search target that starts at the head
	target_node = head

	# Define a node that stays #position + 1 nodes ahead of the search target
	end_search_node = head
	for i in range(position + 1):
		end_search_node = end_search_node.next

	# Iterate them both along until end_search_node falls off the end
	while end_search_node:
		target_node = target_node.next
		end_search_node = end_search_node.next

	return target_node.data
