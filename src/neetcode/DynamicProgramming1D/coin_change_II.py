from typing import List


class CoinChangeII:
    def change(self, amount: int, coins: List[int]) -> int:
        cache = {}

        def dfs(index, curr_amount):
            if curr_amount == amount:
                return 1
            if curr_amount > amount or index == len(coins):
                return 0
            if (index, curr_amount) in cache:
                return cache[(index, curr_amount)]

            cache[(index, curr_amount)] = dfs(index, curr_amount + coins[index]) + dfs(index + 1, curr_amount)
            return cache[(index, curr_amount)]

        return dfs(0, 0)