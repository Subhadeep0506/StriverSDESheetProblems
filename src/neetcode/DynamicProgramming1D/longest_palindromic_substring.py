"""
"babad"
for each index, we go left and right and check for palindromes
eg: if we are at index 1, string formed by left and right of i is : bab
it is a palindrome
"""


class LongestPalindromicSubstring:
    def longestPalindrome(self, s: str) -> str:
        self.res = ""
        self.length = 0

        def buildPalindrome(l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r - l + 1 > self.length:
                    self.res = s[l: r + 1]
                    self.length = r - l + 1
                l -= 1
                r += 1

        for i in range(len(s)):
            # For odd length
            l, r = i, i
            buildPalindrome(l, r)

            # For even length
            l, r = i, i + 1
            buildPalindrome(l, r)
        
        return self.res