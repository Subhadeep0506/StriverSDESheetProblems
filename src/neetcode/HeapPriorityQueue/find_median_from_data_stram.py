import heapq


class FindMedianFromDataStram:
    def __init__(self):
        self.minheap, self.maxheap = [], []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.maxheap, -1 * num)
        if self.minheap and self.maxheap and (self.maxheap[0] * -1 > self.minheap[0]):
            temp = -1 * heapq.heappop(self.maxheap)
            heapq.heappush(self.minheap, temp)
        if len(self.maxheap) > len(self.minheap) + 1:
            temp = -1 * heapq.heappop(self.maxheap)
            heapq.heappush(self.minheap, temp)
        if len(self.minheap) > len(self.maxheap) + 1:
            temp = heapq.heappop(self.minheap)
            heapq.heappush(self.maxheap, -1 * temp)

    def findMedian(self) -> float:
        if len(self.minheap) > len(self.maxheap): 
            return self.minheap[0]
        elif len(self.maxheap) > len(self.minheap):
            return self.maxheap[0] * -1
        return (self.minheap[0] + self.maxheap[0] * -1) / 2
