from typing import List


def minMutation(start: str, end: str, bank: List[str]) -> int:
        count = 0
        for i in range(len(start)):
            if start[i] != end[i]:
                temp = start[:i] + end[i] + start[i + 1:]
                start = temp
                print(start)
                if temp in bank:
                    count += 1
        
        return count


start = "AAAAACCC"
end = "AACCCCCC"
bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
print("and:", minMutation(start, end, bank))