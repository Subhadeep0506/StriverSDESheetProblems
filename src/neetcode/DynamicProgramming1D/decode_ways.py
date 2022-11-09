class DecodeWays:
    def numDecodingsMemo(self, s: str) -> int:
        memo = {len(s): 1}

        def dfs(i):
            if i in memo:
                return memo[i]
            if s[i] == "0":
                return 0
            
            res = dfs(i + 1)
            if (i + 1 < len(s) and 10 <= int(s[i: i + 2]) <= 26):
                res += dfs(i + 2)
            memo[i] = res
            return res

        return dfs(0)
    
    # Tabulation
    def numDecodings(self, s: str) -> int:
        dp = {len(s): 1}

        for i in range(len(s) - 1, -1, -1):
            if s[i] == "0":
                dp[i] = 0
            else:
                dp[i] = dp[i + 1]
            
            if (i + 1 < len(s) and 10 <= int(s[i : i + 2]) <= 26):
                dp[i] += dp[i + 2]
        
        return dp[0]