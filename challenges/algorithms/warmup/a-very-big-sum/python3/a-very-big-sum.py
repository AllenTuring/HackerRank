#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

import sys

# Problem TLDR:
# You get n integers fed into you as list ar
# Return their sum.
# These integers can be very big, so be wary of overflow.

def aVeryBigSum(n, ar):
    # Python numbers don't really overflow so... lol
    # In Java we'd use a long or BigInt and use a loop to do the sum.
    return sum(ar)

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = aVeryBigSum(n, ar)
print(result)
