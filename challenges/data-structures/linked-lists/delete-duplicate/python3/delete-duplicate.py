"""
 Delete duplicate nodes
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
def RemoveDuplicates(head):
    # we're going to detect segments of repetition
    segment_head = head

    # let's iterate through
    while segment_head:
        segment_pointer = segment_head.next
        # loop the pointer until it falls off the end of the repeat segment
        while segment_pointer and (segment_pointer.data == segment_head.data):
            segment_pointer = segment_pointer.next
        # collapse the segment by setting segment_head.next to after the segment
        segment_head.next = segment_pointer
        # iteration step
        segment_head = segment_head.next

    # return the original head
    return head

