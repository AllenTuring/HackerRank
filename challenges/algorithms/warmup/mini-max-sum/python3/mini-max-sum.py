#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

import sys

# Problem
# You get an array of 5 numbers.
# Print the sum of the smallest 4 and then the biggest 4.

arr = list(map(int, input().strip().split(' ')))

# First we add up all 5 numbers, no selecting.
total = sum(arr)
# Subtract the biggest number to get the sum of the smallest 4.
min_sum = total - max(arr)
# Subtract the smallest number to get the sum of the biggest 4.
max_sum = total - min(arr)

print(min_sum, max_sum)
