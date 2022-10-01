class MinStack:
    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        min_val = float("inf")
        if self.stack:
            min_val = min(self.stack[-1][1], val)
        else:
            min_val = val
        self.stack.append([val, min_val])

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
# =============================== Optimized ==============================
class MinStackSpaceOptim:
    class MinStack:
    def __init__(self):
        self.stack = []
        self.min_val = float("inf")

    def push(self, val: int) -> None:
        # if stack is non empty
        if self.stack:
            # if curr val is smaller than min val
            if val < self.min_val:
                self.stack.append(2 * val - self.min_val)
                self.min_val = val
            else:
                self.stack.append(val)
        # if stack is empty, add the elemnt directly 
        else:
            self.min_val = val
            self.stack.append(val)

    def pop(self) -> None:
        if not self.stack:
            return
        curr = self.stack.pop()
        if curr < self.min_val:
            self.min_val = 2 * self.min_val - curr

    def top(self) -> int:
        top = self.stack[-1]
        if top < self.min_val:
            return self.min_val
        return top

    def getMin(self) -> int:
        return self.min_val

min_stack = MinStack()
min_stack.push(-2)
min_stack.push(0)
min_stack.push(-3)
print(min_stack.getMin())
min_stack.pop()
print(min_stack.top())
print(min_stack.getMin())