"""
Alice has some number of cards and she wants to rearrange the cards into groups so 
that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card 
and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.
"""


import heapq
from typing import List


class HandOfStraights:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        
        count = {}
        for n in hand:
            count[n] = 1 + count.get(n, 0)
        
        minheap = list(count.keys())
        heapq.heapify(minheap)

        while minheap:
            first = minheap[0]

            for n in range(first, first + groupSize):
                if n not in count:
                    return False
                
                count[n] -= 1
                if count[n] == 0:
                    if minheap[0] != n:
                        return False
                    heapq.heappop(minheap)
        
        return True

"""
1. Use a hash map to store the numbers and their counts
2. Use a heap to store the keys
3. start from the smallest element in heap and check if next k elemnts can be used
4. if after using k elemnts any element other than the first element has a count of 0, return false
"""