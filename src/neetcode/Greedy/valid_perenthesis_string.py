class ValidPerenthesisString:
    def checkValidString(self, s: str) -> bool:
        leftmin, leftmax = 0, 0

        for c in s:
            if c == '(':
                leftmin, leftmax = leftmin + 1, leftmax + 1
            elif c == ')':
                leftmin, leftmax = leftmin - 1, leftmax - 1
            else:
                leftmin, leftmax = leftmin - 1, leftmax + 1
            
            if leftmax < 0:
                return False
            if leftmin < 0:
                leftmin = 0
        return leftmin == 0