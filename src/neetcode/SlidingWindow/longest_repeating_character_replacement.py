"""
You are given a string s and an integer k. You can choose any character of the string and 
change it to any other uppercase English character. You can perform this operation at most k 
times.

Return the length of the longest substring containing the same letter you can get after 
performing the above operations.

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
"""


from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        counter = defaultdict(int)
        size = 0
        maxCount = 0

        for r in range(len(s)):
            counter[s[r]] += 1
            maxCount = max(maxCount, counter[s[r]])
            if (r - left + 1) - maxCount <= k:
                size = max(size, r - left + 1)
            else:
                counter[s[left]] -= 1
                left += 1

        return size
