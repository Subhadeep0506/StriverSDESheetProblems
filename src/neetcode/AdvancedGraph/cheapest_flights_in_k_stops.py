from typing import List


class CheapestFlightsInKStops:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float("inf")] * n
        prices[src] = 0

        for _ in range(k + 1):
            temp = prices.copy()

            for source, destin, price in flights:
                if prices[source] == float("inf"):
                    continue
                if prices[source] + price < temp[destin]:
                    temp[destin] = prices[source] + price
            prices = temp

        return prices[dst] if prices[dst] != float("inf") else -1