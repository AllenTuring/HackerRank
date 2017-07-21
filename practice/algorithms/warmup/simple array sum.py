#!/bin/python3

import sys

def simpleArraySum(n, ar):
    # we could do this with a loop,
    # or just be lazy...
    return sum(ar)

n = int(input().strip())
ar = list(map(int, input().strip().split(' ')))
result = simpleArraySum(n, ar)
print(result)
