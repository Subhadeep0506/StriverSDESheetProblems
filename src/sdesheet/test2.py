def isNLPCompatible(string):
    string = string.lower()
    chars = [0] * 26
    for c in string:
        if c.isalpha() and chars[ord(c) - ord('a')] == 0:
            chars[ord(c) - ord('a')] += 1

    return 1 if sum(chars) >= 26 else 0


string = "Apples were served as the dessert"
print(isNLPCompatible(string))
