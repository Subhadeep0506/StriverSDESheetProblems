def collectCoins(coins):
    pick1, pick2 = 0, 0

    for coin in coins:
        temp = max(coin + pick1, pick2)
        pick1 = pick2
        pick2 = temp
    
    return pick2

if __name__ == "__main__":
    size = int(input())
    coins = []
    for _ in range(size):
        coins.append(int(input()))
    
    print(collectCoins(coins))

"""
[pick1, pick2, n, n + 1, ...]

"""