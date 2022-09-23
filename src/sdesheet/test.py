from collections import defaultdict

res = defaultdict(int, {0: 1, -2: 3, 1: 3, -1: 4, 2: 6})
res = sorted(res.items())

print(res)