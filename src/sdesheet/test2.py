def collectCoins(coins):
    pick1, pick2 = 0, 0

    for coin in coins:
        temp = max(coin + pick1, pick2)
        pick1 = pick2
        pick2 = temp
    
    return pick2


def collect(coins):
    size = len(coins) + 1
    dp = [-1] * size

    def helper(index):
        if index < 0:
            return 0
        elif index == 0:
            return coins[0]
        if dp[index] != -1:
            return dp[index]

        take = helper(index - 2) + coins[index]
        notTake = helper(index - 1)
        dp[index] = max(take, notTake)
        return dp[index]

    return helper(size - 2)

if __name__ == "__main__":
    size = int(input())
    coins = []
    for _ in range(size):
        coins.append(int(input()))
    
    print(collect(coins))

"""
[pick1, pick2, n, n + 1, ...]

"""
