#!/bin/python3

import sys

# Problem:
# You get fed a number N and then an N by N (square) grid.
# Sum the two diagonals and then find the difference.
# a is a nice 2D array of all the numbers being given.

n = int(input().strip())
a = []
for a_i in range(n):
    a_t = [int(a_temp) for a_temp in input().strip().split(' ')]
    a.append(a_t)

# Sums of each diagonal
primary = 0
secondary = 0

# Count all numbers top-left to bottom-right
for i in range(n):
    primary += a[i][i]
    
# Count all numbers top-right to bottom-left
for i in range(n):
    secondary += a[n-i-1][i]

# Output
print(abs(primary - secondary))
