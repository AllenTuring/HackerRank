#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

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
	# Print n-(i+1) spaces and then i+1 hashes
	# We use i+1 because i starts at 0
    print(" "*(n-i-1) + "#"*(i+1))

