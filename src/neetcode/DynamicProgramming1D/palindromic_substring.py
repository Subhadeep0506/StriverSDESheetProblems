class PalindromicSubstring:
    # Iterative method - Similar to Longest Palindromic Substring
    def countSubstrings(self, s: str) -> int:
        self.res = []

        def buildPalindromes(l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                self.res.append(s[l: r + 1])
                l -= 1
                r += 1

        for i in range(len(s)):
            l, r = i, i
            buildPalindromes(l, r)
            l, r = i, i + 1
            buildPalindromes(l, r)
        
        return len(self.res)