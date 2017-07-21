#!/bin/python3

import sys

# Problem TLDR:
# Alice and Bob have three scores,
# Award each of them a "comparison point" each time
# they score better than the other at something.
# Then return the comparison scores they get.

def solve(a0, a1, a2, b0, b1, b2):
    # Score counts
    alice_score = 0
    bob_score = 0
    
    # Using arrays for future code extensibility
    alice = [a0, a1, a2]
    bob = [b0, b1, b2]
    
    # Looping through the arrays means no code duplication
    for i in range(0, len(alice)):
        if (alice[i] > bob[i]):
            alice_score += 1
        elif (bob[i] > alice[i]):
            bob_score += 1
    
    return [alice_score, bob_score]

a0, a1, a2 = input().strip().split(' ')
a0, a1, a2 = [int(a0), int(a1), int(a2)]
b0, b1, b2 = input().strip().split(' ')
b0, b1, b2 = [int(b0), int(b1), int(b2)]
result = solve(a0, a1, a2, b0, b1, b2)
print (" ".join(map(str, result)))
