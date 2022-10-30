from typing import (
    List
)


class KMostFrequentElements:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        freq_list = [[] for i in range(len(nums) + 1)]

        # Store the numbers and their frequencies in a map
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
            
        # Create a list of size of the same size as original list, and sore
        # the numbers as list in am index equal their count
        # eg: for [1,1,1,2,2,3], 
        # freq_list = [[],[3],[2],[1],[],[],[]] 
        for num, count in freq.items():
            freq_list[count].append(num)
        
        res = []
        for i in range(len(freq_list) - 1, 0, -1):
            for num in freq_list[i]:
                res.append(num)
                if len(res) == k:
                    return res
        return []