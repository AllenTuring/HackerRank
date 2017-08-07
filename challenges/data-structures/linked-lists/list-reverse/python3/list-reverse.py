"""
 Reverse a linked list
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
def Reverse(head):
	# initialize
	current_node = head
	prev_node = None

	# list should be
	# N 1->2->3->4->5->N
	# p c

	# read from head to tail until current_node is None
	while current_node:
		# Save the next node as next_node
		next_node = current_node.next
		# Point the current node's next at what came before
		# ..<-p  c->n->..  ===>  ..<-p<-c  n->..
		current_node.next = prev_node
		# iterate 1 step forward
		prev_node = current_node
		current_node = next_node

	# list should be
	# N<-1<-2<-3<-4<-5 N
	#                p c

	# give back the new head (at prev_node)
	return prev_node
