#!/bin/python3

import sys

# Problem TLDR:
# You get n integers fed into you as list ar
# Return their sum.
# These integers can be very big, so be wary of overflow.

def aVeryBigSum(n, ar):
    # Complete this function

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = aVeryBigSum(n, ar)
print(result)
