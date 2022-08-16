# https://leetcode.com/problems/count-vowels-permutation/
class Solution:
    def countVowelPermutation(self, n: int) -> int:
        if n == 0:
            return 0
        
        a = e = i = o = u = 1
        for j in range(n - 1):
            a, e, i, o, u = e, i + a, a + e + o + u, i + u, a
        
        return (a + e + i + o + u) % 1000000007