#!/bin/python3

# Author: Allen Jiang
# Source: HackerRank

import sys

# Problem
# You get a time string of format hh:mm:ssAM in 12 hour time.
# Convert it to military time (24-hour clock) of form hh:mm:ss

def timeConversion(s):
    # Break up the time string into blocks
    # This is Python string slicing.
    hh = s[:2]
    mmss = s[2:-2]
    block = s[-2:]
    
    # Correct the 12: to 00: when going between the clocks
    # Very tricky nuance: 12:-- PM is actually better regarded as 00:-- PM
    # Military time uses the 00 and 12, 12 AM and 12 PM respectively.
    if hh == "12":
        hh = "00"
    
    # If it's PM, we just take the time and add 12.
    # Assuming a valid input, we shouldn't need to % 24.
    if block == "PM":
        # add 12 hours if PM
        hh = str((int(hh) + 12))
        # fill in any lost zero padding so it's still 2 digits.
        if len(hh) == 1:
            hh = "0" + hh
            
    # Return the corrected time. Note: no AM/PM in 24 hour clock.
    return hh + mmss

s = input().strip()
result = timeConversion(s)
print(result)
