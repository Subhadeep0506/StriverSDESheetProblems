import random


def choseChefs(chefs) -> int:
    time_a, time_b, time_c = 0, 0, 0
    for chef, times in chefs.items():
        if chef == "A":
            time_a = min(times)
        elif chef == "B":
            time_b = min(times)
        else:
            time_c = min(times)
    
    if time_a + time_b < time_c:
        return time_a + time_b
    else: return time_c



if __name__ == "__main__":
    chefs = {
        "A": [],
        "B": [],
        "C": [],
    }

    size = int(input())
    for _ in range(size):
        inp = input()
        chf = inp[0]
        time = int(inp[2:])
        chefs[chf].append(time)
    print(choseChefs(chefs))

    st = set()
    st.add()