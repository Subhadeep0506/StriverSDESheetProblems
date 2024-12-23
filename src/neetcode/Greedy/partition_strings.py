"""
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
"""


from typing import List


class PartitionStrings:
    def partitionLabels(self, s: str) -> List[int]:
        lasts = {}
        for i, c in enumerate(s):
            lasts[c] = i
        
        end, size = 0, 0
        res = []
        for i, c in enumerate(s):
            size += 1
            end = max(end, lasts[c])

            if i == end:
                res.append(size)
                size = 0
                end = 0
        return res