#!/bin/python3

import sys

# Problem:
# Cake. Many candles of different heights, heights presented as array ar.
# You blow out the tallest candles only. How many do you blow?

def birthdayCakeCandles(n, ar):
    # Complete this function

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = birthdayCakeCandles(n, ar)
print(result)
