#!/bin/python3

import sys

# Problem:
# Print a hashtag staircase of size n.
# This is a staircase of size 4:
#    #
#   ##
#  ###
# ####

n = int(input().strip())

for i in range(n):
    print(" "*(n-i-1) + "#"*(i+1))

