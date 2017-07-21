#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

import sys

# Problem:
# You get an array arr of size n.
# Print the fractions of numbers in arr that are positive, negative, and zero

n = int(input().strip())
arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]

# We could loop through and add to counters,
# but I just want to use Python's list comprehensions here.
# They're very neat.

# Counters
positive = len([e for e in arr if e > 0])
negative = len([e for e in arr if e < 0])
zero = len([e for e in arr if e == 0])

print(positive/n)
print(negative/n)
print(zero/n)

# A single loop would be faster (probably), and look like this.
# for elem in arr:
#     if elem > 0:
#         positive += 1
#     elif elem < 0:
#         negative += 1
#     else:
#         zero += 1
# ...
# etc.
