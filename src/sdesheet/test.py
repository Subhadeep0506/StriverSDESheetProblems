from collections import defaultdict

def allocateChefs(chefs) -> int:
    timeA, timeB, timeC = 0, 0, 0
    for chef, times in chefs.items():
        minTime = min(times)
        if chef == 'A':
            timeA = minTime
        elif chef == 'B':
            timeB = minTime
        else:
            timeC = minTime
    return min(timeA + timeB, timeC)


if __name__ == "__main__":
    chefs = defaultdict(list)
    size = int(input())
    for _ in range(size):
        inp = input()
        chef = inp[0]
        time = int(inp[2:])
        chefs[chef].append(time)

    print(allocateChefs(chefs))
