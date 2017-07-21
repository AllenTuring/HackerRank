#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

import sys

# Problem:
# Cake. Many candles of different heights, heights presented as array ar.
# You blow out the tallest candles only. How many do you blow?

def birthdayCakeCandles(n, ar):
    # First we getses the height of the tallest preciousss
    high = max(ar)

    # And then we sees how many preciousesss are that tall
    blown = 0
    for candle in ar:
        if candle == high:
        	# We blow all the tallest precioussses
            blown += 1
    
    return blown

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = birthdayCakeCandles(n, ar)
print(result)
